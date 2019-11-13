package io.github.mlntcandy.rawbroadcast;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.text.MessageFormat;
import java.util.Objects;

public final class RawBroadcast extends JavaPlugin {

    public boolean discordSRVExists = false;
    private String discordSRVPrefix = "";
    @Override
    public void onEnable() {
        // Plugin startup logic
        discordSRVExists = getServer().getPluginManager().isPluginEnabled("DiscordSRV");
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
                    boolean commandSuccess = true;
                    if (command.getName().equals("rawbc")) {
                        discordSRVPrefix = getConfig().getString("DiscordSRVPrefix");
                        discordSRVExists = getServer().getPluginManager().isPluginEnabled("DiscordSRV");
                        boolean doesHavePermission = true;
                        switch (args[0]) {
                            case "raw":
                                if (sender instanceof Player) {
                                    Player player = (Player) sender;
                                    doesHavePermission = player.hasPermission("rawbroadcast.raw");
                                }
                                if (doesHavePermission) {
                                    StringBuilder message = new StringBuilder();
                                    for (int i = 1; i < args.length; i++) {
                                        String s = args[i];
                                        message.append(s).append(" ");
                                    }
                                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message.toString()));
                                    if (discordSRVExists) getServer().dispatchCommand(getServer().getConsoleSender(), "discord broadcast " + discordSRVPrefix + ChatColor.translateAlternateColorCodes('&', message.toString()));
                                    sender.sendMessage(ChatColor.GREEN + "Success!");
                                    //sender.sendMessage("This feature isn't ready yet!");
                                } else { sender.sendMessage(ChatColor.RED + "You don't have permission to perform this command."); }
                                commandSuccess = true;
                                break;
                            case "snippet":
                                if (sender instanceof Player) {
                                    Player player = (Player) sender;
                                    doesHavePermission = player.hasPermission("rawbroadcast.snippet");
                                }
                                if (doesHavePermission) {
                                    String snippetName = args[1];

                                    //   if (getConfig().isSet(snippetName)) System.out.print("Snippet set");
                                    //   if (getConfig().isString(snippetName)) System.out.print("Snippet is a string");
                                    
                                    
                                    if (getConfig().isSet(snippetName) && getConfig().isString(snippetName)) {
                                        String snippetString = getConfig().getString(snippetName);
                                        StringBuilder message = new StringBuilder();
                                        for (int i = 2; i < args.length; i++) {
                                            String s = args[i];
                                            message.append(s).append(" ");
                                        }
                                        String[] formatArgs = message.toString().trim().split(",");
                                        MessageFormat fmt = new MessageFormat(Objects.requireNonNull(snippetString));
                                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', fmt.format(formatArgs)));
                                        if (discordSRVExists) getServer().dispatchCommand(getServer().getConsoleSender(), "discord broadcast " + discordSRVPrefix + ChatColor.translateAlternateColorCodes('&', fmt.format(formatArgs)));
                                        sender.sendMessage(ChatColor.GREEN + "Success!");
                                        commandSuccess = true;
                                    } else {
                                        sender.sendMessage("Snippet doesn't exist or isn't a string type..!");
                                        commandSuccess = false;
                                    }
                                } else { sender.sendMessage(ChatColor.RED + "You don't have permission to perform this command."); }
                                break;
                            case "reload":
                                if (sender instanceof Player) {
                                    Player player = (Player) sender;
                                    doesHavePermission = player.hasPermission("rawbroadcast.reload");
                                }
                                if (doesHavePermission) {
                                    reloadConfig();
                                    sender.sendMessage(ChatColor.GREEN + "MlntcandyRawBC successfully reloaded.");
                                } else { sender.sendMessage(ChatColor.RED + "You don't have permission to perform this command."); }

                        }
        }
        return commandSuccess;
    }
}
