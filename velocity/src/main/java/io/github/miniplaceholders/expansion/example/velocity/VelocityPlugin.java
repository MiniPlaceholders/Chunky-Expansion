package io.github.miniplaceholders.expansion.example.velocity;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Dependency;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.Player;
import io.github.miniplaceholders.expansion.example.common.CommonExpansion;
import org.slf4j.Logger;

@Plugin(
    name = "MiniPlaceholders-Example-Expansion",
    id = "miniplaceholders-example-expansion",
    version = Constants.VERSION,
    authors = {"4drian3d"},
    dependencies = {
        @Dependency(id = "miniplaceholders"),
        @Dependency(id = "some_plugin")
    }
)
public final class VelocityPlugin {
    private final Logger logger;

    @Inject
    public VelocityPlugin(final Logger logger) {
        this.logger = logger;
    }

    @Subscribe
    public void onProxyInitialize(final ProxyInitializeEvent event) {
        logger.info("Starting Example Expansion for Velocity");

        CommonExpansion.builder()
                .filter(Player.class)
                .build()
                .register();
    }
}
