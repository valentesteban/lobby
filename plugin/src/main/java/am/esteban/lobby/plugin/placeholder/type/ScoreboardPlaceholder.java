package am.esteban.lobby.plugin.placeholder.type;

import am.esteban.lobby.plugin.file.BukkitConfigurationFile;
import am.esteban.lobby.plugin.placeholder.Placeholder;
import org.bukkit.entity.Player;
import team.unnamed.inject.InjectAll;

@InjectAll
public class ScoreboardPlaceholder
        implements Placeholder {

    private BukkitConfigurationFile config;

    @Override
    public String getName() {
        return "scoreboard";
    }

    @Override
    public String apply(Player player, String text) {
        if (player == null) {
            return "";
        }

        String lobbyNumber = config.getString("lobby-number");

        switch (text) {
            case "player-name":
                return player.getDisplayName();
            case "lobby-number":
                return lobbyNumber;
            case "star-symbol":
                return "★";
            default:
                return "";
        }
    }
}
