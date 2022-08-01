package am.esteban.lobby.plugin.listener.player;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import team.unnamed.inject.InjectAll;

@InjectAll
public class PlayerInventoryListener
        implements Listener {

    @EventHandler
    public void onInventoryMove(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (player.isOp() && player.getGameMode() == GameMode.CREATIVE) {
            return;
        }

        if (event.getClickedInventory() == player.getInventory()) {
            event.setCancelled(true);
        }
    }
}
