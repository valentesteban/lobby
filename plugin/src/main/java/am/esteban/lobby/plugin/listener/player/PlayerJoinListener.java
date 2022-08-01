package am.esteban.lobby.plugin.listener.player;

import am.esteban.lobby.plugin.file.BukkitConfigurationFile;
import am.esteban.lobby.plugin.scoreboard.Scoreboard;
import am.esteban.lobby.plugin.scoreboard.registry.ScoreboardRegistry;
import am.esteban.lobby.plugin.world.WorldLocation;
import am.esteban.lobby.plugin.item.ItemHandler;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import team.unnamed.inject.InjectAll;

import javax.inject.Named;
import java.util.List;

import static am.esteban.lobby.api.translate.ChatUtil.translate;

@InjectAll
public class PlayerJoinListener
        implements Listener {

    private ScoreboardRegistry scoreboardRegistry;

    @Named("scoreboard")
    private BukkitConfigurationFile scoreboardConfig;
    @Named("items")
    private BukkitConfigurationFile itemsConfig;
    private BukkitConfigurationFile config;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        List<String> joinMessage = translate(config.getStringList("messages.join-message.text"));

        event.setJoinMessage(null);

        if (config.getBoolean("messages.join-message.enabled")) {
            for (String message : joinMessage) {
                player.sendMessage(message);
            }
        }

        // scoreboard initialize
        if (scoreboardConfig.getConfigurationSection("scoreboard").getBoolean("enable")) {
            Scoreboard scoreboard = new Scoreboard(
                    scoreboardConfig.getConfigurationSection("scoreboard"),
                    String.valueOf(player.getUniqueId())
            );

            scoreboard.show(player);
            scoreboardRegistry.addToRegistry(String.valueOf(player.getUniqueId()), scoreboard);
        }

        player.teleport(WorldLocation.SPAWN);
        player.setGameMode(GameMode.ADVENTURE);

        // set the inventory to the player
        ItemHandler itemHandler = new ItemHandler(itemsConfig);
        itemHandler.setLobbyInventory(player);
    }
}
