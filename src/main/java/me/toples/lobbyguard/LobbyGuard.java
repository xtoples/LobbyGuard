package me.toples.lobbyguard;

import lombok.Getter;
import me.toples.lobbyguard.api.PlaceholderHook;
import me.toples.lobbyguard.api.impl.Expansion;
import me.toples.lobbyguard.commands.LobbyGuardCMD;
import me.toples.lobbyguard.listeners.ListenerManager;
import me.toples.lobbyguard.listeners.events.BlockListeners;
import me.toples.lobbyguard.listeners.events.CommandListeners;
import me.toples.lobbyguard.listeners.events.PlayerListeners;
import me.toples.lobbyguard.utilities.Description;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import me.toples.lobbyguard.utilities.CC;

public class LobbyGuard extends JavaPlugin {
    @Getter
    public static LobbyGuard instance;
    @Getter
    private PlaceholderHook placeholderHook;
    @Getter
    private ListenerManager listenerManager;
    @Getter
    private final PluginManager pluginManager = Bukkit.getPluginManager();

    public LobbyGuard() {
        instance = this;
    }

    @Override
    public void onEnable() {
        this.listenerManager = new ListenerManager(this);
        this.placeholderHook = new PlaceholderHook(this);
        this.saveDefaultConfig();
        if (pluginManager.getPlugin("PlaceholderAPI") != null) {
            getLogger().info(CC.translate("&aPlaceholderAPI Found. Success to hook..."));
            new Expansion().register();
        } else {
            getLogger().info(CC.translate("&cPlaceholderAPI Not Found. Failed to hook..."));
        }
        if (!Description.getAuthor().contains("Toples")) {
            getLogger().info(CC.translate("------------------------------------------------"));
            getLogger().info(CC.translate("&cYou edited the plugin.yml, please don't do that"));
            getLogger().info(CC.translate( "&cPlease check your plugin.yml and try again."));
            getLogger().info(CC.translate("            &cDisabling LobbyGuard"));
            getLogger().info(CC.translate("------------------------------------------------"));
            pluginManager.disablePlugin(this);
            return;
        }
        if (!Description.getName().contains("LobbyGuard")) {
            getLogger().info(CC.translate("------------------------------------------------"));
            getLogger().info(CC.translate("&cYou edited the plugin.yml, please don't do that"));
            getLogger().info(CC.translate(" &cPlease check your plugin.yml and try again."));
            getLogger().info(CC.translate("            &cDisabling LobbyGuard"));
            getLogger().info(CC.translate("------------------------------------------------"));
            pluginManager.disablePlugin(this);
            return;
        }
        new LobbyGuardCMD(this);
        pluginManager.registerEvents(new PlayerListeners(),this);
        pluginManager.registerEvents(new BlockListeners(),this);
        pluginManager.registerEvents(new CommandListeners(), this);
        registerConfig();
    }
    @Override
    public void onDisable() {
        // null code (not required)
    }
    public void registerConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}
