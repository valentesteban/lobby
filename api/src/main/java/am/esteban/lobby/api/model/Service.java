package am.esteban.lobby.api.model;

public interface Service {

    void start();

    default void stop() {}
}
