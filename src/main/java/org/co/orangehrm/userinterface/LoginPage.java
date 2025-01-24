package org.co.orangehrm.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {
    public static final Target INP_USERNAME = Target.the("input para ingresar usuario").locatedBy("//*[@placeholder='Username']");
    public static final Target INP_PASSWORD = Target.the("input para ingresar contraseña").locatedBy("[name='password']");
    public static final Target BTN_LOGIN = Target.the("botón para ingresar").locatedBy("//button[normalize-space()='Login']");
}
