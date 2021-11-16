package com.rubyboat.morecopper.material;

import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.Tag;

public class CopperPickaxe extends CopperMiningTool {
    public CopperPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super((float)attackDamage, attackSpeed, material, BlockTags.PICKAXE_MINEABLE, settings);
    }
}
