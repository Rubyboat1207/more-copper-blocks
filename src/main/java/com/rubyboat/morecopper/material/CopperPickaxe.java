package com.rubyboat.morecopper.material;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.Tag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CopperPickaxe extends CopperMiningTool {
    public CopperPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super((float)attackDamage, attackSpeed, material, BlockTags.PICKAXE_MINEABLE, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        int blocksMined = stack.getOrCreateNbt().getInt("blocksMined");
        blocksMined++;
        if(blocksMined >= 50)
        {

        }
        return super.postMine(stack, world, state, pos, miner);
    }
}
