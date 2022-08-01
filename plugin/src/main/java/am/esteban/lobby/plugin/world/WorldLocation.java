package am.esteban.lobby.plugin.world;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class WorldLocation {

    public static final Location SPAWN;
    private static final World WORLD = Bukkit.getWorlds().get(0);

    static {
        SPAWN = WORLD.getSpawnLocation();

        SPAWN.setX(SPAWN.getBlockX() + 0.5);
        SPAWN.setZ(SPAWN.getBlockZ() + 0.5);
        SPAWN.setYaw(180.0F);
    }
}
