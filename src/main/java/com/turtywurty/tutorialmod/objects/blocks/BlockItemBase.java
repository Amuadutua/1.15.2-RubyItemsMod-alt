package com.turtywurty.tutorialmod.objects.blocks;

import com.turtywurty.tutorialmod.TutorialMod;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class BlockItemBase extends BlockItem {

    public BlockItemBase(Block block) {
        super(block, new Properties().group(TutorialMod.TutorialItemGroup.instance));
    }
}
