package com.gestorlibros.model;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

import com.coti.tools.Rutas;
import com.google.gson.Gson;
import com.fasterxml.jackson.dataformat.xml.*;

public class GestorLibrosModel implements Serializable {

    ArrayList<Libro> libros;

    // Path to export and import data
    Path pathToXML = Rutas.pathToFileOnDesktop("libros.xml");
    Path pathToJSON = Rutas.pathToFileOnDesktop("libros.json");
    Path pathToCSV = Rutas.pathToFileOnDesktop("libros.csv");
    Path pathToBinary = Rutas.pathToFileOnDesktop("libros.bin");

    public GestorLibrosModel() {
        libros = new ArrayList<Libro>();
    }

    // CRUD OPERATIONS
    public void addLibro(Libro l) {
        libros.add(l);
    }

    public void removeLibro(Libro l) {
        libros.remove(l);
    }

    public void updateLibro(Libro l) {
        libros.set(libros.indexOf(l), l);
    }

    public ArrayList<Libro> getLibros() {
        // Devolvemos copia para no modificar el original desde la vista.
        return new ArrayList<Libro>(this.libros);
    }

    // Export and Import data ------------------------------------------
    public int exportBooksToCSV() throws IOException {
        
        Path p = Paths.get(System.getProperty("user.home"), "Desktop", "libros.csv");
        FileWriter fw = new FileWriter(p.toFile());
        String linea;
        ArrayList<Libro> libros = getLibros();
        for(Libro libro : libros){
            linea = String.format("%s,%s,%s,%s,%d,%d,%.2f", libro.getISBN(), libro.getTitulo(), libro.getAutor(), libro.getEditorial(), libro.getAnyoPublicacion(), libro.getNumPaginas(), libro.getPrecio());
            fw.write(linea);
        }
        fw.close();
        return 0;
        
    }

    public int importBooksFromCSV() throws FileNotFoundException {
        Path p = Paths.get(System.getProperty("user.home"), "Desktop", "libros.csv");
        Scanner sc = new Scanner(p.toFile());
        while(sc.hasNextLine()){
            String linea = sc.nextLine();
            String[] lineas = linea.split(",");
            Libro nuevo = new Libro(lineas[0], lineas[1], lineas[2], lineas[3], Integer.parseInt(lineas[4]), Integer.parseInt(lineas[5]), Float.parseFloat(lineas[6]));
            addLibro(nuevo);
        }
        return 0;
        
    }

    public int exportBooksToJSON() {

        ArrayList<Libro> libs = getLibros();
        Gson gson = new Gson();
        Path p = Paths.get(System.getProperty("user.home"), "Desktop", "libros.json");

        try (FileWriter fw = new FileWriter(p.toFile(), StandardCharsets.UTF_8)) {
            String json = gson.toJson(libs);
            fw.write(json);
        } catch (IOException e) {
        return -1; 
    }

    System.out.println("Archivo JSON creado correctamente");
    return 0; // Todo bien
}

    public int importBooksFromJSON() throws IOException {

        Gson gson = new Gson();
        Path p = Paths.get(System.getProperty("user.home"), "Desktop", "libros.json");
        String contenido = Files.readString(p, StandardCharsets.UTF_8);
        Libro[] librosArray = gson.fromJson(contenido, Libro[].class);
        
        if (librosArray != null) {
            libros.clear();           
            libros.addAll(Arrays.asList(librosArray));
        }
        System.out.println("Libros importados correctamente desde JSON");
        
        return 0;

    }

    public int importBooksFromXML() {
        throw new UnsupportedOperationException("Unimplemented method 'importBooksFromCSV'");  
    }

    public int exportBooksToXML() {
        XmlMapper mapper = new XmlMapper();
        ArrayList<Libro> libs = getLibros();
        try{
            String xml = mapper.writeValueAsString(libs);
            Files.writeString(pathToXML, xml, StandardCharsets.UTF_8);
        }catch(IOException e){
            System.out.println("Error al escribir XML"+ e.getMessage());
        }

        return 0;
        
    }

    // Serialization and Deserialization ------------------------------------------
    public int saveStateOfTheApp() throws IOException{

        ArrayList<Libro> libs = getLibros();
        FileOutputStream f = new FileOutputStream(pathToBinary.toFile());
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(libs);
        return 0;
        
    }

    public int loadStateOfTheApp() throws IOException, ClassNotFoundException{

        FileInputStream f = new FileInputStream(pathToBinary.toFile());
        ObjectInputStream o = new ObjectInputStream(f);
        
        libros = (ArrayList<Libro>) o.readObject();
        o.close();
        return 0;

    }



}
