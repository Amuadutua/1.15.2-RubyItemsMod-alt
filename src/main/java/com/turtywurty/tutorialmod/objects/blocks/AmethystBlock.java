package com.turtywurty.tutorialmod.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class AmethystBlock extends Block {

    public AmethystBlock() {
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(7.0f, 9.0f)
                .sound(SoundType.METAL)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE));
    }
}
