package com.turtywurty.tutorialmod.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class SteelOre extends Block {

    public SteelOre() {
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(8.0f, 12.0f)
                .sound(SoundType.STONE)
                .harvestLevel(5)
                .harvestTool(ToolType.PICKAXE));
    }
}
