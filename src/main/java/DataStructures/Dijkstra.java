/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import java.util.Arrays;

/**
 *
 * @author Allan, Marco, Maria José
 */

public class Dijkstra {
    
    /**
     *
     */
    public LinkedList<Object[][]> dijkstra;

    /**
     *
     */
    public Vertice<Object>[] grafo;

    /**
     *
     */
    public Vertice<Object> origen;
    
    /**
     *
     */
    public Dijkstra(){
        this.dijkstra = new LinkedList();
    }
    
    /**
     *
     * @param origen
     * @param grafo
     * @return
     */
    public LinkedList<Object[][]> ShortestPath(Object origen, Grafo grafo){
        this.grafo = grafo.getGrafo();
        int x = 0;
        //Busca origen en grafo para extraer informacion de nodo
        while(this.grafo.length > x){
            if (this.grafo[x].getVertice() == origen){
                this.origen = this.grafo[x];
                break;
            }
            x++;
        }
        //Extrae informacion de nodo origen y crea la etiqueta del nodo
        for (int p = 0; this.grafo.length > p; p++){
            Object[][] nodo = new Object[2][2];
            Object[] etiqueta = new Object[2];
            nodo[0][0] = this.grafo[x].getVertice();
            if(this.grafo[x].getVertice() == this.origen){
                etiqueta[0] = null;
                etiqueta[1] = 0;
                nodo[1] = etiqueta;
                this.dijkstra.insert(nodo);
            }
            //Elimina el nodo origen para no volverlo a utilizar en revision
            remove(this.origen);
        }
        //Extrae la informacion de las aristas del nodo origen para crear etiquetas
        LinkedList<Arista> aristas = this.origen.getAristas();
        aristas.goToStart();
        while(aristas.getElement() != null){
            Object[][] nodo = new Object[2][2];
            Object[] etiqueta = new Object[2];
            nodo[0][0] = aristas.getElement();
            etiqueta[0] = this.origen.getVertice();
            etiqueta[1] = aristas.getElement().getLength();
            nodo[1] = etiqueta;
            this.dijkstra.insert(nodo);
        }
        //Empieza a recorrer el grafo para buscar el camino más corto a todos las aristas
        while(this.grafo.length != 0){
            this.dijkstra.goToStart();
            Object[][] compare = this.dijkstra.getElement();
            //Busca el nodo con el camino más bajo para realizar comparacion
            while(this.dijkstra.getElement() != null){
                Object[][] c = this.dijkstra.getElement();
                if((int) compare[1][1] > (int) c[1][1]){
                    compare = c;
                }
            }
            Vertice<Object> newCompare = new Vertice<>();
            int position = 0;
            //Busca en el grafo el nodo para poder extraer la informacion de las aristas
            while(this.grafo.length > position){
                if(this.grafo[position].getVertice().equals(compare[0][0])){
                    newCompare = this.grafo[position];
                }
            }
            this.dijkstra.goToStart();
            //Recorre las etiquetas existentes para realizar los cambios correspondientes
            while(this.dijkstra.getElement() != null){
                int size = 0;
                LinkedList<Arista> camino = newCompare.getAristas();
                camino.goToStart();
                if(this.dijkstra.getElement()[0][0] != origen && this.dijkstra.getElement()[0][0] != newCompare.getVertice()){
                    while(camino.getElement() != null){
                        if(camino.getElement().getElement() == this.dijkstra.getElement()[0][0]){
                            size = (int) compare[1][1] + camino.getElement().getLength();
                        }
                        camino.next();
                    }
                    if(this.dijkstra.next()){
                        Object[][] nodo = new Object[2][2];
                        Object[] etiqueta = new Object[2];
                        nodo[0][0] = camino.getElement();
                        etiqueta[0] = compare[0][0];
                        etiqueta[1] = size;
                        nodo[1] = etiqueta;
                        this.dijkstra.insert(nodo);
                    }else if((int) this.dijkstra.getElement()[1][1] > size){
                        Object[][] element = this.dijkstra.getElement();
                        element[1][1] = size;
                        element[1][0] = compare[0][0];
                        
                        this.dijkstra.setElement(element);
                    }
                }
            }
            remove(compare[0][0]);
        }
        
        return this.dijkstra;
    }
    
    /**
     *
     * @param element
     */
    public void remove(Object element){
        Vertice<Object>[] newArray;
        newArray = new Vertice[this.grafo.length-1];
        int p = 0;
        for (int x = 0; this.grafo.length > x; x++){
            if(this.grafo[x].getVertice() != element){
                newArray[p] = this.grafo[x];
                p++;
            }
        }
        this.grafo = new Vertice[newArray.length];
        for(int x = 0; newArray.length > x; x++){
            this.grafo[x] = newArray[x];
        }
    }

}
