package com.rubyboat.morecopper;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;

public class BlockAdder {
    public enum BlockTypes {
        Walls,
        Lightning_Rod
    }
    public static ArrayList<BlockItemCombo> BlockItemsList = new ArrayList<BlockItemCombo>();

    public static BlockItemCombo AddWeirdBlock(BlockTypes blocktype, Identifier id, Block modelBlock, FabricItemSettings itemSettings)
    {
        BlockItemCombo combo = new BlockItemCombo();
        Block block = null;
        if(blocktype == BlockTypes.Walls)
        {
            block = new WallBlock(FabricBlockSettings.copy(Blocks.CUT_COPPER));
        }
        if(blocktype == BlockTypes.Lightning_Rod)
        {
            block = new LightningRodBlock(FabricBlockSettings.copy(Blocks.LIGHTNING_ROD));
        }
        combo.block = block;
        combo.item = new BlockItem(block, itemSettings);
        combo.identifier = id;
        BlockItemsList.add(combo);
        return combo;
    }

    public static void Initialize()
    {
        for (BlockItemCombo current : BlockItemsList) {
            Registry.register(Registry.BLOCK, current.identifier, current.block);
            Registry.register(Registry.ITEM, current.identifier, current.item);
        }
    }
}
