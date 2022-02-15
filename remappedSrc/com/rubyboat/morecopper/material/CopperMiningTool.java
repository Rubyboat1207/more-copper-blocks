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

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        CopperMaterial copperMaterial = (CopperMaterial) getMaterial();
        copperMaterial.setMiningSpeedMultiplier(copperMaterial.getMiningSpeedMultiplier() + 1);
        ((PlayerEntity) miner).sendMessage(Text.of(String.valueOf(copperMaterial.getMiningSpeedMultiplier())), false);
        return super.postMine(stack, world, state, pos, miner);
    }
}
