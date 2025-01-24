package org.co.orangehrm.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import org.co.orangehrm.library.Excel;

public class ExcelData implements Interaction {
    private final String nombre_archivo;
    private final int fila;

    public ExcelData(String nombreArchivo, int fila) {
        nombre_archivo = nombreArchivo;
        this.fila = fila;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        new Excel(nombre_archivo, fila);
    }

    public static ExcelData leer(String nombre_archivo, int fila) {
        return Tasks.instrumented(ExcelData.class, nombre_archivo, fila);
    }
}
