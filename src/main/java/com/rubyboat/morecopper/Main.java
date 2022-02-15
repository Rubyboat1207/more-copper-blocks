package com.rubyboat.morecopper;

import com.rubyboat.morecopper.material.CopperMaterial;
import com.rubyboat.morecopper.material.CopperMiningTool;
import com.rubyboat.morecopper.material.CopperPickaxe;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger("more_copper");
	public static final BlockItemCombo CUT_COPPER_WALLS = BlockAdder.AddWeirdBlock(BlockAdder.BlockTypes.Walls, new Identifier("more_copper", "cut_copper_wall"), Blocks.CUT_COPPER, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
	public static final BlockItemCombo EXPOSED_CUT_COPPER_WALLS = BlockAdder.AddWeirdBlock(BlockAdder.BlockTypes.Walls, new Identifier("more_copper", "exposed_cut_copper_wall"), Blocks.CUT_COPPER, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
	public static final BlockItemCombo WEATHERED_CUT_COPPER_WALLS = BlockAdder.AddWeirdBlock(BlockAdder.BlockTypes.Walls, new Identifier("more_copper", "weathered_cut_copper_wall"), Blocks.CUT_COPPER, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
	public static final BlockItemCombo OXIDIZED_CUT_COPPER_WALLS = BlockAdder.AddWeirdBlock(BlockAdder.BlockTypes.Walls, new Identifier("more_copper", "oxidized_cut_copper_wall"), Blocks.CUT_COPPER, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
	//Lightning Rod
	public static final BlockItemCombo EXPOSED_LIGHTNING_ROD = BlockAdder.AddWeirdBlock(BlockAdder.BlockTypes.Lightning_Rod, new Identifier("more_copper", "exposed_lightning_rod"), Blocks.LIGHTNING_ROD, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
	public static final BlockItemCombo WEATHERED_LIGHTNING_ROD = BlockAdder.AddWeirdBlock(BlockAdder.BlockTypes.Lightning_Rod, new Identifier("more_copper", "weathered_lightning_rod"), Blocks.LIGHTNING_ROD, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
	public static final BlockItemCombo OXIDIZED_LIGHTNING_ROD = BlockAdder.AddWeirdBlock(BlockAdder.BlockTypes.Lightning_Rod, new Identifier("more_copper", "oxidized_lightning_rod"), Blocks.LIGHTNING_ROD, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
	//Lanterns
	public static final BlockItemCombo COPPER_LANTERN = BlockAdder.AddWeirdBlock(BlockAdder.BlockTypes.Lantern, new Identifier("more_copper", "copper_lantern"), Blocks.LANTERN, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
	public static final BlockItemCombo EXPOSED_LANTERN = BlockAdder.AddWeirdBlock(BlockAdder.BlockTypes.Lantern, new Identifier("more_copper", "exposed_copper_lantern"), FabricBlockSettings.of(Material.METAL).sounds(BlockSoundGroup.COPPER).luminance(10), new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
	public static final BlockItemCombo WEATHERED_LANTERN = BlockAdder.AddWeirdBlock(BlockAdder.BlockTypes.Lantern, new Identifier("more_copper", "weathered_copper_lantern"), Blocks.LANTERN, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
	public static final BlockItemCombo OXIDIZED_LANTERN = BlockAdder.AddWeirdBlock(BlockAdder.BlockTypes.Lantern, new Identifier("more_copper", "oxidized_copper_lantern"), Blocks.LANTERN, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));

	public static final CopperPickaxe COPPER_PICKAXE = new CopperPickaxe(CopperMaterial.INSTANCE, 0, 1, new FabricItemSettings());


	@Override
	public void onInitialize() {
		BlockAdder.Initialize();
		Registry.register(Registry.ITEM, new Identifier("more_copper", "copper_pickaxe"), COPPER_PICKAXE);
		LOGGER.info("Hello Fabric world!");
	}
}
