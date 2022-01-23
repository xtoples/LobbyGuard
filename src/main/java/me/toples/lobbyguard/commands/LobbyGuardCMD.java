package me.toples.lobbyguard.commands;

import com.google.common.base.Joiner;
import me.toples.lobbyguard.LobbyGuard;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.toples.lobbyguard.utilities.CC;

import java.lang.reflect.Field;
import java.util.Arrays;

public class LobbyGuardCMD extends Command {
    private LobbyGuard plugin;

    public LobbyGuardCMD(LobbyGuard plugin) {
        super("lobbyguard");
        this.plugin = plugin;
        this.registerCommand(this);
        this.setAliases(Arrays.asList("lg", "lguard"));
    }

    private void registerCommand(Command command) {
        try {
            Field commandMapField = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            commandMapField.setAccessible(true);

            CommandMap commandMap = (CommandMap) commandMapField.get(Bukkit.getServer());
            commandMap.register(plugin.getDescription().getName(), command);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!(sender instanceof Player)) {
            execute(sender, args);
            return false;
        }
        return false;
    }
    private void execute (CommandSender sender, String[]args){
            if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
                sender.sendMessage(CC.translate("&cUsage: /lobbyguard"));
                sender.sendMessage(CC.translate("&cUsage: /lobbyguard reload"));
                sender.sendMessage(CC.translate("&cUsage: /lobbyguard listevents"));
            } else if (args[0].equalsIgnoreCase("reload")) {
                if (sender.hasPermission("lobbyguard.reload") || sender.isOp()) {
                    plugin.reloadConfig();
                    plugin.getListenerManager().reload();
                    sender.sendMessage(CC.translate("&bConfig reloaded!"));
                } else {
                    sender.sendMessage(CC.translate("&cYou don't have permission to use this command!"));
                }
            } else {
                if (args[0].equalsIgnoreCase("listevents")) {
                    sender.sendMessage(CC.translate("&7List of active events: &d" + Joiner.on(", ").join(plugin.getListenerManager().getActiveListeners())));
                }
            }
    }
}