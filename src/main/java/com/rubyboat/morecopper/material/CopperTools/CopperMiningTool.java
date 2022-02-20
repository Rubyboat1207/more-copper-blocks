package com.rubyboat.morecopper.material.CopperTools;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.item.TooltipData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.Tag;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class CopperMiningTool extends MiningToolItem {
    public static String blocksMined = "blocksMined";
    public static Tag<Block> EffectiveBlocks;
    public CopperMiningTool(float attackDamage, float attackSpeed, ToolMaterial material, Tag<Block> effectiveBlocks, Settings settings) {
        super(attackDamage, attackSpeed, material, effectiveBlocks, settings);
        EffectiveBlocks = effectiveBlocks;
    }
    public float getMiningSpeedLevel(ItemStack stack)
    {
        return (float) Math.floor(stack.getOrCreateNbt().getInt(blocksMined) / 50f) * 2.75f;
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return CopperMiningTool.EffectiveBlocks.contains(state.getBlock()) ?  getMiningSpeedLevel(stack) : this.miningSpeed;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        stack.getOrCreateNbt().putInt(blocksMined, stack.getOrCreateNbt().getInt(blocksMined) + ((BlockTags.PICKAXE_MINEABLE.contains(world.getBlockState(pos).getBlock()) ? 0 : 1)));
        return super.postMine(stack, world, state, pos, miner);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        String MiningSpeed = (String.valueOf(getMiningSpeedLevel(stack)));
        tooltip.add(Text.of("§8Current Mining Speed Level: " + MiningSpeed.substring(0, MiningSpeed.length() - 2)));
        String UntilNextLevel = String.valueOf(50 - (stack.getOrCreateNbt().getInt(blocksMined) - getMiningSpeedLevel(stack) * 50));
        tooltip.add(Text.of("§dBlocks Until Next Level: " + UntilNextLevel.substring(0, UntilNextLevel.length() -2)));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
