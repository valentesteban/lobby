package am.esteban.lobby.plugin.listener.entity;

import am.esteban.lobby.plugin.world.WorldLocation;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import team.unnamed.inject.InjectAll;

@InjectAll
public class EntityDamageListener
        implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) {
            return;
        }

        event.setCancelled(true);

        if (event.getCause() == EntityDamageEvent.DamageCause.VOID) {
            Player player = (Player) event.getEntity();

            player.teleport(WorldLocation.SPAWN);
        }
    }
}
