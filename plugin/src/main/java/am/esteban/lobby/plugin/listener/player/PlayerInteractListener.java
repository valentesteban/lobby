package am.esteban.lobby.plugin.listener.player;

import am.esteban.lobby.plugin.file.BukkitConfigurationFile;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import team.unnamed.inject.InjectAll;

import javax.inject.Named;

import static am.esteban.lobby.api.translate.ChatUtil.translate;

@InjectAll
public class PlayerInteractListener
        implements Listener {

    @Named("items")
    private BukkitConfigurationFile itemConfig;

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (player.getItemInHand() == null || player.getItemInHand().getType() == Material.AIR) {
            return;
        }

        if (player.getGameMode() == GameMode.CREATIVE) {
            return;
        }

        if (event.getAction().name().startsWith("RIGHT_")) {
            ItemStack item = event.getItem();

            // if the item is equal to
            // null return
            if (item == null) {
                return;
            }

            // server selector item
            if (item.getType().getId() == itemConfig.getInt("items.server-selector.id")) {
                player.sendMessage(translate("This feature is currently on progress.."));
            }

            // lobbies item
            if (item.getType().getId() == itemConfig.getInt("items.lobbies.id")) {
                player.sendMessage(translate("This featurec is currently on progress.."));
            }
        }
    }
}
