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
public class Nodo {
    String nombre;
    float tau;
    Lista_Adyacencia nodosAdyacentes;
    Nodo siguienteNodo;
    
    public Nodo(String nombreNodo, float ferom){
        this.nombre = nombreNodo;
        this.tau = ferom;
        this.siguienteNodo = null;
        this.nodosAdyacentes = null;
    }
    
    public Nodo(){
        this.nombre = "";
        this.tau = 0.0f;
        this.siguienteNodo = null;
        this.nodosAdyacentes = null;
    }
    
    public Nodo(String nuevoNombre){
        this.nombre = nuevoNombre;
        this.tau = 0.0f;
        this.siguienteNodo = null;
        this.nodosAdyacentes = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getFeromonas() {
        return tau;
    }

    public void setFeromonas(float tau) {
        this.tau = tau;
    }

    public Lista_Adyacencia getNodosAdyacentes() {
        return nodosAdyacentes;
    }

    public void setNodosAdyacentes(Lista_Adyacencia nodosAdyacentes) {
        this.nodosAdyacentes = nodosAdyacentes;
    }

    public Nodo getSiguienteNodo() {
        return siguienteNodo;
    }

    public void setSiguienteNodo(Nodo siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }
    
}
