package am.esteban.lobby.plugin.service;

import am.esteban.lobby.api.model.Service;
import am.esteban.lobby.plugin.Lobby;
import am.esteban.lobby.plugin.scoreboard.scheduler.ScoreboardScheduler;
import team.unnamed.inject.InjectAll;

@InjectAll
public class SchedulerService
        implements Service {

    private Lobby lobby;

    private ScoreboardScheduler scoreboardScheduler;

    @Override
    public void start() {
        scoreboardScheduler.runTaskTimerAsynchronously(
                lobby,
                300,
                1);
    }

    @Override
    public void stop() {
        scoreboardScheduler.cancel();
    }
}
