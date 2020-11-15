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
public class Lista_Adyacencia {
    Vertice primero;
    Vertice ultimo;
    
    public Lista_Adyacencia(){
        this.primero = null;
        this.ultimo = null;
    }

    public Vertice getPrimero() {
        return primero;
    }

    public void setPrimero(Vertice primero) {
        this.primero = primero;
    }

    public Vertice getUltimo() {
        return ultimo;
    }

    public void setUltimo(Vertice ultimo) {
        this.ultimo = ultimo;
    }
    
    public int tamano(){
        Vertice navegador = this.primero;
        int contador = 0;
        while(navegador != null){
            contador++;
            navegador = navegador.getSiguienteVertice();
        }
        return contador;
    }
    
    public void anadirSiguiente(Nodo origen, Nodo destino, float distancia){
        Vertice nuevoVertice = new Vertice(origen, destino, distancia);
        int tamano = this.tamano();
        if(tamano == 0){
            this.primero = nuevoVertice;
        }
        else if(tamano == 1){
            this.primero.setSiguienteVertice(nuevoVertice);
            this.ultimo = nuevoVertice;
        }
        else{
            this.ultimo.setSiguienteVertice(nuevoVertice);
            this.ultimo = nuevoVertice;
        }
    }
    
    public void imprimir(){
        Vertice navegador = this.primero;
        
        while(navegador != null){
            System.out.println(navegador.getOrigen().getNombre() + "---" + navegador.getDistancia() + "--->" + navegador.getDestino().getNombre());
            navegador = navegador.getSiguienteVertice();
        }
 
    }
    
}
