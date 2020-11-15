/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Proyecto1;

/**
 *
 * @author andresespinoza
 */
public class Grafo {
    Nodo primerNodo;
    Nodo ultimoNodo;
    
    
   
    public Grafo(){
        this.primerNodo = null;
        this.ultimoNodo = null;
    }
    
    public void imprimir(){
        Nodo navegador = this.primerNodo;
        System.out.println("Nodos del grafo:");
        while(navegador != null){
            System.out.println(navegador.getNombre());
            navegador = navegador.getSiguienteNodo();
        }
        System.out.println("--- Fin del grafo ---");
    }
    
    public int tamano(){
       Nodo navegador = this.primerNodo;
       int contador = 0;
        while(navegador != null){
            System.out.println(navegador.getNombre());
            navegador = navegador.getSiguienteNodo();
            contador++;
        } 
        return contador;
    }
    
    public void anadirNodo(Nodo nuevoNodo){
        if(this.primerNodo == null){
            this.primerNodo = nuevoNodo;
        }
        else if(this.primerNodo.getSiguienteNodo() == null){
            this.primerNodo.setSiguienteNodo(nuevoNodo);
            this.ultimoNodo = nuevoNodo;
        }
        else{
            this.ultimoNodo.setSiguienteNodo(nuevoNodo);
            this.ultimoNodo = nuevoNodo;
        }
    }
    
    public void getNodosAdyacentes(Nodo origen){
        Nodo navegador = this.primerNodo;
        boolean encontrado = false;
        int contador = 0;
        while(encontrado == false && contador <= 10){
            if(navegador == origen){
                encontrado = true;
            }
            else{
                contador++;
                navegador = navegador.getSiguienteNodo();
            }
        }
        if(encontrado == true){
            Vertice vertices = origen.getNodosAdyacentes().getPrimero();
            while(vertices != null){
                System.out.println(vertices.getDestino().getNombre() + " | distancia: " + vertices.getDistancia());
                vertices = vertices.getSiguienteVertice();
            }
        }
    }
    
    public void cargaGrafoDeArchivo(){
        
    }
}
