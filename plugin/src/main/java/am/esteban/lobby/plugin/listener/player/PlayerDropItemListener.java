package am.esteban.lobby.plugin.listener.player;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import team.unnamed.inject.InjectAll;

@InjectAll
public class PlayerDropItemListener
        implements Listener {

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        Player player = event.getPlayer();

        if (player.isOp() && player.getGameMode() == GameMode.CREATIVE) {
            return;
        }

        event.setCancelled(true);
    }
}
