package am.esteban.lobby.api.timer;

public interface ITimer {

    boolean isActive(boolean autoReset);
    boolean isActive();

    String formattedExpiration();

    void reset();
}
