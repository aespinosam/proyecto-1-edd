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
    Arista primeraArista;
    Arista ultimaArista;
    
   
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
    
    public void anadirNodo(String nuevo){
        Nodo nuevoNodo = new Nodo(nuevo);
        
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
    
    //Chequear que un nodo con el mombre introducido existe
    public boolean nodoExistente(String nombreNodo){
        Nodo nav = this.primerNodo;
        boolean encontrado = false;
        while(nav != null && encontrado == false){
            String nombreNav = nav.getNombre();
            if(nombreNav.toLowerCase().equals(nombreNodo.toLowerCase())){
                encontrado = true;
            }
            nav = nav.getSiguienteNodo();
        }
        return encontrado;
    }
    
    
    private void anadirAristaAlFinal(Arista nuevaArista){
        
        if(this.primeraArista == null){
            this.primeraArista = nuevaArista;
        }
        else if(this.primeraArista.getSiguienteArista() == null){
            this.primeraArista.setSiguienteArista(nuevaArista);
            this.ultimaArista = nuevaArista;
        }
        else{
            this.ultimaArista.setSiguienteArista(nuevaArista);
            this.ultimaArista = nuevaArista;
        }
    }
    
    public void anadirArista(String origen, String destino, float distancia){
        //Validar que los dos nodos existen en el grafo
        boolean origenExistente = this.nodoExistente(origen);
        boolean destinoExistente = this.nodoExistente(destino);
        
        if(origenExistente && destinoExistente){
            
            //Validar que no hay arista existentes entre esos nodos 
            boolean aristaEncontrada = false;
            Arista nav = this.primeraArista;
            
            while(aristaEncontrada == false && nav != null){
                if(nav.getOrigen().getNombre().toLowerCase().equals(origen.toLowerCase())){
                    if(nav.getDestino().getNombre().toLowerCase().equals(destino.toLowerCase())){
                        aristaEncontrada = true;
                    }
                
                }
                else if(nav.getOrigen().getNombre().toLowerCase().equals(destino.toLowerCase())){
                    if (nav.getDestino().getNombre().toLowerCase().equals(origen.toLowerCase())){
                        aristaEncontrada = true;
                    }
                }
                nav = nav.getSiguienteArista();
            }
            if(!aristaEncontrada){
                Nodo origenNuevoVert = new Nodo(origen);
                Nodo destinoNuevoVert = new Nodo(destino);
                Arista nuevaArista = new Arista(origenNuevoVert, destinoNuevoVert, distancia);
                this.anadirAristaAlFinal(nuevaArista);
                System.out.println("Anadida un nueva arista " + origen + "<--- " + distancia + " ---> " + destino);
            }
            else{
                System.out.println("No se puede agregar esa arista porque ya existe!");
            }
        }
        
        
    }
    
    
    public void getNodosAdyacentes(String nombreNodo){
        Arista nav = this.primeraArista;
        nombreNodo = nombreNodo.toLowerCase();
        
        //Tiene que recorrer toda la lista de arista
        while(nav != null){
            String nombreOrigen = nav.getOrigen().getNombre().toLowerCase();
            String nombreDestino = nav.getDestino().getNombre().toLowerCase();
            
            if(nombreOrigen.equals(nombreNodo)){
                //Crear un string y anadir la lista para mostrar en la interfaz grafica
                System.out.println(nombreDestino + " -> Distancia: " + nav.getDistancia());
            }
            else if(nombreDestino.equals(nombreNodo)){
                System.out.println(nombreOrigen + " -> Distancia: " + nav.getDistancia());
            }
            nav= nav.getSiguienteArista();
        }
        System.out.println("--- Fin de adyacencias ---");
        
       
//        if(encontrado == true){
//            Arista arista = origen.getNodosAdyacentes().getPrimero();
//            while(arista != null){
//                System.out.println(arista.getDestino().getNombre() + " | distancia: " + arista.getDistancia());
//                arista = arista.getSiguienteArista();
//            }
//        }
    }
    
    public void cargaGrafoDeArchivo(){
        
    }
}
