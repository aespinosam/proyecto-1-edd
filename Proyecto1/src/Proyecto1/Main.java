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
//        menu.show();
        
        miGrafo.anadirNodo("Caracas");
        miGrafo.anadirNodo("Miami");
        miGrafo.anadirNodo("Madrid");
        miGrafo.anadirNodo("Barcelona");
        miGrafo.anadirNodo("New York");
        miGrafo.anadirArista("caracas", "madrid", 10);
        miGrafo.anadirArista("caracas", "barcelona", 4);
        miGrafo.anadirArista("caracas", "miami", 4);
        miGrafo.anadirArista("caracas", "new york", 4);
        miGrafo.getNodosAdyacentes("caracas");
        
    }
    
}
