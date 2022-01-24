package me.toples.lobbyguard.listeners.events;

import me.toples.lobbyguard.LobbyGuard;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListeners implements Listener {
    private LobbyGuard plugin;

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onCommand(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        if (plugin.getListenerManager().isDisabledInWorld(player.getWorld())) {
            return;
        }
        if (plugin.getListenerManager().isDisabled(event.getEventName())) {
            return;
        }
        if (event.getMessage().length() >= 2 && event.getMessage().charAt(1) == '/') {
            event.setCancelled(true);
            return;
        }

        if (event.getMessage().startsWith("/fill") || event.getMessage().startsWith("/minecraft:fill") ||
                event.getMessage().startsWith("/setblock") || event.getMessage().startsWith("/minecraft:setblock") ||
                event.getMessage().startsWith("/clone") || event.getMessage().startsWith("/minecraft:clone") ||
                event.getMessage().startsWith("/blockdata") || event.getMessage().startsWith("/minecraft:blockdata")) {
            event.setCancelled(true);
        }
    }
}
