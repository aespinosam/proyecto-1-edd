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
public class Arista {
    Nodo origen;
    Nodo destino;
    float distancia;
    Arista siguienteArista;
    
    public Arista(Nodo orig, Nodo dest, float dist){
        this.origen = orig;
        this.destino = dest;
        this.distancia = dist;
        this.siguienteArista = null;
        
    }
    
    public Arista(){
        this.origen = null;
        this.destino = null;
        this.distancia = 0F;
        this.siguienteArista = null;
    }

    public Nodo getOrigen() {
        return origen;
    }

    public void setOrigen(Nodo origen) {
        this.origen = origen;
    }

    public Nodo getDestino() {
        return destino;
    }

    public void setDestino(Nodo destino) {
        this.destino = destino;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public Arista getSiguienteArista() {
        return siguienteArista;
    }

    public void setSiguienteArista(Arista siguienteArista) {
        this.siguienteArista = siguienteArista;
    }
    
    
    
}
