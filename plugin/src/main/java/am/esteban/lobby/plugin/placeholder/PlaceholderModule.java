package am.esteban.lobby.plugin.placeholder;

import am.esteban.lobby.plugin.placeholder.type.ScoreboardPlaceholder;
import team.unnamed.inject.AbstractModule;

public class PlaceholderModule
        extends AbstractModule {

    @Override
    protected void configure() {
        bind(Placeholder.class)
                .to(ScoreboardPlaceholder.class)
                .singleton();
    }
}
