package com.rubyboat.morecopper.mixin;

import com.rubyboat.morecopper.Main;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class TotemMixin {
    @Shadow public abstract ItemStack getStackInHand(Hand hand);

    @Shadow public abstract void setHealth(float health);

    @Shadow public abstract boolean clearStatusEffects();

    @Shadow public abstract boolean addStatusEffect(StatusEffectInstance effect);

    @Inject(at = @At("HEAD"), method = "tryUseTotem", cancellable = true)
    private void tryUseTotem(DamageSource source, CallbackInfoReturnable<Boolean> cir) {
        if (source.isOutOfWorld()) {
            cir.setReturnValue(false);
        } else {
            ItemStack itemStack = null;
            Hand[] var4 = Hand.values();
            int var5 = var4.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                Hand hand = var4[var6];
                ItemStack itemStack2 = this.getStackInHand(hand);
                if (itemStack2.isOf(Items.TOTEM_OF_UNDYING) || itemStack2.isOf(Main.CopperTotem)) {
                    itemStack = itemStack2.copy();
                    itemStack2.decrement(1);
                    break;
                }
            }

            if(itemStack != null){
                if (itemStack.isOf(Items.TOTEM_OF_UNDYING)) {

                    this.setHealth(1.0F);
                    this.clearStatusEffects();
                    this.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 900, 1));
                    this.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 100, 1));
                    this.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 800, 0));
                    ((LivingEntity)(Object)this).world.sendEntityStatus(((LivingEntity)(Object)this), (byte)35);
                }
                if(itemStack.isOf(Main.CopperTotem)){

                    this.setHealth(1.0F);
                    this.clearStatusEffects();
                    this.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 1));
                    this.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 200, 1));
                    this.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 200, 4));
                    ((LivingEntity)(Object)this).world.sendEntityStatus(((LivingEntity)(Object)this), (byte)100);

                }
            }

            cir.setReturnValue(itemStack != null);
        }
    }

}
