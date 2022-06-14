package wayoftime.bloodmagic.common.item;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import wayoftime.bloodmagic.BloodMagic;
import wayoftime.bloodmagic.api.compat.EnumDemonWillType;
import wayoftime.bloodmagic.entity.projectile.AbstractEntityThrowingDagger;
import wayoftime.bloodmagic.entity.projectile.EntityThrowingDagger;
import wayoftime.bloodmagic.will.PlayerDemonWillHandler;

public class ItemThrowingDagger extends Item
{
	public static int[] soulBracket = new int[] { 1, 60, 200, 400, 1000, 2000, 4000 };

	public static double[] soulDrop = new double[] { 2, 4, 7, 10, 13, 15, 18 };
	public static double[] staticDrop = new double[] { 1, 1, 2, 3, 3, 4, 4 };

	public ItemThrowingDagger()
	{
		super(new Item.Properties().stacksTo(64).tab(BloodMagic.TAB));

//		setTranslationKey(BloodMagic.MODID + ".soulSnare.");
//		setCreativeTab(BloodMagic.TAB_BM);
//		setHasSubtypes(true);
//		setMaxStackSize(16);
	}

	@Override
	public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand hand)
	{
		ItemStack stack = playerIn.getItemInHand(hand);
		if (!playerIn.isCreative())
		{
			stack.shrink(1);
		}
		playerIn.getCooldowns().addCooldown(this, 50);

		worldIn.playSound((PlayerEntity) null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));

		if (!worldIn.isClientSide)
		{
//			System.out.println("Attempting to spawn");
//			EntitySoulSnare snare = new EntitySoulSnare(worldIn, playerIn);
//			snare.shootFromRotation(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
//			worldIn.addEntity(snare);
			EnumDemonWillType largestType = PlayerDemonWillHandler.getLargestWillType(playerIn);
			double souls = PlayerDemonWillHandler.getTotalDemonWill(largestType, playerIn);

			ItemStack copyStack = stack.copy();
			copyStack.setCount(1);
			AbstractEntityThrowingDagger dagger = getDagger(copyStack, worldIn, playerIn);

			int level = getLevel(souls);
			if (level >= 0)
			{
				double willDrop = (soulDrop[level] * worldIn.random.nextDouble() + staticDrop[level]);
				dagger.setWillDrop(willDrop);
				dagger.setWillType(largestType);
			}

			worldIn.addFreshEntity(dagger);
//			
//			SnowballEntity snowballentity = new SnowballEntity(worldIn, playerIn);
//	         snowballentity.setItem(itemstack);
//	         snowballentity.shootFromRotation(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
//	         worldIn.addEntity(snowballentity);
		}

		return new ActionResult<>(ActionResultType.SUCCESS, stack);
	}

	public AbstractEntityThrowingDagger getDagger(ItemStack stack, World world, PlayerEntity player)
	{
		AbstractEntityThrowingDagger dagger = new EntityThrowingDagger(stack, world, player);
		dagger.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 3F, 0.5F);
		dagger.setDamage(10);
		return dagger;
	}

	private int getLevel(double soulsRemaining)
	{
		int lvl = -1;
		for (int i = 0; i < soulBracket.length; i++)
		{
			if (soulsRemaining >= soulBracket[i])
			{
				lvl = i;
			}
		}

		return lvl;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flag)
	{
		tooltip.add(new TranslationTextComponent("tooltip.bloodmagic.throwing_dagger.desc").withStyle(TextFormatting.ITALIC).withStyle(TextFormatting.GRAY));

		super.appendHoverText(stack, world, tooltip, flag);
	}
}
