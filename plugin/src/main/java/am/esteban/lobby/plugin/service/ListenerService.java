package am.esteban.lobby.plugin.service;

import am.esteban.lobby.api.model.Service;
import am.esteban.lobby.plugin.Lobby;
import am.esteban.lobby.plugin.listener.entity.EntityDamageListener;
import am.esteban.lobby.plugin.listener.world.WorldBreakListener;
import am.esteban.lobby.plugin.listener.world.WorldPlaceListener;
import am.esteban.lobby.plugin.listener.world.WorldWeatherListener;
import am.esteban.lobby.plugin.listener.player.PlayerDropItemListener;
import am.esteban.lobby.plugin.listener.player.PlayerHungerListener;
import am.esteban.lobby.plugin.listener.player.PlayerInteractListener;
import am.esteban.lobby.plugin.listener.player.PlayerInventoryListener;
import am.esteban.lobby.plugin.listener.player.PlayerJoinListener;
import am.esteban.lobby.plugin.listener.player.PlayerQuitListener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import team.unnamed.inject.InjectAll;
import team.unnamed.menu.listener.MenuListener;

@InjectAll
public class ListenerService
        implements Service {

    private Lobby lobby;

    private EntityDamageListener entityDamageListener;
    private PlayerDropItemListener playerDropItemListener;
    private PlayerHungerListener playerHungerListener;
    private PlayerInteractListener playerInteractListener;
    private PlayerInventoryListener playerInventoryListener;
    private PlayerJoinListener playerJoinListener;
    private PlayerQuitListener playerQuitListener;
    private WorldBreakListener worldBreakListener;
    private WorldPlaceListener worldPlaceListener;
    private WorldWeatherListener worldWeatherListener;
    private MenuListener menuListener;

    @Override
    public void start() {
        registerListeners(
                entityDamageListener,
                playerDropItemListener,
                playerHungerListener,
                playerInteractListener,
                playerInventoryListener,
                playerJoinListener,
                playerQuitListener,
                worldBreakListener,
                worldPlaceListener,
                worldWeatherListener,
                menuListener
        );
    }

    private void registerListeners(Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getPluginManager().registerEvents(listener, lobby);
        }
    }
}
