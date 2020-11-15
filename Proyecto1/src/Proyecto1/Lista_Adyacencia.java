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
    Arista primera;
    Arista ultima;
    
    public Lista_Adyacencia(){
        this.primera = null;
        this.ultima = null;
    }

    public Arista getPrimero() {
        return primera;
    }

    public void setPrimero(Arista primera) {
        this.primera = primera;
    }

    public Arista getUltimo() {
        return ultima;
    }

    public void setUltimo(Arista ultima) {
        this.ultima = ultima;
    }
    
    public int tamano(){
        Arista navegador = this.primera;
        int contador = 0;
        while(navegador != null){
            contador++;
            navegador = navegador.getSiguienteArista();
        }
        return contador;
    }
    
    public void anadirSiguiente(Nodo origen, Nodo destino, float distancia){
        Arista nuevaArista = new Arista(origen, destino, distancia);
        int tamano = this.tamano();
        if(tamano == 0){
            this.primera = nuevaArista;
        }
        else if(tamano == 1){
            this.primera.setSiguienteArista(nuevaArista);
            this.ultima = nuevaArista;
        }
        else{
            this.ultima.setSiguienteArista(nuevaArista);
            this.ultima = nuevaArista;
        }
    }
    
    public void imprimir(){
        Arista navegador = this.primera;
        
        while(navegador != null){
            System.out.println(navegador.getOrigen().getNombre() + "---" + navegador.getDistancia() + "--->" + navegador.getDestino().getNombre());
            navegador = navegador.getSiguienteArista();
        }
 
    }
    
}
