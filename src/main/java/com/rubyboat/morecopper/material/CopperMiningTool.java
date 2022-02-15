package com.rubyboat.morecopper.material;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.tag.Tag;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CopperMiningTool extends MiningToolItem {
    protected CopperMiningTool(float attackDamage, float attackSpeed, ToolMaterial material, Tag<Block> effectiveBlocks, Settings settings) {
        super(attackDamage, attackSpeed, material, effectiveBlocks, settings);
    }
    public static String blocksMined = "blocksMined";
    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return (float) Math.floor(stack.getOrCreateNbt().getInt(blocksMined) / 50f) * 2.75f;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        stack.getOrCreateNbt().putInt(blocksMined, stack.getOrCreateNbt().getInt(blocksMined) + 1);
        return super.postMine(stack, world, state, pos, miner);
    }
}
