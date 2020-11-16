/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto1;

/**
 *
 * @author royvi
 */
public class Main {
    
    public static void main(String [] args){
        
        Grafo miGrafo = new Grafo();
//        Menu menu = new Menu(miGrafo);
//        menu.setVisible(true);
        
        miGrafo.anadirNodo("1");
        miGrafo.anadirNodo("2");
        miGrafo.anadirNodo("3");
        miGrafo.anadirNodo("4");
        miGrafo.anadirNodo("5");
        miGrafo.anadirNodo("6");
        miGrafo.anadirNodo("7");
        miGrafo.anadirArista("1", "2", 5);
        miGrafo.anadirArista("1", "3", 3.1);
        miGrafo.anadirArista("1", "6", 5.2);
        miGrafo.anadirArista("2", "7", 5.2);
        miGrafo.anadirArista("2", "3", 4.9);
        miGrafo.anadirArista("3", "7", 3);
        miGrafo.anadirArista("3", "5", 6);
        miGrafo.anadirArista("3", "6", 3.2);
        miGrafo.anadirArista("6", "5", 4.7);
        miGrafo.anadirArista("4", "5", 5.5);
        miGrafo.anadirArista("4", "7", 4.8);
        
        
//        miGrafo.getNodosAdyacentes("1");
//        miGrafo.getNodosAdyacentes("3");
//        miGrafo.getNodosAdyacentes("5");

        miGrafo.visitarNodo("1");
        miGrafo.visitarNodo("3");
        miGrafo.visitarNodo("7");
        miGrafo.visitarNodo("4");
        miGrafo.imprimirVisitados();
        
    }
    
}
