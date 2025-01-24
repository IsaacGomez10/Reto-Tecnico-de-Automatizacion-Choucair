package org.co.orangehrm.library;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Excel {
    private static Map<String, String> data_test;
    private static int fila_datos;

    public Excel(String nombre_archivo, int fila) {
        data_test = readData(getExcel(nombre_archivo), fila);
    }

    private static File getExcel(String nombre_archivo) {
        Path ruta_archivo = Paths.get("src/test/resources/testdata/" + nombre_archivo + ".xlsx");
        File archivo_excel = ruta_archivo.toFile();
        return archivo_excel;
    }

    private Map<String, String> readData(File archivo, int fila) {
        Map<String, String> datos = new HashMap<>();
        fila_datos = fila - 1;

        try (FileInputStream archivoEntrada = new FileInputStream(archivo)) {
            Workbook libro = new XSSFWorkbook(archivoEntrada);
            Sheet hoja = libro.getSheetAt(0);
            Row fila_encabeza = hoja.getRow(0);
            Row fila_dato = hoja.getRow(fila_datos);

            for (int i = 0; i < fila_encabeza.getPhysicalNumberOfCells(); i++) {
                Cell celda_encabezado = fila_encabeza.getCell(i);

                String encabezado = celda_encabezado.getStringCellValue().trim();
                Cell celda_data = fila_dato.getCell(i);
                datos.put(encabezado, getCellValue(celda_data));
            }
        } catch (Exception e) {
        }
        return datos;
    }

    private String getCellValue(Cell celda) {
        switch (celda.getCellType()) {
            case STRING:
                return celda.getStringCellValue();
            case NUMERIC:
                double numero = Double.parseDouble(String.valueOf(celda.getNumericCellValue()));
                return String.valueOf((int) numero);
            default:
                return "";
        }
    }

    public static String getTestData(String key) {
        return data_test.get(key);
    }

}
