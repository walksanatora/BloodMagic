package wayoftime.bloodmagic.common.item;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import wayoftime.bloodmagic.BloodMagic;
import wayoftime.bloodmagic.common.block.BloodMagicBlocks;
import wayoftime.bloodmagic.common.item.arc.ItemARCToolBase;
import wayoftime.bloodmagic.common.item.block.ItemBlockAlchemyTable;
import wayoftime.bloodmagic.common.item.sigil.ItemSigilAir;
import wayoftime.bloodmagic.common.item.sigil.ItemSigilBloodLight;
import wayoftime.bloodmagic.common.item.sigil.ItemSigilDivination;
import wayoftime.bloodmagic.common.item.sigil.ItemSigilFastMiner;
import wayoftime.bloodmagic.common.item.sigil.ItemSigilFrost;
import wayoftime.bloodmagic.common.item.sigil.ItemSigilGreenGrove;
import wayoftime.bloodmagic.common.item.sigil.ItemSigilLava;
import wayoftime.bloodmagic.common.item.sigil.ItemSigilMagnetism;
import wayoftime.bloodmagic.common.item.sigil.ItemSigilVoid;
import wayoftime.bloodmagic.common.item.sigil.ItemSigilWater;
import wayoftime.bloodmagic.common.item.soul.ItemMonsterSoul;
import wayoftime.bloodmagic.common.item.soul.ItemSentientAxe;
import wayoftime.bloodmagic.common.item.soul.ItemSentientPickaxe;
import wayoftime.bloodmagic.common.item.soul.ItemSentientShovel;
import wayoftime.bloodmagic.common.item.soul.ItemSentientSword;
import wayoftime.bloodmagic.common.item.soul.ItemSoulGem;
import wayoftime.bloodmagic.common.item.soul.ItemSoulSnare;
import wayoftime.bloodmagic.common.registration.impl.BloodOrbDeferredRegister;
import wayoftime.bloodmagic.common.registration.impl.BloodOrbRegistryObject;
import wayoftime.bloodmagic.orb.BloodOrb;
import wayoftime.bloodmagic.ritual.EnumRuneType;
import wayoftime.bloodmagic.structures.ItemDungeonTester;
import wayoftime.bloodmagic.will.EnumDemonWillType;

public class BloodMagicItems
{
//	public static Item.ToolMaterial SOUL_TOOL_MATERIAL = EnumHelper.addToolMaterial("demonic", 4, 520, 7, 8, 50);
//	public static final BloodOrb WEAK_ORB_INSTANCE = new BloodOrb(new ResourceLocation(BloodMagic.MODID, "weakbloodorb"), 0, 5000, 10);
	public static final BloodOrbDeferredRegister BLOOD_ORBS = new BloodOrbDeferredRegister(BloodMagic.MODID);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BloodMagic.MODID);
	public static final DeferredRegister<Item> BASICITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BloodMagic.MODID);

	public static final BloodOrbRegistryObject<BloodOrb> ORB_WEAK = BLOOD_ORBS.register("weakbloodorb", () -> new BloodOrb(new ResourceLocation(BloodMagic.MODID, "weakbloodorb"), 1, 5000, 2));
	public static final BloodOrbRegistryObject<BloodOrb> ORB_APPRENTICE = BLOOD_ORBS.register("apprenticebloodorb", () -> new BloodOrb(new ResourceLocation(BloodMagic.MODID, "apprenticebloodorb"), 2, 25000, 5));
	public static final BloodOrbRegistryObject<BloodOrb> ORB_MAGICIAN = BLOOD_ORBS.register("magicianbloodorb", () -> new BloodOrb(new ResourceLocation(BloodMagic.MODID, "magicianbloodorb"), 3, 150000, 15));
	public static final BloodOrbRegistryObject<BloodOrb> ORB_MASTER = BLOOD_ORBS.register("masterbloodorb", () -> new BloodOrb(new ResourceLocation(BloodMagic.MODID, "masterbloodorb"), 4, 1000000, 25));
	public static final BloodOrbRegistryObject<BloodOrb> ORB_ARCHMAGE = BLOOD_ORBS.register("archmagebloodorb", () -> new BloodOrb(new ResourceLocation(BloodMagic.MODID, "archmagebloodorb"), 5, 10000000, 50));
