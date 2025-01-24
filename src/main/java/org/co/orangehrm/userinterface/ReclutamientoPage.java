package org.co.orangehrm.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class ReclutamientoPage {
    // parte inicial de reclutamiento
    public static final Target BTN_ADD_CANDIDATO = Target.the("adicionar un candidato para una posición").locatedBy("//button[normalize-space()='Add']");
    public static final Target INP_PRIMER_NOMBRE = Target.the("ingresar primer nombre").locatedBy("//input[@name='firstName']");
    public static final Target INP_SEGUNDO_NOMBRE = Target.the("ingresar segundo nombre").locatedBy("//input[@name='middleName']");
    public static final Target INP_PRIMER_APELLIDO = Target.the("ingresar primer apellido").locatedBy("//input[@name='lastName']");
    public static final Target SLC_VACANTE = Target.the("para seleccionar la vacante").locatedBy("//div[@class='oxd-select-text oxd-select-text--active']//div[1]");
    public static final Target OPT_VACANTE = Target.the("seleccionar vacante").locatedBy("//span[text()='Payroll Administrator']");

    public static final Target INP_CORREO = Target.the("ingresar correo").locatedBy("(//input[@class='oxd-input oxd-input--active'])[2]");
    public static final Target INP_NUMERO_CONTACTO = Target.the("ingresar numero de contacto").locatedBy("(//input[@placeholder='Type here'])[2]");
    public static final Target BTN_CARGAR_ARCHIVO = Target.the("cargar documento de hv").locatedBy("//div[normalize-space(text())='Browse']");
    public static final Target BTN_GUARDAR = Target.the("guardar la informacion ingresada").locatedBy("//button[contains(.,'Save')]");

    // PARTE DE POROCESO DE SELECCION
    public static final Target BTN_INICIAR_PROCESO = Target.the("inicia el proceso con los que se encuentren en la lista").locatedBy("//button[contains(.,'Shortlist')]");

    // REALIZAR ENTREVISTA
    public static final Target BTN_PROGRAMAR_ENTREVISTA = Target.the("proceso de programar entrevista").locatedBy("//button[contains(.,'Schedule Interview')]");
    public static final Target INP_TITULO_ENTREVISTA = Target.the("titulo para la entrevista").locatedBy("(//input[@class='oxd-input oxd-input--active'])[6]");
    public static final Target INP_ENTREVISTADOR = Target.the("ingresar nombre de entrevistador").locatedBy("//input[@placeholder='Type for hints...']");
    public static final Target OPT_ENTREVISTADOR = Target.the("seleccionar nombre de entrevistador").locatedBy("//div[@role='option']/span[1]");
    public static final Target INP_FECHA_ENTREVISTA = Target.the("ingresar fecha de entrevista").locatedBy("//input[@placeholder='yyyy-dd-mm']");
    public static final Target INP_HORA = Target.the("ingresar hora de entrevista").locatedBy("//input[@placeholder='hh:mm']");
    public static final Target INP_HORAS = Target.the("ingresar horas de entrevista").locatedBy("//input[@class='oxd-input oxd-input--active oxd-time-hour-input-text']");

    public static final Target BTN_PASO = Target.the("paso so la entrevista").locatedBy("//button[normalize-space()='Mark Interview Passed']");
    public static final Target BTN_DAR_OFERTA = Target.the("ofrecer la oferta").locatedBy("//button[normalize-space()='Offer Job']");
    public static final Target BTN_CONTRATAR = Target.the("contratar al candidato").locatedBy("//button[normalize-space()='Hire']");
    public static final Target CONTAINER_INFO = Target.the("informacion contratacion").locatedBy("(//div[@class='orangehrm-card-container'])[1]");


    // VERIFICAR LOS DATOS Y EL ESTADO
    public static final Target ROW_CANDIDATO = Target.the("fila donde se encuentra el candidato").locatedBy("(//div[@class='oxd-table-card'])[1]");
    public static final Target ESTADO = Target.the("obtener el estado del candidato").locatedBy("(//div[@role='rowgroup'])[2]/div");



}