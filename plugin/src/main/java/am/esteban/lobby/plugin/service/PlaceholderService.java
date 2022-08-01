package am.esteban.lobby.plugin.service;

import am.esteban.lobby.api.model.Service;
import am.esteban.lobby.plugin.placeholder.applier.PlaceholderApplier;
import am.esteban.lobby.plugin.placeholder.type.ScoreboardPlaceholder;
import team.unnamed.inject.InjectAll;

@InjectAll
public class PlaceholderService
        implements Service {

    private PlaceholderApplier placeholderApplier;
    private ScoreboardPlaceholder scoreboardPlaceholder;

    @Override
    public void start() {
        placeholderApplier.getPlaceHolders().add(scoreboardPlaceholder);
    }
}