//	public static final DeferredRegister<BloodOrb> BLOOD_ORBS = DeferredRegister.create(RegistrarBloodMagic.BLOOD_ORBS, BloodMagic.MODID);

//	public static final RegistryObject<Item> BLOODSTONE_ITEM = ITEMS.register("ruby_block", () -> new BlockItem(BloodMagicBlocks.BLOODSTONE.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> SOUL_FORGE_ITEM = ITEMS.register("soulforge", () -> new BlockItem(BloodMagicBlocks.SOUL_FORGE.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> BLANK_RUNE_ITEM = ITEMS.register("blankrune", () -> new BlockItem(BloodMagicBlocks.BLANK_RUNE.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> SPEED_RUNE_ITEM = ITEMS.register("speedrune", () -> new BlockItem(BloodMagicBlocks.SPEED_RUNE.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> SACRIFICE_RUNE_ITEM = ITEMS.register("sacrificerune", () -> new BlockItem(BloodMagicBlocks.SACRIFICE_RUNE.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> SELF_SACRIFICE_RUNE_ITEM = ITEMS.register("selfsacrificerune", () -> new BlockItem(BloodMagicBlocks.SELF_SACRIFICE_RUNE.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> DISPLACEMENT_RUNE_ITEM = ITEMS.register("dislocationrune", () -> new BlockItem(BloodMagicBlocks.DISPLACEMENT_RUNE.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> CAPACITY_RUNE_ITEM = ITEMS.register("altarcapacityrune", () -> new BlockItem(BloodMagicBlocks.CAPACITY_RUNE.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> AUGMENTED_CAPACITY_RUNE_ITEM = ITEMS.register("bettercapacityrune", () -> new BlockItem(BloodMagicBlocks.AUGMENTED_CAPACITY_RUNE.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> ORB_RUNE_ITEM = ITEMS.register("orbcapacityrune", () -> new BlockItem(BloodMagicBlocks.ORB_RUNE.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> ACCELERATION_RUNE_ITEM = ITEMS.register("accelerationrune", () -> new BlockItem(BloodMagicBlocks.ACCELERATION_RUNE.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> CHARGING_RUNE_ITEM = ITEMS.register("chargingrune", () -> new BlockItem(BloodMagicBlocks.CHARGING_RUNE.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> BLANK_RITUAL_STONE_ITEM = ITEMS.register("ritualstone", () -> new BlockItem(BloodMagicBlocks.BLANK_RITUAL_STONE.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> AIR_RITUAL_STONE_ITEM = ITEMS.register("airritualstone", () -> new BlockItem(BloodMagicBlocks.AIR_RITUAL_STONE.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> WATER_RITUAL_STONE_ITEM = ITEMS.register("waterritualstone", () -> new BlockItem(BloodMagicBlocks.WATER_RITUAL_STONE.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> FIRE_RITUAL_STONE_ITEM = ITEMS.register("fireritualstone", () -> new BlockItem(BloodMagicBlocks.FIRE_RITUAL_STONE.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> EARTH_RITUAL_STONE_ITEM = ITEMS.register("earthritualstone", () -> new BlockItem(BloodMagicBlocks.EARTH_RITUAL_STONE.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> DUSK_RITUAL_STONE_ITEM = ITEMS.register("duskritualstone", () -> new BlockItem(BloodMagicBlocks.DUSK_RITUAL_STONE.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> DAWN_RITUAL_STONE_ITEM = ITEMS.register("lightritualstone", () -> new BlockItem(BloodMagicBlocks.DAWN_RITUAL_STONE.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> ALCHEMICAL_REACTION_CHAMBER_ITEM = ITEMS.register("alchemicalreactionchamber", () -> new BlockItem(BloodMagicBlocks.ALCHEMICAL_REACTION_CHAMBER.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> DEMON_CRUCIBLE_ITEM = ITEMS.register("demoncrucible", () -> new BlockItem(BloodMagicBlocks.DEMON_CRUCIBLE.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> DEMON_CRYSTALLIZER_ITEM = ITEMS.register("demoncrystallizer", () -> new BlockItem(BloodMagicBlocks.DEMON_CRYSTALLIZER.get(), new Item.Properties().group(BloodMagic.TAB)));

	public static final RegistryObject<Item> BLOODSTONE_ITEM = ITEMS.register("largebloodstonebrick", () -> new BlockItem(BloodMagicBlocks.BLOODSTONE.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> BLOODSTONE_BRICK_ITEM = ITEMS.register("bloodstonebrick", () -> new BlockItem(BloodMagicBlocks.BLOODSTONE_BRICK.get(), new Item.Properties().group(BloodMagic.TAB)));

	public static final RegistryObject<Item> MASTER_RITUAL_STONE_ITEM = ITEMS.register("masterritualstone", () -> new BlockItem(BloodMagicBlocks.MASTER_RITUAL_STONE.get(), new Item.Properties().group(BloodMagic.TAB)));

	public static final RegistryObject<Item> BLOOD_ALTAR_ITEM = ITEMS.register("altar", () -> new BlockItem(BloodMagicBlocks.BLOOD_ALTAR.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> ALCHEMY_TABLE_ITEM = ITEMS.register("alchemytable", () -> new ItemBlockAlchemyTable(BloodMagicBlocks.ALCHEMY_TABLE.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> INCENSE_ALTAR_ITEM = ITEMS.register("incensealtar", () -> new BlockItem(BloodMagicBlocks.INCENSE_ALTAR.get(), new Item.Properties().group(BloodMagic.TAB)));

	public static final RegistryObject<Item> WOOD_PATH_ITEM = ITEMS.register("woodbrickpath", () -> new BlockItem(BloodMagicBlocks.WOOD_PATH.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> WOOD_TILE_PATH_ITEM = ITEMS.register("woodtilepath", () -> new BlockItem(BloodMagicBlocks.WOOD_TILE_PATH.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> STONE_PATH_ITEM = ITEMS.register("stonebrickpath", () -> new BlockItem(BloodMagicBlocks.STONE_PATH.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> STONE_TILE_PATH_ITEM = ITEMS.register("stonetilepath", () -> new BlockItem(BloodMagicBlocks.STONE_TILE_PATH.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> WORN_STONE_PATH_ITEM = ITEMS.register("wornstonebrickpath", () -> new BlockItem(BloodMagicBlocks.WORN_STONE_PATH.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> WORN_STONE_TILE_PATH_ITEM = ITEMS.register("wornstonetilepath", () -> new BlockItem(BloodMagicBlocks.WORN_STONE_TILE_PATH.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> OBSIDIAN_PATH_ITEM = ITEMS.register("obsidianbrickpath", () -> new BlockItem(BloodMagicBlocks.OBSIDIAN_PATH.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> OBSIDIAN_TILE_PATH_ITEM = ITEMS.register("obsidiantilepath", () -> new BlockItem(BloodMagicBlocks.OBSIDIAN_TILE_PATH.get(), new Item.Properties().group(BloodMagic.TAB)));

	// TODO: Need to rework the above instantiations for the ItemBlocks so that it's
	// done with the Blocks.

//	public static final RegistryObject<Item> WEAK_BLOOD_ORB = BASICITEMS.register("weakbloodorb", ItemBloodOrb::new);
//	public static final RegistryObject<Item> WEAK_BLOOD_ORB = BASICITEMS.register("weakbloodorb", () -> new ItemBloodOrb(WEAK_ORB_INSTANCE));
	public static final RegistryObject<Item> WEAK_BLOOD_ORB = BASICITEMS.register("weakbloodorb", () -> new ItemBloodOrb(ORB_WEAK));
	public static final RegistryObject<Item> APPRENTICE_BLOOD_ORB = BASICITEMS.register("apprenticebloodorb", () -> new ItemBloodOrb(ORB_APPRENTICE));
	public static final RegistryObject<Item> MAGICIAN_BLOOD_ORB = BASICITEMS.register("magicianbloodorb", () -> new ItemBloodOrb(ORB_MAGICIAN));
	public static final RegistryObject<Item> MASTER_BLOOD_ORB = BASICITEMS.register("masterbloodorb", () -> new ItemBloodOrb(ORB_MASTER));

	public static final RegistryObject<Item> DIVINATION_SIGIL = BASICITEMS.register("divinationsigil", () -> new ItemSigilDivination(true));
	public static final RegistryObject<Item> SEER_SIGIL = BASICITEMS.register("seersigil", () -> new ItemSigilDivination(false));
	public static final RegistryObject<Item> SACRIFICIAL_DAGGER = BASICITEMS.register("sacrificialdagger", () -> new ItemSacrificialDagger());
	public static final RegistryObject<Item> SLATE = BASICITEMS.register("blankslate", () -> new ItemBase());
	public static final RegistryObject<Item> REINFORCED_SLATE = BASICITEMS.register("reinforcedslate", () -> new ItemBase());
	public static final RegistryObject<Item> IMBUED_SLATE = BASICITEMS.register("infusedslate", () -> new ItemBase());
	public static final RegistryObject<Item> DEMONIC_SLATE = BASICITEMS.register("demonslate", () -> new ItemBase());
	public static final RegistryObject<Item> ETHEREAL_SLATE = BASICITEMS.register("etherealslate", () -> new ItemBase());
	public static final RegistryObject<Item> WATER_SIGIL = BASICITEMS.register("watersigil", () -> new ItemSigilWater());
	public static final RegistryObject<Item> VOID_SIGIL = BASICITEMS.register("voidsigil", () -> new ItemSigilVoid());
	public static final RegistryObject<Item> LAVA_SIGIL = BASICITEMS.register("lavasigil", () -> new ItemSigilLava());
	public static final RegistryObject<Item> GREEN_GROVE_SIGIL = ITEMS.register("growthsigil", () -> new ItemSigilGreenGrove());
	public static final RegistryObject<Item> FAST_MINER_SIGIL = ITEMS.register("miningsigil", () -> new ItemSigilFastMiner());
	public static final RegistryObject<Item> MAGNETISM_SIGIL = ITEMS.register("sigilofmagnetism", () -> new ItemSigilMagnetism());
	public static final RegistryObject<Item> ICE_SIGIL = ITEMS.register("icesigil", () -> new ItemSigilFrost());
	public static final RegistryObject<Item> AIR_SIGIL = BASICITEMS.register("airsigil", ItemSigilAir::new);
	public static final RegistryObject<Item> BLOOD_LIGHT_SIGIL = BASICITEMS.register("bloodlightsigil", ItemSigilBloodLight::new);

	public static final RegistryObject<Item> ARCANE_ASHES = BASICITEMS.register("arcaneashes", () -> new ItemArcaneAshes());
	public static final RegistryObject<Item> DAGGER_OF_SACRIFICE = BASICITEMS.register("daggerofsacrifice", () -> new ItemDaggerOfSacrifice());
	public static final RegistryObject<Item> LAVA_CRYSTAL = BASICITEMS.register("lavacrystal", () -> new ItemLavaCrystal());
	public static final RegistryObject<Item> WEAK_BLOOD_SHARD = BASICITEMS.register("weakbloodshard", () -> new ItemBase());

	// Ritual stuffs
	public static final RegistryObject<Item> WEAK_ACTIVATION_CRYSTAL = BASICITEMS.register("activationcrystalweak", () -> new ItemActivationCrystal(ItemActivationCrystal.CrystalType.WEAK));
	public static final RegistryObject<Item> AWAKENED_ACTIVATION_CRYSTAL = BASICITEMS.register("activationcrystalawakened", () -> new ItemActivationCrystal(ItemActivationCrystal.CrystalType.AWAKENED));
	public static final RegistryObject<Item> CREATIVE_ACTIVATION_CRYSTAL = BASICITEMS.register("activationcrystalcreative", () -> new ItemActivationCrystal(ItemActivationCrystal.CrystalType.CREATIVE));

	public static final RegistryObject<Item> AIR_INSCRIPTION_TOOL = BASICITEMS.register("airscribetool", () -> new ItemInscriptionTool(EnumRuneType.AIR));
	public static final RegistryObject<Item> FIRE_INSCRIPTION_TOOL = BASICITEMS.register("firescribetool", () -> new ItemInscriptionTool(EnumRuneType.FIRE));
	public static final RegistryObject<Item> WATER_INSCRIPTION_TOOL = BASICITEMS.register("waterscribetool", () -> new ItemInscriptionTool(EnumRuneType.WATER));
	public static final RegistryObject<Item> EARTH_INSCRIPTION_TOOL = BASICITEMS.register("earthscribetool", () -> new ItemInscriptionTool(EnumRuneType.EARTH));
	public static final RegistryObject<Item> DUSK_INSCRIPTION_TOOL = BASICITEMS.register("duskscribetool", () -> new ItemInscriptionTool(EnumRuneType.DUSK));

	public static final RegistryObject<Item> BASE_RITUAL_DIVINER = BASICITEMS.register("ritualdiviner", () -> new ItemRitualDiviner(0));
	public static final RegistryObject<Item> DUSK_RITUAL_DIVINER = BASICITEMS.register("ritualdivinerdusk", () -> new ItemRitualDiviner(1));

	public static final RegistryObject<Item> RITUAL_READER = BASICITEMS.register("ritualtinkerer", ItemRitualReader::new);

	// Reagents used to make the Sigils
	public static final RegistryObject<Item> REAGENT_WATER = BASICITEMS.register("reagentwater", () -> new ItemBase());
	public static final RegistryObject<Item> REAGENT_LAVA = BASICITEMS.register("reagentlava", () -> new ItemBase());
	public static final RegistryObject<Item> REAGENT_VOID = BASICITEMS.register("reagentvoid", () -> new ItemBase());
	public static final RegistryObject<Item> REAGENT_GROWTH = BASICITEMS.register("reagentgrowth", () -> new ItemBase());
	public static final RegistryObject<Item> REAGENT_FAST_MINER = BASICITEMS.register("reagentfastminer", () -> new ItemBase());
	public static final RegistryObject<Item> REAGENT_MAGNETISM = BASICITEMS.register("reagentmagnetism", () -> new ItemBase());
	public static final RegistryObject<Item> REAGENT_AIR = BASICITEMS.register("reagentair", () -> new ItemBase());
	public static final RegistryObject<Item> REAGENT_BLOOD_LIGHT = BASICITEMS.register("reagentbloodlight", () -> new ItemBase());
	public static final RegistryObject<Item> REAGENT_SIGHT = BASICITEMS.register("reagentsight", () -> new ItemBase());

	// Tartaric Gems
	public static final RegistryObject<Item> PETTY_GEM = ITEMS.register("soulgempetty", () -> new ItemSoulGem("petty", 64));
	public static final RegistryObject<Item> LESSER_GEM = ITEMS.register("soulgemlesser", () -> new ItemSoulGem("lesser", 256));
	public static final RegistryObject<Item> COMMON_GEM = ITEMS.register("soulgemcommon", () -> new ItemSoulGem("common", 1024));
	public static final RegistryObject<Item> GREATER_GEM = ITEMS.register("soulgemgreater", () -> new ItemSoulGem("greater", 4096));

	public static final RegistryObject<Item> MONSTER_SOUL_RAW = BASICITEMS.register("basemonstersoul", () -> new ItemMonsterSoul(EnumDemonWillType.DEFAULT));
	public static final RegistryObject<Item> MONSTER_SOUL_CORROSIVE = BASICITEMS.register("basemonstersoul_corrosive", () -> new ItemMonsterSoul(EnumDemonWillType.CORROSIVE));
	public static final RegistryObject<Item> MONSTER_SOUL_DESTRUCTIVE = BASICITEMS.register("basemonstersoul_destructive", () -> new ItemMonsterSoul(EnumDemonWillType.DESTRUCTIVE));
	public static final RegistryObject<Item> MONSTER_SOUL_STEADFAST = BASICITEMS.register("basemonstersoul_steadfast", () -> new ItemMonsterSoul(EnumDemonWillType.STEADFAST));
	public static final RegistryObject<Item> MONSTER_SOUL_VENGEFUL = BASICITEMS.register("basemonstersoul_vengeful", () -> new ItemMonsterSoul(EnumDemonWillType.VENGEFUL));

	public static final RegistryObject<Item> SOUL_SNARE = BASICITEMS.register("soulsnare", ItemSoulSnare::new);
	public static final RegistryObject<Item> SENTIENT_SWORD = ITEMS.register("soulsword", () -> new ItemSentientSword());
	public static final RegistryObject<Item> SENTIENT_AXE = ITEMS.register("soulaxe", () -> new ItemSentientAxe());
	public static final RegistryObject<Item> SENTIENT_PICKAXE = ITEMS.register("soulpickaxe", () -> new ItemSentientPickaxe());
	public static final RegistryObject<Item> SENTIENT_SHOVEL = ITEMS.register("soulshovel", () -> new ItemSentientShovel());

	public static final RegistryObject<Item> RAW_CRYSTAL_BLOCK_ITEM = ITEMS.register("rawdemoncrystal", () -> new BlockItem(BloodMagicBlocks.RAW_CRYSTAL_BLOCK.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> CORROSIVE_CRYSTAL_BLOCK_ITEM = ITEMS.register("corrosivedemoncrystal", () -> new BlockItem(BloodMagicBlocks.CORROSIVE_CRYSTAL_BLOCK.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> DESTRUCTIVE_CRYSTAL_BLOCK_ITEM = ITEMS.register("destructivedemoncrystal", () -> new BlockItem(BloodMagicBlocks.DESTRUCTIVE_CRYSTAL_BLOCK.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> VENGEFUL_CRYSTAL_BLOCK_ITEM = ITEMS.register("vengefuldemoncrystal", () -> new BlockItem(BloodMagicBlocks.VENGEFUL_CRYSTAL_BLOCK.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> STEADFAST_CRYSTAL_BLOCK_ITEM = ITEMS.register("steadfastdemoncrystal", () -> new BlockItem(BloodMagicBlocks.STEADFAST_CRYSTAL_BLOCK.get(), new Item.Properties().group(BloodMagic.TAB)));

	public static final RegistryObject<Item> RAW_CRYSTAL = BASICITEMS.register("defaultcrystal", () -> new ItemDemonCrystal(EnumDemonWillType.DEFAULT));
	public static final RegistryObject<Item> CORROSIVE_CRYSTAL = BASICITEMS.register("corrosivecrystal", () -> new ItemDemonCrystal(EnumDemonWillType.CORROSIVE));
	public static final RegistryObject<Item> VENGEFUL_CRYSTAL = BASICITEMS.register("vengefulcrystal", () -> new ItemDemonCrystal(EnumDemonWillType.VENGEFUL));
	public static final RegistryObject<Item> DESTRUCTIVE_CRYSTAL = BASICITEMS.register("destructivecrystal", () -> new ItemDemonCrystal(EnumDemonWillType.DESTRUCTIVE));
	public static final RegistryObject<Item> STEADFAST_CRYSTAL = BASICITEMS.register("steadfastcrystal", () -> new ItemDemonCrystal(EnumDemonWillType.STEADFAST));

	public static final RegistryObject<Item> DEMON_WILL_GAUGE = BASICITEMS.register("demonwillgauge", ItemDemonWillGauge::new);

	// ARC Tools
	public static final RegistryObject<Item> SANGUINE_REVERTER = BASICITEMS.register("sanguinereverter", () -> new ItemARCToolBase(32, 2));
	public static final RegistryObject<Item> PRIMITIVE_FURNACE_CELL = BASICITEMS.register("furnacecell_primitive", () -> new ItemARCToolBase(128, 1.25));
	public static final RegistryObject<Item> PRIMITIVE_EXPLOSIVE_CELL = BASICITEMS.register("primitive_explosive_cell", () -> new ItemARCToolBase(256, 1.25));
	public static final RegistryObject<Item> PRIMITIVE_HYDRATION_CELL = BASICITEMS.register("primitive_hydration_cell", () -> new ItemARCToolBase(128, 1.25));
	public static final RegistryObject<Item> PRIMITIVE_CRYSTALLINE_RESONATOR = BASICITEMS.register("primitive_crystalline_resonator", () -> new ItemARCToolBase(128, 1.25));
	public static final RegistryObject<Item> CRYSTALLINE_RESONATOR = BASICITEMS.register("crystalline_resonator", () -> new ItemARCToolBase(512, 2, 2));

	// Alchemy Table items
	public static final RegistryObject<Item> BASIC_CUTTING_FLUID = BASICITEMS.register("basiccuttingfluid", () -> new ItemARCToolBase(64, 1));
	public static final RegistryObject<Item> EXPLOSIVE_POWDER = BASICITEMS.register("explosivepowder", () -> new ItemARCToolBase(64, 1));

	public static final RegistryObject<Item> SULFUR = BASICITEMS.register("sulfur", () -> new ItemBase());
	public static final RegistryObject<Item> SALTPETER = BASICITEMS.register("saltpeter", () -> new ItemBase());
	public static final RegistryObject<Item> PLANT_OIL = BASICITEMS.register("plantoil", () -> new ItemBase());

	// Fragments
	public static final RegistryObject<Item> IRON_FRAGMENT = BASICITEMS.register("ironfragment", () -> new ItemBase());
	public static final RegistryObject<Item> GOLD_FRAGMENT = BASICITEMS.register("goldfragment", () -> new ItemBase());

	// Gravels
	public static final RegistryObject<Item> IRON_GRAVEL = BASICITEMS.register("irongravel", () -> new ItemBase());
	public static final RegistryObject<Item> GOLD_GRAVEL = BASICITEMS.register("goldgravel", () -> new ItemBase());

	// Sands
	public static final RegistryObject<Item> IRON_SAND = BASICITEMS.register("ironsand", () -> new ItemBase());
	public static final RegistryObject<Item> GOLD_SAND = BASICITEMS.register("goldsand", () -> new ItemBase());
	public static final RegistryObject<Item> COAL_SAND = BASICITEMS.register("coalsand", () -> new ItemBase());

	// Dungeons
	public static final RegistryObject<Item> DUNGEON_BRICK_1_BLOCK = ITEMS.register("dungeon_brick1", () -> new BlockItem(BloodMagicBlocks.DUNGEON_BRICK_1.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> DUNGEON_BRICK_2_BLOCK = ITEMS.register("dungeon_brick2", () -> new BlockItem(BloodMagicBlocks.DUNGEON_BRICK_2.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> DUNGEON_BRICK_3_BLOCK = ITEMS.register("dungeon_brick3", () -> new BlockItem(BloodMagicBlocks.DUNGEON_BRICK_3.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> DUNGEON_BRICK_ASSORTED_BLOCK = ITEMS.register("dungeon_brick_assorted", () -> new BlockItem(BloodMagicBlocks.DUNGEON_BRICK_ASSORTED.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> DUNGEON_STONE_BLOCK = ITEMS.register("dungeon_stone", () -> new BlockItem(BloodMagicBlocks.DUNGEON_STONE.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> DUNGEON_EYE = ITEMS.register("dungeon_eye", () -> new BlockItem(BloodMagicBlocks.DUNGEON_EYE.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> DUNGEON_POLISHED_STONE_BLOCK = ITEMS.register("dungeon_polished", () -> new BlockItem(BloodMagicBlocks.DUNGEON_POLISHED_STONE.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> DUNGEON_TILE_BLOCK = ITEMS.register("dungeon_tile", () -> new BlockItem(BloodMagicBlocks.DUNGEON_TILE.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> DUNGEON_TILE_SPECIAL_BLOCK = ITEMS.register("dungeon_tilespecial", () -> new BlockItem(BloodMagicBlocks.DUNGEON_TILE_SPECIAL.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> DUNGEON_SMALL_BRICK_BLOCK = ITEMS.register("dungeon_smallbrick", () -> new BlockItem(BloodMagicBlocks.DUNGEON_SMALL_BRICK.get(), new Item.Properties().group(BloodMagic.TAB)));

	public static final RegistryObject<Item> DUNGEON_BRICK_STAIRS_BLOCK = ITEMS.register("dungeon_brick_stairs", () -> new BlockItem(BloodMagicBlocks.DUNGEON_BRICK_STAIRS.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> DUNGEON_POLISHED_STAIRS_BLOCK = ITEMS.register("dungeon_polished_stairs", () -> new BlockItem(BloodMagicBlocks.DUNGEON_POLISHED_STAIRS.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> DUNGEON_PILLAR_CENTER_BLOCK = ITEMS.register("dungeon_pillar_center", () -> new BlockItem(BloodMagicBlocks.DUNGEON_PILLAR_CENTER.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> DUNGEON_PILLAR_SPECIAL_BLOCK = ITEMS.register("dungeon_pillar_special", () -> new BlockItem(BloodMagicBlocks.DUNGEON_PILLAR_SPECIAL.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> DUNGEON_PILLAR_CAP_BLOCK = ITEMS.register("dungeon_pillar_cap", () -> new BlockItem(BloodMagicBlocks.DUNGEON_PILLAR_CAP.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> DUNGEON_BRICK_WALL_BLOCK = ITEMS.register("dungeon_brick_wall", () -> new BlockItem(BloodMagicBlocks.DUNGEON_BRICK_WALL.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> DUNGEON_POLISHED_WALL_BLOCK = ITEMS.register("dungeon_polished_wall", () -> new BlockItem(BloodMagicBlocks.DUNGEON_POLISHED_WALL.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> DUNGEON_BRICK_GATE_BLOCK = ITEMS.register("dungeon_brick_gate", () -> new BlockItem(BloodMagicBlocks.DUNGEON_BRICK_GATE.get(), new Item.Properties().group(BloodMagic.TAB)));
	public static final RegistryObject<Item> DUNGEON_POLISHED_GATE_BLOCK = ITEMS.register("dungeon_polished_gate", () -> new BlockItem(BloodMagicBlocks.DUNGEON_POLISHED_GATE.get(), new Item.Properties().group(BloodMagic.TAB)));

	public static final RegistryObject<Item> DUNGEON_ORE_BLOCK = ITEMS.register("dungeon_ore", () -> new BlockItem(BloodMagicBlocks.DUNGEON_ORE.get(), new Item.Properties().group(BloodMagic.TAB)));

	public static final RegistryObject<Item> DUNGEON_TESTER = BASICITEMS.register("dungeon_tester", ItemDungeonTester::new);

}