package me.tezk.fart;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Tom Micallef on 9/04/2016.
 */
public class Fart extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("fart").setExecutor(new FartCommand(this));
    }
}
