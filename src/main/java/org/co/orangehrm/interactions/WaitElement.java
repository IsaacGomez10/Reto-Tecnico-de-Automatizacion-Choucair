package org.co.orangehrm.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitElement implements Interaction {
    private Target target;
    private String status;

    public WaitElement(Target target, String status) {
        this.target = target;
        this.status = status;
    }

    @Override
    @Step("{0} waits the #target until be #status")
    public <T extends Actor> void performAs(T actor) {
        switch (status) {
            case "Visible":
                waitAs(actor).until(ExpectedConditions.visibilityOf(target.resolveFor(actor)));
                break;
            case "Invisible":
                waitAs(actor).until(ExpectedConditions.invisibilityOf(target.resolveFor(actor)));

                break;
            case "Enabled":
                waitAs(actor).until(ExpectedConditions.elementToBeClickable(target.resolveFor(actor)));
                break;
        }
    }

    private WebDriverWait waitAs(Actor actor) {
        return new WebDriverWait(BrowseTheWeb.as(actor).getDriver(), Duration.ofSeconds(10));
    }


    public static WaitElement untilAppears(Target target) {
        return Tasks.instrumented(WaitElement.class,target, "Visible");
    }


    public static WaitElement untilDisappears(Target target) {
        return Tasks.instrumented(WaitElement.class,target, "Invisible");
    }


    public static WaitElement untilBeEnable(Target target) {
        return Tasks.instrumented(WaitElement.class,target, "Enabled");
    }
}
