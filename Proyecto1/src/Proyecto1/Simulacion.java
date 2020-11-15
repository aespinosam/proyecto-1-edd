/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto1;

import javax.swing.JOptionPane;

/**
 *
 * @author andresespinoza
 */
public class Simulacion {
    Grafo grafoSim;             // El grafo en el que se va a correr la simulacion
    Nodo inicio;                // El nodo donde se va a arrancar
    Nodo destino;               // El nodo destino a donde se quiere llegar
    float alfa;                 // La importancia que se le quiere dar a las feromonas
    float beta;                 // La importancia qu se le quiere dar a la visibilidad
    int hormigas;               // La cantidad de hormigas que van a participar en la silumacion (Cantidad de iteraciones)
    float disipacion;           // La cantidad de feromonas disipadas con cada iteracion (El recorrido de cada hormiga)
    float ultimaDistancia;      // Ultimo recorrido de la hormiga (Para calcular las nuevas feromonas en todos los nodos)
    Nodo primerNodoVisitado;    // El inicio de la lista de nodos visitados para cada simulacion
    Nodo ultimoNodoVisitado;    // El ultimo nodo visitado para cada simulacion
    
    public Simulacion(){
        this.grafoSim = null;
        this.inicio = null;
        this.destino = null;
        this.alfa = 0F;
        this.beta = 0F;
        this.hormigas = 0;
        this.disipacion = 0F;
        this.primerNodoVisitado = null;
        this.ultimoNodoVisitado = null;
    }

    public Grafo getGrafoSim() {
        return grafoSim;
    }

    public void setGrafoSim(Grafo grafoSim) {
        this.grafoSim = grafoSim;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public Nodo getDestino() {
        return destino;
    }

    public void setDestino(Nodo destino) {
        this.destino = destino;
    }

    public float getAlfa() {
        return alfa;
    }

    public void setAlfa(float alfa) {
        this.alfa = alfa;
    }

    public float getBeta() {
        return beta;
    }

    public void setBeta(float beta) {
        this.beta = beta;
    }

    public int getHormigas() {
        return hormigas;
    }

    public void setHormigas(int hormigas) {
        this.hormigas = hormigas;
    }

    public float getDisipacion() {
        return disipacion;
    }

    public void setDisipacion(float disipacion) {
        this.disipacion = disipacion;
    }

    public float getUltimaDistancia() {
        return ultimaDistancia;
    }

    public void setUltimaDistancia(float ultimaDistancia) {
        this.ultimaDistancia = ultimaDistancia;
    }

    public Nodo getPrimerNodoVisitado() {
        return primerNodoVisitado;
    }

    public void setPrimerNodoVisitado(Nodo primerNodoVisitado) {
        this.primerNodoVisitado = primerNodoVisitado;
    }

    public Nodo getUltimoNodoVisitado() {
        return ultimoNodoVisitado;
    }

    public void setUltimoNodoVisitado(Nodo ultimoNodoVisitado) {
        this.ultimoNodoVisitado = ultimoNodoVisitado;
    }
    
    
    public void cargaFeromonas(){
        
    }
    
    
    
    
    
    
}
