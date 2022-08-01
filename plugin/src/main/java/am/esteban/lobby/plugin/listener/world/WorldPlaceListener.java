package am.esteban.lobby.plugin.listener.world;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import team.unnamed.inject.InjectAll;

@InjectAll
public class WorldPlaceListener
        implements Listener {

    @EventHandler
    public void onWorldPlaceBlock(BlockPlaceEvent event) {
        Player player = event.getPlayer();

        if (!player.isOp() && !(player.getGameMode() == GameMode.CREATIVE)) {
            event.setCancelled(true);
        }
    }

}
