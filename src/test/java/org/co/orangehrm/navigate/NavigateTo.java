package org.co.orangehrm.navigate;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable orangeHrmPage() {
        return Task.where("{0} ingresa a la pagina OrangeHRM", Open.browserOn().the(OrangeHrmPage.class));
    }
}
