package com.turtywurty.tutorialmod.util.enums;

import com.turtywurty.tutorialmod.init.ItemInit;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import java.util.function.Supplier;

public enum ModItemTiers3 implements IItemTier {

	// int harvestLevel, int maxUses, float efficiency, float attackDamage, int
	// enchantability, Supplier<Ingredient> repairMaterial
	STEEL(6,2500,16.0F,6.0F,25, () -> {
		return Ingredient.fromItems(ItemInit.STEEL_INGOT.get());
	});

	private final int harvestLevel;
	private final int maxUses;
	private final float efficiency;
	private final float attackDamage;
	private final int enchantability;
	private final LazyValue<Ingredient> repairMaterial;

	private ModItemTiers3(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability,
                          Supplier<Ingredient> repairMaterial) {
		this.harvestLevel = harvestLevel;
		this.maxUses = maxUses;
		this.efficiency = efficiency;
		this.attackDamage = attackDamage;
		this.enchantability = enchantability;
		this.repairMaterial = new LazyValue<>(repairMaterial);
	}

	@Override
	public int getMaxUses() {
		return this.maxUses;
	}

	@Override
	public float getEfficiency() {
		return this.efficiency;
	}

	@Override
	public float getAttackDamage() {
		return this.attackDamage;
	}

	@Override
	public int getHarvestLevel() {
		return this.harvestLevel;
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return this.repairMaterial.getValue();
	}
}