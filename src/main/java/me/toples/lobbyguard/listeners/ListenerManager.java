package me.toples.lobbyguard.listeners;

import lombok.Getter;
import me.toples.lobbyguard.LobbyGuard;
import org.bukkit.World;
import org.bukkit.event.Listener;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ListenerManager implements Listener {
    private LobbyGuard plugin;
    @Getter
    private final Set<String> activeListeners = new HashSet<>();
    private final List<String> disabledListeners;
    private final List<String> enabledWorlds;

    public ListenerManager(LobbyGuard plugin) {
        this.disabledListeners = plugin.getConfig().getStringList("disabled-listeners").stream().map(String::toLowerCase).collect(Collectors.toList());
        this.enabledWorlds = plugin.getConfig().getStringList("enabled-worlds").stream().map(String::toLowerCase).collect(Collectors.toList());
    }
    public void reload() {
        this.disabledListeners.clear();
        this.activeListeners.clear();
    }
    public boolean isDisabled(String eventName) {
        this.activeListeners.add(eventName.toLowerCase());
        return disabledListeners.contains(eventName.toLowerCase());
    }
    public boolean isDisabledInWorld(World world) {
        if (enabledWorlds.contains("*") || enabledWorlds.contains("all")) {
            return false;
        }
        return !enabledWorlds.contains(world.getName().toLowerCase());
    }
}
