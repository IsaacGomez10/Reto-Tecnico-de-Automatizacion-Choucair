package org.co.orangehrm.stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import org.co.orangehrm.interactions.ExcelData;
import org.co.orangehrm.library.Excel;
import org.co.orangehrm.navigate.NavigateTo;
import org.co.orangehrm.questions.ValidarEstado;
import org.co.orangehrm.tasks.Login;
import org.co.orangehrm.tasks.RealizarContratacion;
import org.co.orangehrm.userinterface.ReclutamientoPage;

import java.util.Map;

public class ProcesoContratacionStepDefinitions {

    @Dado("el usuario se encuentra en la pagina OrangeHRM")
    public void elUsuarioSeEncuentraEnLaPaginaOrangeHRM() {
        OnStage.theActorInTheSpotlight().wasAbleTo(NavigateTo.orangeHrmPage());
    }

    @Y("^leera el archivo excel (.+) obtentra los datos de la fila (.+)$")
    public void leeraElArchivoExcelDatosCandidatosDeLaFila(String nombre_archivo, int fila) {
        OnStage.withCurrentActor(ExcelData.leer(nombre_archivo, fila));
    }

    @Cuando("ingresa los datos de login accedera el portal")
    public void ingresaLosDatosDeLoginAccederaElPortal(Map<String, String> datos_login) {
        OnStage.withCurrentActor(Login.login(datos_login));
    }

    @Y("en el modulo de reclutamiento con los datos recolectados realizara la contratacion")
    public void conLosDatosRecolectadosRealizaraLaContratacion() {
        OnStage.withCurrentActor(RealizarContratacion.contratar());
    }

    @Entonces("^verificara que el estado del candidato sea (.+)$")
    public void verificaraQueElEstadoDelCandidatoSeaHire(String estado) {
        String nombre = Excel.getTestData("Primer nombre") + " " + Excel.getTestData("Segundo nombre") + " " + Excel.getTestData("Primer apellido");
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(ValidarEstado.de(ReclutamientoPage.ESTADO, estado, nombre))
        );
    }

}
