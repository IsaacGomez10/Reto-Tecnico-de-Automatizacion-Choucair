package org.co.orangehrm.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.co.orangehrm.interactions.WaitElement;
import org.co.orangehrm.userinterface.LoginPage;

import java.util.Map;

public class Login implements Task {
    private final Map<String, String> datos_login;

    public Login(Map<String, String> datosLogin) {
        datos_login = datosLogin;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitElement.untilAppears(LoginPage.INP_USERNAME),
                Enter.theValue(datos_login.get("usuario")).into(LoginPage.INP_USERNAME),
                Enter.theValue(datos_login.get("contraseña")).into(LoginPage.INP_PASSWORD),
                Click.on(LoginPage.BTN_LOGIN)
        );
    }

    public static Login login(Map<String, String> datos_login) {
        return new Login(datos_login);
    }
}
