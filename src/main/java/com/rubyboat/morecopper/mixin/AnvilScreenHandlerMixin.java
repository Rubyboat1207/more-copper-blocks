package com.rubyboat.morecopper.mixin;

import com.rubyboat.morecopper.Main;
import com.rubyboat.morecopper.material.CopperMiningTool;
import com.rubyboat.morecopper.material.CopperPickaxe;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.UnbreakingEnchantment;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.AnvilScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(net.minecraft.screen.AnvilScreenHandler.class)
public class AnvilScreenHandlerMixin {
	@Inject(at = @At("HEAD"), method = "onTakeOutput", cancellable = true)
	private void onTakeOutput(PlayerEntity player, ItemStack stack, CallbackInfo ci) {
		if(stack.getItem() == Main.COPPER_PICKAXE)
		{
			stack.getOrCreateNbt().putInt(CopperMiningTool.blocksMined, 0);
			stack.getEnchantments().clear();
		}
	}
}
