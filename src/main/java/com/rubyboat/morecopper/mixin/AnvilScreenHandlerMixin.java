package com.rubyboat.morecopper.mixin;

import com.rubyboat.morecopper.Main;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.screen.AnvilScreenHandler.class)
public class AnvilScreenHandlerMixin {
	@Inject(at = @At("HEAD"), method = "onTakeOutput", cancellable = true)
	private void onTakeOutput(PlayerEntity player, ItemStack stack, CallbackInfo ci) {
		if(stack.getItem() == Main.COPPER_PICKAXE && stack.getEnchantments().contains(Enchantments.UNBREAKING ))
		{
			stack.setRepairCost(0);
			stack.getEnchantments().clear();
		}
	}
}
