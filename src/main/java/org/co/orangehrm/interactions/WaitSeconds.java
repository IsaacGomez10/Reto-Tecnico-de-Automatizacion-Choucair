package org.co.orangehrm.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class WaitSeconds implements Interaction {
    private final int seconds;

    public WaitSeconds(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (Exception e) {
            Thread.interrupted();
            e.printStackTrace();
        }
    }

    public static WaitSeconds wait(int seconds) {
        return Tasks.instrumented(WaitSeconds.class, seconds);
    }
}
