package am.esteban.lobby.plugin;

import am.esteban.lobby.api.model.Service;
import am.esteban.lobby.plugin.file.BukkitConfigurationFile;
import am.esteban.lobby.plugin.placeholder.PlaceholderModule;
import am.esteban.lobby.plugin.service.PlaceholderService;
import am.esteban.lobby.plugin.scoreboard.registry.ScoreboardRegistry;
import am.esteban.lobby.plugin.service.ListenerService;
import am.esteban.lobby.plugin.service.SchedulerService;
import team.unnamed.inject.AbstractModule;

import java.util.HashSet;
import java.util.Set;

public class LobbyModule
        extends AbstractModule {

    private final Lobby lobby;

    public LobbyModule(Lobby lobby) {
        this.lobby = lobby;
    }

    @Override
    protected void configure() {
        BukkitConfigurationFile config = new BukkitConfigurationFile(lobby, "config");
        bind(BukkitConfigurationFile.class)
                .toInstance(config);

        bind(BukkitConfigurationFile.class)
                .named("scoreboard")
                .toInstance(new BukkitConfigurationFile(lobby, "scoreboard"));

        bind(BukkitConfigurationFile.class)
                .named("items")
                .toInstance(new BukkitConfigurationFile(lobby, "items"));

        multibind(Service.class)
                .asCollection(Set.class, HashSet::new)
                .to(ListenerService.class)
                .to(PlaceholderService.class)
                .to(SchedulerService.class)
                .singleton();

        bind(ScoreboardRegistry.class)
                .singleton();

        install(new PlaceholderModule());

        bind(Lobby.class).toInstance(lobby);
    }
}
