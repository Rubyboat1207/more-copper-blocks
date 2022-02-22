package com.rubyboat.morecopper.mixin;

import com.rubyboat.morecopper.Main;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.MendingEnchantment;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Enchantment.class)
public class EnchantmentMixin {
    @Inject(at = @At("HEAD"), method = "isAcceptableItem", cancellable = true)
    public void isAcceptableItem(ItemStack stack, CallbackInfoReturnable<Boolean> cir)
    {
        if(((Enchantment)(Object)this) instanceof MendingEnchantment)
        {
            if(stack.isOf(Main.COPPER_PICKAXE) || stack.isOf(Main.COPPER_SHOVEL) || stack.isOf(Main.COPPER_AXE))
            {
                cir.setReturnValue(false);
            }
        }
    }
}
