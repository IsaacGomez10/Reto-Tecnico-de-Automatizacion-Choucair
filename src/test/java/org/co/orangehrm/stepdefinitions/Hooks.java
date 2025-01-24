package org.co.orangehrm.stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import org.openqa.selenium.WebDriver;

public class Hooks {
    @Managed
    private static WebDriver driver;

    @Before
    public void setUp(){
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled("Admin");
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(driver));
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
