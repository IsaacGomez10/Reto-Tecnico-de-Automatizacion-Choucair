package org.co.orangehrm.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.co.orangehrm.userinterface.InicioPage;
import org.co.orangehrm.userinterface.ReclutamientoPage;

public class AgregarCandidato implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(InicioPage.LINK_RECLUTAR),
                Click.on(ReclutamientoPage.BTN_ADD_CANDIDATO)
        );
    }

    public static AgregarCandidato adicionar() {
        return new AgregarCandidato();
    }
}
