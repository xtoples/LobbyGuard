package me.toples.lobbyguard.listeners.events;

import me.toples.lobbyguard.LobbyGuard;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.*;
import me.toples.lobbyguard.utilities.CC;

public class PlayerListeners implements Listener {
    private LobbyGuard plugin;

    @EventHandler
    public void onPickup(PlayerPickupItemEvent event) {
        Player player = event.getPlayer();
        if (plugin.getConfig().getBoolean("message-listeners.pickup-manager.enabled")) {
            player.sendMessage(plugin.getConfig().getString(CC.translate("message-listeners.pickup-message.message")));
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
    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        if (plugin.getConfig().getBoolean("message-listeners.drop-manager.enabled")) {
            player.sendMessage(plugin.getConfig().getString(CC.translate("message-listeners.drop-message.message")));
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
    @EventHandler
    public void onAchievement(PlayerAchievementAwardedEvent event) {
        Player player = event.getPlayer();
        if (plugin.getConfig().getBoolean("message-listeners.achievement-manager.enabled")) {
            player.sendMessage(plugin.getConfig().getString(CC.translate("message-listeners.achievement-message.message")));
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
    @EventHandler
    public void onItemDamage(PlayerItemDamageEvent event) {
        Player player = event.getPlayer();
        if (plugin.getConfig().getBoolean("message-listeners.itemdamage-manager.enabled")) {
            player.sendMessage(plugin.getConfig().getString(CC.translate("message-listeners.itemdamage-message.message")));
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
    @EventHandler
    public void onShear(PlayerShearEntityEvent event) {
        Player player = event.getPlayer();
        if (plugin.getConfig().getBoolean("message-listeners.shear-manager.enabled")) {
            player.sendMessage(plugin.getConfig().getString(CC.translate("message-listeners.shear-message.message")));
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
    @EventHandler
    public void onFish(PlayerFishEvent event) { //
        Player player = event.getPlayer();
        if (plugin.getConfig().getBoolean("message-listeners.fish-manager.enabled")) {
            player.sendMessage(plugin.getConfig().getString(CC.translate("message-listeners.fish-message.message")));
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
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (plugin.getConfig().getBoolean("message-listeners.interact-manager.enabled")) {
            player.sendMessage(plugin.getConfig().getString(CC.translate("message-listeners.interact-message.message")));
        } else {
            player.sendMessage("");
        }
        if (plugin.getListenerManager().isDisabledInWorld(player.getWorld())) {
            return;
        }
        if (event.getAction() == Action.LEFT_CLICK_BLOCK && event.getAction() == Action.LEFT_CLICK_AIR && event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getAction() == Action.RIGHT_CLICK_AIR && event.getAction() == Action.PHYSICAL) {
            if (plugin.getListenerManager().isDisabled(event.getEventName() + "-left-block")) {
                return;
            }
        }
    }
    @EventHandler
    public void onPortal(PlayerPortalEvent event) {
        Player player = event.getPlayer();
        if (plugin.getConfig().getBoolean("message-listeners.portal-manager.enabled")) {
            player.sendMessage(plugin.getConfig().getString(CC.translate("message-listeners.portal-message.message")));
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
}
