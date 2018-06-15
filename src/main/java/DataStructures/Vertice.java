/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 *
 * @author Allan, Marco, Maria José
 * @param <T>
 */
public class Vertice<T> {
    
    /**
     *
     * @param <T>
     */
    public class Nodo<T> {
        
        /**
         *
         */
        public int aristasSize;

        /**
         *
         */
        public T vertice;

        /**
         *
         */
        public String name;
        
        /**
         *
         * @param element
         * @param name
         */
        public Nodo(T element, String name){
            this.aristasSize = 0;
            this.vertice = element;
            this.name = name;
        }
        
        /**
         *
         * @return
         */
        public T getVertice(){
            return this.vertice;
        }
        
        /**
         *
         * @return
         */
        public String getName(){
            return this.name;
        }
        
        /**
         *
         */
        public void addAristaSize(){
            this.aristasSize ++;
        }
        
        /**
         *
         * @return
         */
        public int getAristasSize(){
            return this.aristasSize;
        }
    }
    
    /**
     *
     */
    public LinkedList<Arista> aristas;

    /**
     *
     */
    public Nodo<T> vertice;
    
    /**
     *
     */
    public Vertice(){
        this.aristas = new LinkedList<>();
        this.vertice = null;
    }
    
    /**
     *
     * @param element
     * @param name
     */
    public Vertice(T element, String name){
        this.aristas = new LinkedList<>();
        this.vertice = new Nodo(element, name);
    }
    
    /**
     *
     * @return
     */
    public T getVertice(){
        return this.vertice.getVertice();
    }
    
    /**
     *
     * @return
     */
    public String getDireccion(){//NUEVO
        return this.vertice.getName();
    }
    
    /**
     *
     * @param add
     */
    public void addArista(Arista add){
        this.aristas.append(add);
        this.vertice.addAristaSize();
    }
    
    /**
     *
     * @param element
     * @return
     */
    public Arista getArista(Arista element){
        Arista aristaReturn = null;
        this.aristas.goToStart();
        while(this.aristas.getElement() != null){
            if(element == this.aristas.getElement()){
                aristaReturn = this.aristas.getElement();
            }
            this.aristas.next();
        }
        return aristaReturn;
    }
    
    /**
     *
     * @param element
     * @return
     */
    public boolean findArista(Arista element){
        boolean find = false;
        int size = 0;
        while(this.aristas.getElement() != null){
            if(this.aristas.getElement().getElement() == element.getElement()){
                find = true;
            }
            this.aristas.next();
            size ++;
        }
        return find;
    }
    
    /**
     *
     * @return
     */
    public LinkedList<Arista> getAristas(){
        return this.aristas;
    }
}
