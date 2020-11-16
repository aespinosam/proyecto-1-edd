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
public class Grafo {
    Nodo primerNodo;
    Nodo ultimoNodo;
    Arista primeraArista;
    Arista ultimaArista;
    Nodo primerVisitado;
    Nodo ultimoVisitado;
    double trayectoria;
    
   
    public Grafo(){
        this.primerNodo = null;
        this.ultimoNodo = null;
        this.primeraArista = null;
        this.ultimaArista = null;
        this.primerVisitado = null;
        this.ultimoVisitado = null;
        this.trayectoria = 0;
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
    
    
    
    public double getTrayectoria() {
        return trayectoria;
    }

    public void setTrayectoria(double trayectoria) {
        this.trayectoria = trayectoria;
    }

    public Nodo getPrimerNodo() {
        return primerNodo;
    }

    public void setPrimerNodo(Nodo primerNodo) {
        this.primerNodo = primerNodo;
    }

    public Nodo getUltimoNodo() {
        return ultimoNodo;
    }

    public void setUltimoNodo(Nodo ultimoNodo) {
        this.ultimoNodo = ultimoNodo;
    }

    public Arista getPrimeraArista() {
        return primeraArista;
    }

    public void setPrimeraArista(Arista primeraArista) {
        this.primeraArista = primeraArista;
    }

    public Arista getUltimaArista() {
        return ultimaArista;
    }

    public void setUltimaArista(Arista ultimaArista) {
        this.ultimaArista = ultimaArista;
    }

    public Nodo getPrimerVisitado() {
        return primerVisitado;
    }

    public void setPrimerVisitado(Nodo primerVisitado) {
        this.primerVisitado = primerVisitado;
    }

    public Nodo getUltimoVisitado() {
        return ultimoVisitado;
    }

    public void setUltimoVisitado(Nodo ultimoVisitado) {
        this.ultimoVisitado = ultimoVisitado;
    }
    
    public void anadirAVisitados(String nombreDelNodo, double dist){
        
        Nodo navegador = this.primerNodo;
        boolean encontrado = false;
        while(navegador != null && !encontrado){
            if(navegador.getNombre().equals(nombreDelNodo)){
                encontrado = true;
            }
            else{
                navegador = navegador.getSiguienteNodo();
            }   
        }
        if(encontrado){
            //Anandir el nodo a la lista de nodos visitados
            Nodo nuevoVisitado = new Nodo(nombreDelNodo);
            
            if(this.primerVisitado == null){
                this.primerVisitado = nuevoVisitado;
                this.ultimoVisitado = nuevoVisitado;
                this.trayectoria += dist;
            }
            else if(primerVisitado.getSiguienteNodo() == null){
                this.primerVisitado.setSiguienteNodo(nuevoVisitado);
                this.ultimoVisitado = nuevoVisitado;
                this.trayectoria += dist;
            }
            else{
                this.ultimoVisitado.setSiguienteNodo(nuevoVisitado);
                this.ultimoVisitado = nuevoVisitado;
                this.trayectoria += dist;
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Nodo es parte del grafo, introduzca un nombre valido");
        }
    }
    
    public void visitarNodo(String nombreDelNodo){
        
        
        Arista nav = this.primeraArista;
        nombreDelNodo = nombreDelNodo.toLowerCase();
        Nodo navVisitados;
        System.out.println("Iniciando el proceso para " + nombreDelNodo + "...");
        if(this.primerVisitado == null){
            this.anadirAVisitados(nombreDelNodo, 0);
            System.out.println(nombreDelNodo + "-> Costo de la trayectoria: 0");
        }
        else{
            boolean encontrado = false;
            while(nav != null || !encontrado){
                String nombreOrigen = nav.getOrigen().getNombre().toLowerCase();
                String nombreDestino = nav.getDestino().getNombre().toLowerCase();

                //Obtenemos los nodos adyacentes
                if(nombreOrigen.equals(nombreDelNodo)){
                    System.out.println("Encontrado en el nodo" + nombreOrigen + " --> " + nombreDestino);
                    navVisitados = this.primerVisitado;
                    while(navVisitados != null && !encontrado){

                        if(navVisitados.getNombre().toLowerCase() == nombreDestino){
                            //Encontro el nodo dentro de los visitados, entonces no se muestra
                            encontrado = true;  
                        }
                        navVisitados = navVisitados.getSiguienteNodo();

                    }
                    if(!encontrado && this.ultimoVisitado.getNombre().toLowerCase() == nombreDestino){
                        this.anadirAVisitados(nombreDelNodo,nav.getDistancia());
                        System.out.println(nombreDelNodo + "-> Costo de la trayectoria: " + this.trayectoria);
                    }
                }
                else if(nombreDestino.equals(nombreDelNodo)){
                    System.out.println("Encontrado en el nodo" + nombreOrigen + " --> " + nombreDestino);
                    navVisitados = this.primerVisitado;
                    while(navVisitados != null && !encontrado){

                        if(navVisitados.getNombre().toLowerCase() == nombreOrigen){
                            //Encontro el nodo dentro de los visitados, entonces no se muestra
                            encontrado = true;
                            this.anadirAVisitados(nombreDelNodo, nav.getDistancia());
                            System.out.println(nombreDelNodo + "-> Costo de la trayectoria: " + this.trayectoria);
                        }
                        navVisitados = navVisitados.getSiguienteNodo();

                    }
                    if(!encontrado && this.ultimoVisitado.getNombre().toLowerCase() == nombreOrigen){
                        this.anadirAVisitados(nombreDestino,nav.getDistancia());
                        System.out.println(nombreDelNodo + "-> Costo de la trayectoria: " + this.trayectoria);
                    }
                }
                nav = nav.getSiguienteArista();
            }
            if(encontrado = false){
                System.out.println("Este nodo " + nombreDelNodo + " no es adyancente al ultimo nodo vistado!");
            }
        }
        
    }
    
    public String nombreUltimoNodoVisitado(){
        if(this.primerVisitado == null){
            return "Ninguno visitado";
        }
        else if(this.primerVisitado.getSiguienteNodo() == null){
            return this.primerVisitado.getNombre();
        }
        else{
            return this.ultimoVisitado.getNombre();
        }
    }
    
    public void imprimirVisitados(){
        Nodo nav = this.primerVisitado;
        System.out.println("--- Inicio de la impresion de visitados ---");
        while(nav != null){
            System.out.println(nav.getNombre() + " Visitado!");
            nav = nav.getSiguienteNodo();
        }
        System.out.println("--Fin de la impresion de visitados --- ");
    }
    
    public Nodo getNodo(String nombreDelNodo){
        Nodo nav  = this.primerNodo;
        while(nav != null){
            if(nav.getNombre().toLowerCase().equals(nombreDelNodo.toLowerCase())){
                return nav;
            }
            nav = nav.getSiguienteNodo();
        }
        return null;
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
    
    public void anadirArista(String origen, String destino, double distancia){
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
    
    public void getAdyacentesNoVisitados(String nombreNodo){
        Arista nav = this.primeraArista;
        nombreNodo = nombreNodo.toLowerCase();
        Nodo navVisitados;
        System.out.println("\n--- Adyacentes no visitados de " + nombreNodo + " ---");
        while(nav != null){
            String nombreOrigen = nav.getOrigen().getNombre().toLowerCase();
            String nombreDestino = nav.getDestino().getNombre().toLowerCase();
            
            //Obtenemos los nodos adyacentes
            if(nombreOrigen.equals(nombreNodo)){
                navVisitados = this.primerVisitado;
                boolean encontrado = false;
                while(navVisitados != null && !encontrado){
                    
                    if(navVisitados.getNombre().toLowerCase() == nombreDestino){
                        //Encontro el nodo dentro de los visitados, entonces no se muestra
                        encontrado = true;
                    }
                    navVisitados = navVisitados.getSiguienteNodo();
                    
                }
                if(!encontrado){
                    System.out.println(nombreDestino + "-> Distancia: " + nav.getDistancia());
                }
            }
            else if(nombreDestino.equals(nombreNodo)){
                navVisitados = this.primerVisitado;
                boolean encontrado = false;
                while(navVisitados != null && !encontrado){
                    
                    if(navVisitados.getNombre().toLowerCase() == nombreOrigen){
                        //Encontro el nodo dentro de los visitados, entonces no se muestra
                        encontrado = true;
                    }
                    navVisitados = navVisitados.getSiguienteNodo();
                    
                }
                if(!encontrado){
                    System.out.println(nombreOrigen + "-> Distancia: " + nav.getDistancia());
                }
            }
            nav = nav.getSiguienteArista();
        }
        System.out.println("--- fin adyacentes no visitados ---\n");
    }
    
    public void cargaGrafoDeArchivo(){
        
    }
}
