package wayoftime.bloodmagic.tile;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.mojang.datafixers.util.Pair;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tags.BlockTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.registries.ObjectHolder;
import wayoftime.bloodmagic.common.block.BlockShapedExplosive;

public class TileDeforesterCharge extends TileExplosiveCharge
{
	@ObjectHolder("bloodmagic:deforester_charge")
	public static TileEntityType<TileDeforesterCharge> TYPE;

	private Map<BlockPos, Boolean> treePartsMap;
	private List<BlockPos> treePartsCache;
	private boolean finishedAnalysis;
//	private Iterator<BlockPos> blockPosIterator;

//	private boolean cached = false;

	public double internalCounter = 0;

	public int currentLogs = 0;

	public int maxLogs = 128;

	public TileDeforesterCharge(TileEntityType<?> type, int maxLogs)
	{
		super(type);

		this.maxLogs = maxLogs;
	}

	public TileDeforesterCharge()
	{
		this(TYPE, 128);
	}

	@Override
	public void onUpdate()
	{
		if (level.isClientSide)
		{
			return;
		}
//		System.out.println("Counter: " + internalCounter);

		Direction explosiveDirection = this.getBlockState().getValue(BlockShapedExplosive.ATTACHED).getOpposite();
		BlockState attachedState = level.getBlockState(worldPosition.relative(explosiveDirection));
		if (!BlockTags.LOGS.contains(attachedState.getBlock()) && !BlockTags.LEAVES.contains(attachedState.getBlock()))
		{
			return;
		}

		if (treePartsMap == null)
		{
			treePartsMap = new HashMap<BlockPos, Boolean>();
			treePartsMap.put(worldPosition.relative(explosiveDirection), false);
			treePartsCache = new LinkedList<BlockPos>();
			treePartsCache.add(worldPosition.relative(explosiveDirection));
			internalCounter = 0;
//			treePartsMap.add(pos.offset(explosiveDirection));
		}

		boolean foundNew = false;
		List<BlockPos> newPositions = new LinkedList<BlockPos>();
		for (BlockPos currentPos : treePartsCache)
		{
			if (!treePartsMap.getOrDefault(currentPos, false)) // If the BlockPos wasn't checked yet
			{
//				BlockPos currentPos = entry.getKey();
				for (Direction dir : Direction.values())
				{
					BlockPos checkPos = currentPos.relative(dir);
					if (treePartsMap.containsKey(checkPos))
					{
						continue;
					}

					BlockState checkState = level.getBlockState(checkPos);

					boolean isTree = false;
					if (currentLogs >= maxLogs)
					{
						continue;
					}
					if (BlockTags.LOGS.contains(checkState.getBlock()))
					{
						currentLogs++;
						isTree = true;

					} else if (BlockTags.LEAVES.contains(checkState.getBlock()))
					{
						isTree = true;
					}

					if (isTree)
					{
						treePartsMap.put(checkPos, false);
						newPositions.add(checkPos);
						foundNew = true;
					}
				}

				treePartsMap.put(currentPos, true);
				if (currentLogs >= maxLogs)
				{
					finishedAnalysis = true;
					break;
				}
			}
		}

		treePartsCache.addAll(newPositions);

//		System.out.println("Found blocks: " + treePartsMap.size());

		if (foundNew)
		{
			return;
		}

		internalCounter++;
		if (internalCounter == 20)
		{
//			worldIn.playSound((PlayerEntity)null, tntentity.getPosX(), tntentity.getPosY(), tntentity.getPosZ(), SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
			level.playSound((PlayerEntity) null, this.getBlockPos().getX() + 0.5, this.getBlockPos().getY() + 0.5, this.getBlockPos().getZ() + 0.5, SoundEvents.FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, level.random.nextFloat() * 0.4F + 0.8F);
			((ServerWorld) this.level).sendParticles(ParticleTypes.FLAME, worldPosition.getX() + 0.5, worldPosition.getY() + 0.5, worldPosition.getZ() + 0.5, 5, 0.02, 0.03, 0.02, 0);
		}

		if (internalCounter == 30)
		{
			level.playSound((PlayerEntity) null, this.getBlockPos().getX() + 0.5, this.getBlockPos().getY() + 0.5, this.getBlockPos().getZ() + 0.5, SoundEvents.TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
		}

		if (internalCounter < 30)
		{
			return;
		}

		if (level.random.nextDouble() < 0.3)
		{
			((ServerWorld) this.level).sendParticles(ParticleTypes.SMOKE, worldPosition.getX() + 0.5, worldPosition.getY() + 0.5, worldPosition.getZ() + 0.5, 1, 0.0D, 0.0D, 0.0D, 0);
		}

		if (internalCounter == 100)
		{
			ItemStack toolStack = this.getHarvestingTool();
			level.playSound((PlayerEntity) null, this.getBlockPos().getX() + 0.5, this.getBlockPos().getY() + 0.5, this.getBlockPos().getZ() + 0.5, SoundEvents.GENERIC_EXPLODE, SoundCategory.BLOCKS, 4.0F, (1.0F + (level.random.nextFloat() - level.random.nextFloat()) * 0.2F) * 0.7F);

			int numParticles = 10;

			((ServerWorld) this.level).sendParticles(ParticleTypes.EXPLOSION, worldPosition.getX() + 0.5 + explosiveDirection.getStepX(), worldPosition.getY() + 0.5 + explosiveDirection.getStepY(), worldPosition.getZ() + 0.5 + explosiveDirection.getStepZ(), numParticles, 1.0D, 1.0D, 1.0D, 0);

			ObjectArrayList<Pair<ItemStack, BlockPos>> objectarraylist = new ObjectArrayList<>();

			for (BlockPos blockPos : treePartsCache)
			{
//				BlockPos blockpos = initialPos.offset(explosiveDirection, i).offset(sweepDir1, j).offset(sweepDir2, k);

				BlockState blockstate = this.level.getBlockState(blockPos);
				Block block = blockstate.getBlock();
				if (!blockstate.isAir(this.level, blockPos))
				{
					BlockPos blockpos1 = blockPos.immutable();
//				this.world.getProfiler().startSection("explosion_blocks");
					if (this.level instanceof ServerWorld)
					{
						TileEntity tileentity = blockstate.hasTileEntity() ? this.level.getBlockEntity(blockPos) : null;
						LootContext.Builder lootcontext$builder = (new LootContext.Builder((ServerWorld) this.level)).withRandom(this.level.random).withParameter(LootParameters.ORIGIN, Vector3d.atCenterOf(blockPos)).withParameter(LootParameters.TOOL, toolStack).withOptionalParameter(LootParameters.BLOCK_ENTITY, tileentity);
//                  if (this.mode == Explosion.Mode.DESTROY) {
//                     lootcontext$builder.withParameter(LootParameters.EXPLOSION_RADIUS, this.size);
//                  }

						blockstate.getDrops(lootcontext$builder).forEach((stack) -> {
							handleExplosionDrops(objectarraylist, stack, blockpos1);
						});

						level.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 3);

//				blockstate.onBlockExploded(this.world, blockpos, null);
//               this.world.getProfiler().endSection();
					}
				}
			}

			for (Pair<ItemStack, BlockPos> pair : objectarraylist)
			{
				Block.popResource(this.level, pair.getSecond(), pair.getFirst());
			}

			level.setBlockAndUpdate(getBlockPos(), Blocks.AIR.defaultBlockState());
		}
	}

	@Override
	public void deserialize(CompoundNBT tag)
	{
		internalCounter = tag.getDouble("internalCounter");
	}

	@Override
	public CompoundNBT serialize(CompoundNBT tag)
	{
		tag.putDouble("internalCounter", internalCounter);
		return tag;
	}
}