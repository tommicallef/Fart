package me.tezk.fart;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Tom Micallef on 9/04/2016.
 */
public class FartCommand implements CommandExecutor {
    private final Fart fart;
    public FartCommand(final Fart fart) {
        this.fart = fart;
    }

    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You can only fart as a human. ;)");
            return true;
        }

        final Player player = (Player) sender;
        if (!(player.hasPermission("fart.fart"))) {
            player.sendMessage(ChatColor.RED + "You don't have permission to do this.");
            return true;
        }
        // fart <player>
        if (args.length == 0) {
            player.playEffect(player.getLocation(), Effect.CLOUD, null);
            player.playSound(player.getLocation(), Sound.BLOCK_SAND_HIT, 5, 5);

        } else if (args.length == 1) {
            final Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {
                player.playEffect(player.getLocation(), Effect.CLOUD, null);
                player.playSound(player.getLocation(), Sound.BLOCK_SAND_HIT, 5, 5);

            } else {
                player.sendMessage(ChatColor.RED + "That player isn't online!");
            }

        } else {
            player.sendMessage(ChatColor.RED + "Command usage: /fart <player>");
        }
        return true;
    }
}
