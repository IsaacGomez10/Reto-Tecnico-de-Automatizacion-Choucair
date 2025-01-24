package org.co.orangehrm.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;

public class ValidarEstado implements Question<Boolean> {
    private final Target target;
    private final String[] datos;

    public ValidarEstado(Target target, String... datos) {
        this.target = target;
        this.datos = datos;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        List<WebElementFacade> elementos = target.resolveAllFor(actor);
        boolean encontrado = false;
        for (WebElementFacade elemento: elementos){
            if (elemento.getText().contains(datos[0]) && elemento.getText().contains(datos[1])){
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }

    public static ValidarEstado de(Target target, String... datos) {
        return new ValidarEstado(target, datos);
    }
}
