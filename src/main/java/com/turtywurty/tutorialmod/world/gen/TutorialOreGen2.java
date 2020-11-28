package com.turtywurty.tutorialmod.world.gen;

import com.turtywurty.tutorialmod.init.BlockInit;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class TutorialOreGen2 {
	public static void generateOre() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			ConfiguredPlacement customConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(5, 0, 5, 30));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
									BlockInit.RUBY_ORE.get().getDefaultState(), 7))
							.withPlacement(customConfig));
		}
	}
}

//OreFeatureConfig.FillerBlockType.create("end_stone", null, new BlockMatcher(Blocks.END_STONE))