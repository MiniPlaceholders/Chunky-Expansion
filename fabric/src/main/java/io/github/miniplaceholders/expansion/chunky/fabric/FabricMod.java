package io.github.miniplaceholders.expansion.chunky.fabric;

import io.github.miniplaceholders.expansion.chunky.common.CommonExpansion;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.minecraft.server.level.ServerPlayer;

public class FabricMod implements DedicatedServerModInitializer {
    @Override
    public void onInitializeServer() {
        CommonExpansion.builder()
                .filter(ServerPlayer.class)
                .build()
                .register();
    }
}
