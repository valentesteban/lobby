package am.esteban.lobby.api.timer.impl;

import am.esteban.lobby.api.timer.TimeUtil;
import am.esteban.lobby.api.timer.Timer;

import java.util.concurrent.TimeUnit;

public class IntegerTimer
        extends Timer {

    public IntegerTimer(TimeUnit unit, int amount) {
        super(unit, amount);
    }

    @Override
    public String formattedExpiration() {
        return TimeUtil.formatTimeMillis(expiry - System.currentTimeMillis());
    }
}
