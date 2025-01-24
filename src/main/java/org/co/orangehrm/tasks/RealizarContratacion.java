package org.co.orangehrm.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.co.orangehrm.interactions.CargarArchivo;
import org.co.orangehrm.interactions.WaitElement;
import org.co.orangehrm.interactions.WaitSeconds;
import org.co.orangehrm.library.Excel;
import org.co.orangehrm.library.ObtenerRutas;
import org.co.orangehrm.userinterface.InicioPage;
import org.co.orangehrm.userinterface.ReclutamientoPage;

public class RealizarContratacion implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(InicioPage.LINK_RECLUTAR),
                Click.on(ReclutamientoPage.BTN_ADD_CANDIDATO),
                WaitSeconds.wait(1),
                Enter.theValue(Excel.getTestData("Primer nombre")).into(ReclutamientoPage.INP_PRIMER_NOMBRE),
                Enter.theValue(Excel.getTestData("Segundo nombre")).into(ReclutamientoPage.INP_SEGUNDO_NOMBRE),
                Enter.theValue(Excel.getTestData("Primer apellido")).into(ReclutamientoPage.INP_PRIMER_APELLIDO),
                WaitSeconds.wait(1),
                Click.on(ReclutamientoPage.SLC_VACANTE),
                Click.on(ReclutamientoPage.OPT_VACANTE),
                WaitSeconds.wait(1),
                Enter.theValue(Excel.getTestData("Correo")).into(ReclutamientoPage.INP_CORREO),
                WaitSeconds.wait(1),
                Enter.theValue(Excel.getTestData("Numero contacto")).into(ReclutamientoPage.INP_NUMERO_CONTACTO),
                CargarArchivo.cargar(ReclutamientoPage.BTN_CARGAR_ARCHIVO, ObtenerRutas.getPath(Excel.getTestData("Nombre hv"))),
                WaitSeconds.wait(1),
                Click.on(ReclutamientoPage.BTN_GUARDAR),
                WaitElement.untilAppears(ReclutamientoPage.BTN_INICIAR_PROCESO),
                Click.on(ReclutamientoPage.BTN_INICIAR_PROCESO),
                WaitSeconds.wait(1),
                Click.on(ReclutamientoPage.BTN_GUARDAR),
                WaitElement.untilAppears(ReclutamientoPage.BTN_PROGRAMAR_ENTREVISTA),
                Click.on(ReclutamientoPage.BTN_PROGRAMAR_ENTREVISTA),
                Enter.theValue(Excel.getTestData("Titulo entrevista")).into(ReclutamientoPage.INP_TITULO_ENTREVISTA),
                WaitSeconds.wait(1),
                Enter.theValue(Excel.getTestData("Entrevistador")).into(ReclutamientoPage.INP_ENTREVISTADOR),
                WaitElement.untilAppears(ReclutamientoPage.OPT_ENTREVISTADOR),
                Click.on(ReclutamientoPage.OPT_ENTREVISTADOR),
                Enter.theValue(Excel.getTestData("Fecha")).into(ReclutamientoPage.INP_FECHA_ENTREVISTA),
                WaitSeconds.wait(1),
                Enter.theValue(Excel.getTestData("Tiempo")).into(ReclutamientoPage.INP_HORA),
                WaitSeconds.wait(1),
                Click.on(ReclutamientoPage.BTN_GUARDAR),
                WaitElement.untilAppears(ReclutamientoPage.BTN_PASO),
                Click.on(ReclutamientoPage.BTN_PASO),
                WaitSeconds.wait(1),
                Click.on(ReclutamientoPage.BTN_GUARDAR),
                WaitElement.untilAppears(ReclutamientoPage.BTN_DAR_OFERTA),
                Click.on(ReclutamientoPage.BTN_DAR_OFERTA),
                WaitSeconds.wait(1),
                Click.on(ReclutamientoPage.BTN_GUARDAR),
                WaitElement.untilAppears(ReclutamientoPage.BTN_CONTRATAR),
                Click.on(ReclutamientoPage.BTN_CONTRATAR),
                WaitElement.untilAppears(ReclutamientoPage.CONTAINER_INFO),
                Click.on(InicioPage.LINK_RECLUTAR),
                WaitElement.untilAppears(ReclutamientoPage.ESTADO)
        );
    }

    public static RealizarContratacion contratar() {
        return new RealizarContratacion();
    }
}
