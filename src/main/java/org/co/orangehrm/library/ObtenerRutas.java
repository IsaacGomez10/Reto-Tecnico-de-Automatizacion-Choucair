package org.co.orangehrm.library;

import java.io.File;

public class ObtenerRutas {
    public static String getPath(String nombre_archivo) {
        File archivo = new File("src/test/resources/files/" + nombre_archivo);
        return archivo.getAbsolutePath();
    }
}
