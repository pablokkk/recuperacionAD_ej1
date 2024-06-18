package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class LibreriaImporter {
    public static void importar(String archivo) {
        String linea;
        String separador = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            LibroDAO libroDAO = new LibroDAO();
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(separador);

                if (datos.length == 4) {
                    Libro libro = new Libro();
                    libro.setTitle(datos[0]);
                    libro.setAuthor(datos[1]);
                    libro.setYear(Integer.parseInt(datos[2]));
                    libro.setPublisher(datos[3]);
                    libro.setCreated(new Date());

                    libroDAO.insertarLibro(libro);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
