package org.co.orangehrm.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;


public class CargarArchivo implements Interaction {
    private final Target target;
    private final String ruta;

    public CargarArchivo(Target target, String ruta) {
        this.target = target;
        this.ruta = ruta;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(target));
        try {
            StringSelection stringSelection = new StringSelection(ruta);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.delay(500);
            robot.keyPress(KeyEvent.VK_V);
            robot.delay(500);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(500);
            robot.keyRelease(KeyEvent.VK_V);
            robot.delay(500);
            robot.keyPress(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static CargarArchivo cargar(Target target, String ruta) {
        return Tasks.instrumented(CargarArchivo.class, target, ruta);
    }
}