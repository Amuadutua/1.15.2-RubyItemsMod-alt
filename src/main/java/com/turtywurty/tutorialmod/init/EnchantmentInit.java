package com.turtywurty.tutorialmod.init;

import com.turtywurty.tutorialmod.TutorialMod;
import com.turtywurty.tutorialmod.enchantments.AutoSmelt;
import com.turtywurty.tutorialmod.enchantments.UpstepEnchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EnchantmentInit {

	public static final DeferredRegister<Enchantment> ENCHANTMENTS = new DeferredRegister<>(
			ForgeRegistries.ENCHANTMENTS, TutorialMod.MOD_ID);

	public static final RegistryObject<Enchantment> UPSTEP = ENCHANTMENTS.register("upstep",
			() -> new UpstepEnchantment(Rarity.RARE, EnchantmentType.ARMOR_FEET,
					new EquipmentSlotType[] { EquipmentSlotType.FEET }));

	public static final RegistryObject<Enchantment> AUTOSMELT = ENCHANTMENTS.register("autosmelt",
			() -> new AutoSmelt(Rarity.RARE, EnchantmentType.DIGGER,
					new EquipmentSlotType[] { EquipmentSlotType.MAINHAND }));
}
