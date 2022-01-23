package me.toples.lobbyguard.utilities;

import me.toples.lobbyguard.LobbyGuard;

public class Description {
    public static String getVersion() {
        return LobbyGuard.getInstance().getDescription().getVersion();
    }

    public static String getAuthor() {
        return LobbyGuard.getInstance().getDescription().getAuthors().toString().replace("[", "").replace("]", "");
    }

    public static String getName() {
        return LobbyGuard.getInstance().getDescription().getName();
    }
}
