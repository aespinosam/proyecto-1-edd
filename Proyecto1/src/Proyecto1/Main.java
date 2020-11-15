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
        Nodo Caracas = new Nodo("Caracas");
        Nodo Miami = new Nodo("Miami");
        Nodo Madrid = new Nodo("Madrid");
        Nodo Barcelona = new Nodo("Barcelona");
        
        Vertice CaracasMadrid = new Vertice(Caracas, Madrid, 5);
        Vertice CaracasMiami = new Vertice(Caracas, Miami, 4);
        
        Lista_Adyacencia adyacenciaMiami = new Lista_Adyacencia();
        adyacenciaMiami.anadirSiguiente(Miami, Madrid, 2);
        adyacenciaMiami.anadirSiguiente(Miami, Caracas, 6);
        
        Lista_Adyacencia adyacenciaCaracas = new Lista_Adyacencia();
        adyacenciaCaracas.anadirSiguiente(Caracas, Miami, 9);
        adyacenciaCaracas.anadirSiguiente(Caracas, Barcelona, 2);
        
        Lista_Adyacencia adyacenciaMadrid = new Lista_Adyacencia();
        adyacenciaMadrid.anadirSiguiente(Madrid, Caracas, 7);
        adyacenciaMadrid.anadirSiguiente(Madrid, Barcelona, 1);
        adyacenciaMadrid.anadirSiguiente(Madrid, Miami, 4);
        
        Miami.setNodosAdyacentes(adyacenciaMiami);
        Caracas.setNodosAdyacentes(adyacenciaCaracas);
        Madrid.setNodosAdyacentes(adyacenciaMadrid);
        
        miGrafo.anadirNodo(Caracas);
        miGrafo.anadirNodo(Miami);
        miGrafo.anadirNodo(Madrid);
        miGrafo.getNodosAdyacentes(Miami);
        System.out.println("---");
        miGrafo.getNodosAdyacentes(Caracas);
        
    }
    
}
