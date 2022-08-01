package am.esteban.lobby.plugin.listener.world;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import team.unnamed.inject.InjectAll;

@InjectAll
public class WorldWeatherListener
        implements Listener {

    @EventHandler
    public void onWorldRain(WeatherChangeEvent event) {
        if (event.toWeatherState()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onWorldLeavesDecay(LeavesDecayEvent event) {
        event.setCancelled(true);
    }
}
