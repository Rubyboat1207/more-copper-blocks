package com.rubyboat.morecopper.material.CopperTools;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.Tag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CopperAxe extends MiningToolItem {
    public static String blocksMined = "blocksMined";
    public static Tag<Block> EffectiveBlocks;

    protected CopperAxe(float attackDamage, float attackSpeed, ToolMaterial material, Tag<Block> effectiveBlocks, Settings settings) {
        super(attackDamage, attackSpeed, material, effectiveBlocks, settings);
        EffectiveBlocks = effectiveBlocks;
    }
    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return CopperPickaxe.EffectiveBlocks.contains(state.getBlock()) ? (float) Math.floor(stack.getOrCreateNbt().getInt(blocksMined) / 50f) * 2.75f : this.miningSpeed;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        stack.getOrCreateNbt().putInt(blocksMined, stack.getOrCreateNbt().getInt(blocksMined) + ((EffectiveBlocks.contains(world.getBlockState(pos).getBlock()) ? 0 : 1)));
        return super.postMine(stack, world, state, pos, miner);
    }
}
