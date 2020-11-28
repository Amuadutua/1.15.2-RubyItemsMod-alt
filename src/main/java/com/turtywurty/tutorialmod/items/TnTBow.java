package com.turtywurty.tutorialmod.items;

import com.turtywurty.tutorialmod.entities.projectiles.TnTArrowEntity;
import com.turtywurty.tutorialmod.entities.projectiles.TorchArrowEntity;
import com.turtywurty.tutorialmod.init.ItemInit;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

import java.util.function.Predicate;

public class TnTBow extends ModBow {
    public TnTBow(Properties builder) {
        super(builder);
    }


    @Override
    protected AbstractArrowEntity createArrow(World worldIn, ItemStack ammoStack, PlayerEntity playerentity) {
        return new TnTArrowEntity(worldIn, playerentity);
    }
    @Override
    protected double getArrowDamage(ItemStack bowStack, AbstractArrowEntity arrowEntity) {
        int powerLevel = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, bowStack);

        return (double)powerLevel * 0.5D + 0.5D;
    }

    @Override
    public Predicate<ItemStack> getInventoryAmmoPredicate() {
        return (ammoStack) -> {
            return ammoStack.getItem() == Items.TNT;
        };
    }
}