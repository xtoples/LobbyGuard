package me.toples.lobbyguard.api.impl;

import com.avaje.ebean.validation.NotNull;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.toples.lobbyguard.LobbyGuard;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

public class Expansion extends PlaceholderExpansion {
    private LobbyGuard plugin;

    @Override
    public String getIdentifier() {
        return "lobbyguard";
    }

    @Override
    public String getAuthor() {
        return "Toples";
    }

    @Override
    public String getVersion() {
        return "1.5.0";
    }

    @Override
    public @NotNull
    List<String> getPlaceholders() {
        return Collections.singletonList("date");
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier) {
        return plugin.getPlaceholderHook().onRequest(player, identifier);
    }
}
