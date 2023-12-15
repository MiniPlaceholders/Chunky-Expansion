package io.github.miniplaceholders.expansion.example.paper;

import io.github.miniplaceholders.expansion.example.common.CommonExpansion;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public final class PaperPlugin extends JavaPlugin {

    @Override
    public void onEnable(){
        this.getSLF4JLogger().info("Starting Example Expansion for Paper");

        CommonExpansion.builder()
                .filter(Player.class)
                .build()
                .register();
    }
}
