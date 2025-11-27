package com.gestorlibros.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import com.gestorlibros.model.GestorLibrosModel;
import com.gestorlibros.model.Libro;
import com.gestorlibros.view.View;

public class Controller implements Serializable{

    GestorLibrosModel m;
    View v;

    public Controller(GestorLibrosModel m, View v) {
        this.m = m;
        this.v = v;
        // Inyectamos el controlador en la vista
        v.setC(this);
    }

    public void initApp() throws IOException, ClassNotFoundException {

        // Load data
        

        // Show Menu
        v.startMenu();
        
        m.saveStateOfTheApp();
        //Save data
    }

    public ArrayList<Libro> getLibros() {
        return m.getLibros();
    }

    public void addLibro(Libro l) {
        m.addLibro(l);
    }

    public void removeLibro(Libro libro) {
        m.removeLibro(libro);
    }
    public int loadStateOfTheApp() throws ClassNotFoundException, IOException{
       return m.loadStateOfTheApp();
    }
    public void updateLibro(Libro libroAModificar) {
        m.updateLibro(libroAModificar);
    }

    public int exportBooksToCSV() throws IOException {
        System.out.println("Archivo CSV exportando a escritorio");
        return m.exportBooksToCSV();
    }

    public int exportBooksToJSON() {
        return m.exportBooksToJSON();
    }

    public int importBooksFromJSON() throws IOException {
        return m.importBooksFromJSON();
    }

    public int importBooksFromCSV() throws FileNotFoundException {
        return m.importBooksFromCSV();
    }

    public int importBooksFromXML() {
        return m.importBooksFromXML();
    }

    public int exportBooksToXML() {
        return m.exportBooksToXML();
    }
    
}
