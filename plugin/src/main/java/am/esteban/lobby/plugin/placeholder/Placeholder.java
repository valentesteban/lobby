package am.esteban.lobby.plugin.placeholder;

import org.bukkit.entity.Player;

public interface Placeholder {

    String getName();

    String apply(Player player, String text);
}