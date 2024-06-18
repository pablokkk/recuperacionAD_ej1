package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Importar datos desde archivo CSV
        LibreriaImporter.importar("ruta/al/archivo.csv");

        // Listar todos los libros
        LibroDAO libroDAO = new LibroDAO();
        List<Libro> libros = libroDAO.listarLibros();
        for (Libro libro : libros) {
            System.out.println(libro.getId() + ": " + libro.getTitle() + ", " + libro.getAuthor());
        }

        // Borrar un libro por id
        libroDAO.borrarLibro(1L); // Cambia el id según sea necesario

        // Listar todos los libros después de borrar
        libros = libroDAO.listarLibros();
        for (Libro libro : libros) {
            System.out.println(libro.getId() + ": " + libro.getTitle() + ", " + libro.getAuthor());
        }
    }
}
