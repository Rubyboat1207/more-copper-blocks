package com.rubyboat.morecopper;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class ClientMain implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        Main.LOGGER.info("Client Loaded");
    }
}
