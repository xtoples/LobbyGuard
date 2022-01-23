package me.toples.lobbyguard.listeners.events;

import me.toples.lobbyguard.LobbyGuard;
import me.toples.lobbyguard.utilities.CC;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;

public class BlockListeners implements Listener {
    private LobbyGuard plugin;

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (plugin.getConfig().getBoolean("message-listeners.place-manager.enabled")) {
            player.sendMessage(plugin.getConfig().getString(CC.translate("message-listeners.place-message.message")));
        } else {
            player.sendMessage("");
        }
        if (plugin.getListenerManager().isDisabledInWorld(player.getWorld())) {
            return;
        }
        if (plugin.getListenerManager().isDisabled(event.getEventName())) {
            return;
        }
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (plugin.getConfig().getBoolean("message-listeners.break-manager.enabled")) {
            player.sendMessage(plugin.getConfig().getString(CC.translate("message-listeners.break-message.message")));
        } else {
            player.sendMessage("");
        }
        if (plugin.getListenerManager().isDisabledInWorld(player.getWorld())) {
            return;
        }
        if (plugin.getListenerManager().isDisabled(event.getEventName())) {
            return;
        }
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onLeafDecay(LeavesDecayEvent event) { // Message config not needed
        if (plugin.getListenerManager().isDisabled(event.getEventName())) {
            return;
        }
        if (plugin.getListenerManager().isDisabledInWorld(event.getBlock().getWorld())) {
            return;
        }
        event.setCancelled(true);
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onExplosion(ExplosionPrimeEvent event) { // Message config not needed
        if (plugin.getListenerManager().isDisabled(event.getEventName())) {
            return;
        }
        if (plugin.getListenerManager().isDisabledInWorld(event.getEntity().getWorld())) {
            return;
        }
        event.setCancelled(true);
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onBlockExplode(BlockExplodeEvent event) { // Message config not needed
        if (plugin.getListenerManager().isDisabled(event.getEventName())) {
            return;
        }
        if (plugin.getListenerManager().isDisabledInWorld(event.getBlock().getWorld())) {
            return;
        }
        event.setCancelled(true);
    }
}
