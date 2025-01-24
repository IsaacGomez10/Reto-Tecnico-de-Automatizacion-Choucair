package org.co.orangehrm.interactions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;


public class PressKey implements Task {
    public static String TAB = "TAB";

    private final String key;

    public PressKey(String key) {
        this.key = key;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Robot robot;
        try {
            robot = new Robot();
            switch (key){
                case "TAB":
                    robot.keyPress(KeyEvent.VK_TAB);
                    robot.keyRelease(KeyEvent.VK_TAB);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static PressKey press(String key) {
        return Tasks.instrumented(PressKey.class, key);
    }
}
