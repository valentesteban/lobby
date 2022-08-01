package am.esteban.lobby.plugin.scoreboard.scheduler;

import am.esteban.lobby.plugin.scoreboard.registry.ScoreboardRegistry;
import org.bukkit.scheduler.BukkitRunnable;

import javax.inject.Inject;

public class ScoreboardScheduler
        extends BukkitRunnable {

    @Inject
    private ScoreboardRegistry scoreboardRegistry;

    @Override
    public void run() {
        scoreboardRegistry.updateAll();
    }
}