package com.rubyboat.morecopper.mixin;

import com.rubyboat.morecopper.Main;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.sound.GuardianAttackSoundInstance;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.GuardianEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.NetworkThreadUtils;
import net.minecraft.network.packet.s2c.play.EntityStatusS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public abstract class TotemEffectMixin {

    @Shadow @Final private MinecraftClient client;

    @Shadow private ClientWorld world;

    @Shadow
    protected static ItemStack getActiveTotemOfUndying(PlayerEntity player) {
        return null;
    }

    @Inject(at = @At("HEAD"), method = "onEntityStatus", cancellable = true)
    public void onEntityStatus(EntityStatusS2CPacket packet, CallbackInfo ci) {
        NetworkThreadUtils.forceMainThread(packet, ((ClientPlayNetworkHandler)(Object)this), this.client);
        Entity entity = packet.getEntity(this.world);
        if (entity != null) {
            if (packet.getStatus() == 100) {
                this.client.particleManager.addEmitter(entity, ParticleTypes.TOTEM_OF_UNDYING, 30);
                this.world.playSound(entity.getX(), entity.getY(), entity.getZ(), SoundEvents.ITEM_TOTEM_USE, entity.getSoundCategory(), 1.0F, 1.0F, false);
                if (entity == this.client.player) {
                    this.client.gameRenderer.showFloatingItem(new ItemStack(Main.CopperTotem, 1));
                }
            } else {
                entity.handleStatus(packet.getStatus());
            }
        }

    }

}
