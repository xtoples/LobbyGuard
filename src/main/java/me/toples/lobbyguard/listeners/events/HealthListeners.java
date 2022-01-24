package me.toples.lobbyguard.listeners.events;

import me.toples.lobbyguard.LobbyGuard;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class HealthListeners implements Listener {
    private LobbyGuard plugin;

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onFoodChange(FoodLevelChangeEvent event) {
        if (plugin.getConfig().getBoolean("message-listeners.food-manager.enabled")) {
            event.setCancelled(true);
        } else {
            event.setCancelled(false);
        }
        if (plugin.getListenerManager().isDisabledInWorld(event.getEntity().getWorld())) {
            return;
        }
        if (plugin.getListenerManager().isDisabled(event.getEventName())) {
            return;
        }
        event.setCancelled(true);
    }
}
