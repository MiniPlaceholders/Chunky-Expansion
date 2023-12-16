package io.github.miniplaceholders.expansion.chunky.sponge;

import com.google.inject.Inject;
import io.github.miniplaceholders.expansion.chunky.common.CommonExpansion;
import org.apache.logging.log4j.Logger;
import org.spongepowered.api.Server;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.lifecycle.StartingEngineEvent;
import org.spongepowered.plugin.builtin.jvm.Plugin;

@Plugin("miniplaceholders-chunky-expansion")
public class SpongePlugin {
    @Inject
    private Logger logger;

    @Listener
    public void onServerStart(final StartingEngineEvent<Server> event) {
        this.logger.info("Starting Chunky Expansion for Sponge");

        CommonExpansion.builder()
                .filter(ServerPlayer.class)
                .build()
                .register();
    }
}
