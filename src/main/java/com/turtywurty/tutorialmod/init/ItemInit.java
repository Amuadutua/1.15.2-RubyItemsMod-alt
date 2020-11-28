package com.turtywurty.tutorialmod.init;

import com.turtywurty.tutorialmod.TutorialMod;
import com.turtywurty.tutorialmod.TutorialMod.TutorialItemGroup;
import com.turtywurty.tutorialmod.items.TorchBow;
import com.turtywurty.tutorialmod.objects.blocks.BlockItemBase;
import com.turtywurty.tutorialmod.objects.items.ModMusicDiscItem;
import com.turtywurty.tutorialmod.objects.items.ModSpawnEggItem;
import com.turtywurty.tutorialmod.objects.items.SpecialItem;
import com.turtywurty.tutorialmod.util.enums.ModArmorMaterials;
import com.turtywurty.tutorialmod.util.enums.ModItemTiers;

import com.turtywurty.tutorialmod.util.enums.ModItemTiers2;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Rarity;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.WallOrFloorItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS,
			TutorialMod.MOD_ID);

	// Items
	public static final RegistryObject<SpecialItem> DEF_ITEM = ITEMS.register("def_item",
			() -> new SpecialItem(new Item.Properties().group(TutorialItemGroup.instance)));

	public static final RegistryObject<BlockItem> SEED_ITEM = ITEMS.register("seed_item",
			() -> new BlockItem(BlockInit.EXAMPLE_CROP.get(), new Item.Properties().group(TutorialItemGroup.instance)));

	public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item",
			() -> new Item(new Item.Properties().group(TutorialItemGroup.instance)));

	public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
			() -> new Item(new Item.Properties().group(TutorialItemGroup.instance)));

	public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
			() -> new Item(new Item.Properties().group(TutorialItemGroup.instance)));

	public static final RegistryObject<Item> AMETHYST = ITEMS.register("amethyst",
			() -> new Item(new Item.Properties().group(TutorialItemGroup.instance)));

	public static final RegistryObject<Item> RUBY_ITEM = ITEMS.register("ruby_item",
			() -> new Item(new Item.Properties().group(TutorialItemGroup.instance).food(new Food.Builder().hunger(6)
					.saturation(1.2f).effect(new EffectInstance(Effects.ABSORPTION, 6000, 5), 0.7f).build())));

	public static final RegistryObject<SpecialItem> SPECIAL_ITEM = ITEMS.register("special_item",
			() -> new SpecialItem(new Item.Properties().group(TutorialItemGroup.instance)));

	// Tools
	public static final RegistryObject<SwordItem> RUBY_SWORD = ITEMS.register("ruby_sword",
			() -> new SwordItem(ModItemTiers.RUBY, 7, 5.0f,
					new Item.Properties().group(TutorialItemGroup.instance)));

	public static final RegistryObject<Item> RUBY_BOW = ITEMS.register( "ruby_bow", () ->
			new TorchBow(new Item.Properties().group(TutorialItemGroup.instance).maxDamage(1000)));

	public static final RegistryObject<PickaxeItem> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe",
			() -> new PickaxeItem(ModItemTiers.RUBY, 4, 5.0f,
					new Item.Properties().group(TutorialItemGroup.instance)));

	public static final RegistryObject<ShovelItem> RUBY_SHOVEL = ITEMS.register("ruby_shovel",
			() -> new ShovelItem(ModItemTiers.RUBY, 2, 5.0f,
					new Item.Properties().group(TutorialItemGroup.instance)));

	public static final RegistryObject<AxeItem> RUBY_AXE = ITEMS.register("ruby_axe",
			() -> new AxeItem(ModItemTiers.RUBY, 11, 3.0f, new Item.Properties().group(TutorialItemGroup.instance)));

	public static final RegistryObject<HoeItem> RUBY_HOE = ITEMS.register("ruby_hoe",
			() -> new HoeItem(ModItemTiers.RUBY, 5.0f, new Item.Properties().group(TutorialItemGroup.instance)));


	public static final RegistryObject<SwordItem> AMETHYST_SWORD = ITEMS.register( "amethyst_sword", () ->
			new SwordItem(ModItemTiers2.AMETHYST, 2, -2.2F, new Item.Properties().group(TutorialItemGroup.instance)));
	public static final RegistryObject<PickaxeItem> AMETHYST_PICKAXE = ITEMS.register( "amethyst_pickaxe", () ->
			new PickaxeItem(ModItemTiers2.AMETHYST, 0, -2.8F, new Item.Properties().group(TutorialItemGroup.instance)));
	public static final RegistryObject<AxeItem> AMETHYST_AXE = ITEMS.register( "amethyst_axe", () ->
			new AxeItem(ModItemTiers2.AMETHYST, 1, -2.6F, new Item.Properties().group(TutorialItemGroup.instance)));
	public static final RegistryObject<ShovelItem> AMETHYST_SHOVEL = ITEMS.register( "amethyst_shovel", () ->
			new ShovelItem(ModItemTiers2.AMETHYST, 0, -2.8F, new Item.Properties().group(TutorialItemGroup.instance)));


	public static final RegistryObject<SwordItem> HAMMER = ITEMS.register( "hammer", () ->
			new SwordItem(ModItemTiers.RUBY, 4, -2.8F, new Item.Properties().group(TutorialItemGroup.instance)));

	// Armor
	public static final RegistryObject<ArmorItem> RUBY_HELMET = ITEMS.register("ruby_helmet",
			() -> new ArmorItem(ModArmorMaterials.RUBY, EquipmentSlotType.HEAD,
					new Item.Properties().group(TutorialItemGroup.instance)));

	public static final RegistryObject<ArmorItem> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate",
			() -> new ArmorItem(ModArmorMaterials.RUBY, EquipmentSlotType.CHEST,
					new Item.Properties().group(TutorialItemGroup.instance)));

	public static final RegistryObject<ArmorItem> RUBY_LEGGINGS = ITEMS.register("ruby_leggings",
			() -> new ArmorItem(ModArmorMaterials.RUBY, EquipmentSlotType.LEGS,
					new Item.Properties().group(TutorialItemGroup.instance)));

	public static final RegistryObject<ArmorItem> RUBY_BOOTS = ITEMS.register("ruby_boots",
			() -> new ArmorItem(ModArmorMaterials.RUBY, EquipmentSlotType.FEET,
					new Item.Properties().group(TutorialItemGroup.instance)));

	// Miscellaneous
	public static final RegistryObject<Item> CRYSTAL = ITEMS.register("crystal",
			() -> new Item(new Item.Properties().group(TutorialItemGroup.instance).maxStackSize(4)));

	public static final RegistryObject<ModMusicDiscItem> PROMISES_DISC = ITEMS.register("disc_promises",
			() -> new ModMusicDiscItem(5, SoundInit.LAZY_PROMISES_MUSIC.get(),
					new Item.Properties().group(TutorialItemGroup.instance).maxStackSize(1).rarity(Rarity.RARE)));

	public static final RegistryObject<ModSpawnEggItem> EXAMPLE_SPAWN_EGG = ITEMS.register("example_spawn_egg",
			() -> new ModSpawnEggItem(ModEntityTypes.EXAMPLE_ENTITY, 0xFF329F, 0x16777119,
					new Item.Properties().group(TutorialItemGroup.instance).maxStackSize(16)));

	public static final RegistryObject<BucketItem> EXAMPLE_BUCKET = ITEMS.register("example_bucket",
			() -> new BucketItem(() -> FluidInit.MILK_FLUID.get(),
					new Item.Properties().group(TutorialItemGroup.instance).maxStackSize(1)));

	public static final RegistryObject<WallOrFloorItem> EXAMPLE_TORCH = ITEMS.register("example_torch",
			() -> new WallOrFloorItem(BlockInit.EXAMPLE_TORCH.get(), BlockInit.EXAMPLE_WALL_TORCH.get(),
					new Item.Properties().group(TutorialItemGroup.instance)));

	public static final RegistryObject<Item> CUSTOM_ITEM = ITEMS.register("custom_item",
			() -> new Item(new Item.Properties().group(TutorialItemGroup.instance)));

	// Block Items
	public static final RegistryObject<Item> RUBY_BLOCK_ITEM = ITEMS.register("ruby_block_item", () -> new BlockItemBase(BlockInit.RUBY_BLOCK.get()));
	public static final RegistryObject<Item> AMETHYST_BLOCK_ITEM = ITEMS.register("amethyst_block_item", () -> new BlockItemBase(BlockInit.AMETHYST_BLOCK.get()));
	public static final RegistryObject<Item> AMETHYST_ORE_ITEM = ITEMS.register("amethyst_ore_item", () -> new BlockItemBase(BlockInit.AMETHYST_ORE.get()));
	public static final RegistryObject<Item> RUBY_ORE_ITEM = ITEMS.register("ruby_ore_item", () -> new BlockItemBase(BlockInit.RUBY_ORE.get()));
	public static final RegistryObject<Item> STEEL_ORE_ITEM = ITEMS.register("steel_ore_item", () -> new BlockItemBase(BlockInit.STEEL_ORE.get()));
	public static final RegistryObject<Item> OVEN_ITEM = ITEMS.register("oven_item", () -> new BlockItemBase(BlockInit.OVEN.get()));
}
