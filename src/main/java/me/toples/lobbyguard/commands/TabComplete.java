package me.toples.lobbyguard.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class TabComplete implements TabCompleter {
    public boolean equalsToStrings(String input, String string){
        return input.equalsIgnoreCase(string.substring(0, Math.min(input.length(), string.length())));
    }
    @Override
    public List<String> onTabComplete(CommandSender sender,Command command,String alias, String[] args) {
        List<String> list = new ArrayList<>();

        if(args.length == 1) {
            if(args[0].equalsIgnoreCase("")) {
                list.add("help");
                list.add("reload");
                list.add("listevents");

            } else if(equalsToStrings(args[0], "help")) {
                list.add("help");
            } else if(equalsToStrings(args[0], "reload")) {
                list.add("reload");
            } else if(equalsToStrings(args[0], "listevents")) {
                list.add("listevents");
            }
        }
        return list;
    }
}
