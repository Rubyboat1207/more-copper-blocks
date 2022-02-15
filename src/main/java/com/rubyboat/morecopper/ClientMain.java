package com.rubyboat.morecopper;

import com.rubyboat.morecopper.material.CopperMiningTool;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.Level;

@Environment(EnvType.CLIENT)
public class ClientMain implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        Main.LOGGER.info("Client Loaded");
        FabricModelPredicateProviderRegistry.register(Main.COPPER_PICKAXE, new Identifier("more_copper","blocks_mined"), (stack, world, entity, seed) -> (float) stack.getOrCreateNbt().getInt(CopperMiningTool.blocksMined));
    }
}
