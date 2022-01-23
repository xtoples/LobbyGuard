package me.toples.lobbyguard.api;

import lombok.RequiredArgsConstructor;
import me.toples.lobbyguard.LobbyGuard;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class PlaceholderHook {
    private final LobbyGuard plugin;

    public String onRequest(Player player, String identifier) {
        // placeholder : %lobbyguard_eventscount%
        if (identifier.equals("eventscount")) {
            return String.valueOf(plugin.getListenerManager().getActiveListeners().size());
        }
        return null;
    }
}
