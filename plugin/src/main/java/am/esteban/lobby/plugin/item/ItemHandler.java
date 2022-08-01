package am.esteban.lobby.plugin.item;

import am.esteban.lobby.plugin.file.BukkitConfigurationFile;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.inject.Inject;
import javax.inject.Named;

import static am.esteban.lobby.api.translate.ChatUtil.translate;

public class ItemHandler {

    @Named("items")
    private final BukkitConfigurationFile itemsConfig;

    @Inject
    public ItemHandler(BukkitConfigurationFile itemsConfig) {
        this.itemsConfig = itemsConfig;
    }

    public void setLobbyInventory(Player player) {
        if (itemsConfig.getBoolean("items.server-selector.enabled")) {
            ItemStack item = new ItemStack(itemsConfig.getInt("items.server-selector.id"));

            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(translate(itemsConfig.getString("items.server-selector.name")));

            if (itemsConfig.getBoolean("items.server-selector.lore-enabled")) {
                meta.setLore(translate(itemsConfig.getStringList("items.server-selector.lore")));
            }

            item.setItemMeta(meta);
            player.getInventory().setItem(itemsConfig.getInt("items.server-selector.slot"), item);
        }

        if (itemsConfig.getBoolean("items.lobbies.enabled")) {
            ItemStack item = new ItemStack(itemsConfig.getInt("items.lobbies.id"));

            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(translate(itemsConfig.getString("items.lobbies.name")));

            if (itemsConfig.getBoolean("items.lobbies.lore-enabled")) {
                meta.setLore(translate(itemsConfig.getStringList("items.lobbies.lore")));
            }

            item.setItemMeta(meta);
            player.getInventory().setItem(itemsConfig.getInt("items.lobbies.slot"), item);
        }

        player.updateInventory();
    }
}
