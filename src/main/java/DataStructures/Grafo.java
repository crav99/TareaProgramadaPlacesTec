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
public class Grafo<T> {
    
    /**
     *
     */
    public Vertice<T>[] grafo;

    /**
     *
     */
    public int size;

    /**
     *
     */
    public int position;
    
    /**
     *
     */
    public Grafo(){
        this.size = 0;
        this.grafo = new Vertice[this.size];
    }
    
    /**
     *
     * @param vertice
     */
    public void insertVertice(Vertice<T> vertice){
        if (this.size != 0){
            this.size ++;
            Vertice<T>[] newVertice = new Vertice[this.size];
            int position = 0;
            while(this.grafo.length > position){
                newVertice[position] = this.grafo[position];
                position ++;
            }
            newVertice[position] = vertice;
            position = 0;
            this.grafo = new Vertice[this.size];
            while(newVertice.length > position){
                this.grafo[position] = newVertice[position];
                position ++;
            }
        }else{
            this.size ++;
            this.grafo = new Vertice[this.size];
            this.grafo[0] = vertice;
        }
        
    }
    
    /**
     *
     */
    public void removeVertice(){
        this.size --;
        Vertice<T> remove = this.grafo[this.position];
        Vertice<T>[] newVertice = new Vertice[this.size];
        int position = 0;
        int positionGrafo = 0;
        while (this.grafo.length-1 > positionGrafo){
            if(this.grafo[positionGrafo] != remove){
                newVertice[position] = this.grafo[positionGrafo];
                position ++;
            }
            positionGrafo ++;
        }
        position = 0;
        this.grafo = new Vertice[this.size];
        while(newVertice.length-1 > position){
            this.grafo[position] = newVertice[position];
        }
        
    }
    
    /**
     *
     * @param element
     * @return
     */
    public Vertice<T> getVertice(T element){
        int position = 0;
        Vertice<T> vertice = null;
        while (this.grafo.length > position){
            if (this.grafo[position].getVertice() == element){
                vertice = this.grafo[position];
            }
        }
        return vertice;
    }
    
    /**
     *
     * @param verticeInicio
     * @param verticeFinal
     * @return
     */
    public Object getArista(T verticeInicio, T verticeFinal){
        Vertice vertice = getVertice(verticeInicio);
        Object existe = null;
        vertice.getAristas().goToStart();
        while(vertice.getAristas().getElement() != null){
            if (vertice.getAristas().getElement() == verticeFinal){
                existe = vertice.getAristas().getElement();
            }
            vertice.getAristas().next();
        }
        return existe;
    }
    
    /**
     *
     */
    public void next(){
        if(this.position < this.size){
            this.position ++;
        }
    }
    
    /**
     *
     */
    public void start(){
        this.position = 0;
    }
    
    /**
     *
     * @return
     */
    public Object[] getVertices(){
        Object[] vertices = new Object[this.size];
        for ( int p = 0;this.grafo.length > p; p++){
            vertices[p] = this.grafo[p].getVertice();
        }
        return vertices;
    }
    
    /**
     *
     */
    public void checkAristas(){
        int p = 0;
        while(p < this.grafo.length){
            LinkedList<Arista> aristas = this.grafo[p].getAristas();
            aristas.goToStart();
            while(aristas.getElement() != null){
                System.out.println(this.grafo[p].getVertice()+" : "+aristas.getElement().getElement());
                aristas.next();
            }
            p++;
        }
    }
    
    /**
     *
     * @param origen
     * @param destino
     * @return
     */
    public boolean aristaExiste(T origen, T destino){
        int p = 0;
        while(p < this.grafo.length){
            if (this.grafo[p].getVertice() == origen){
                LinkedList<Arista> aristas = this.grafo[p].getAristas();
                aristas.goToStart();
                while(aristas.getElement() != null){
                    System.out.println("O: "+origen);
                    System.out.println("A: "+aristas.getElement().getElement());
                    System.out.println("D: "+destino);
                    if (((String) aristas.getElement().getElement()).equals((String) destino)){
                        return true;
                    }
                    aristas.next();
                }
            }
            p++;
        }
        return false;
    }
    
    /**
     *
     * @return
     */
    public int getSize(){
        return this.size;
    }
    
    /**
     *
     */
    public void goToStart(){
        this.position = 0;
    }
    
    /**
     *
     * @param pos
     */
    public void goToPos(int pos){
        this.position = pos;
    }
    
    /**
     *
     * @return
     */
    public Vertice getCurrentVertice(){
        return this.grafo[this.position];
    }
    
    /**
     *
     * @return
     */
    public int getPosition(){
        return this.position;
    }
    
    /**
     *
     * @return
     */
    public Vertice<T>[] getGrafo(){
        return this.grafo;
    }
    
    /**
     *
     * @return
     */
    public int[][] matrizAby(){
        int[][] matrizAby = new int[this.grafo.length][this.grafo.length];
        for (int i = 0; i < this.grafo.length; i++){
            for(int j = 0; j < this.grafo.length; j++){
                this.grafo[i].getAristas().goToStart();
                System.out.println("Compare: "+this.grafo[i].getAristas().getElement());
                while(this.grafo[i].getAristas().getElement() != null){
                    System.out.println("C1: "+this.grafo[i].getAristas().getElement().getElement());
                    System.out.println("C2: "+this.grafo[j].getVertice());
                    if(((String) this.grafo[i].getAristas().getElement().getElement()).equals((String) this.grafo[j].getVertice())){
                        matrizAby[i][j] = 1;
                    }else{
                        matrizAby[i][j] = 0;
                    }
                    this.grafo[i].getAristas().next();
                }
            }
        }
        return matrizAby;
    }
    
    /**
     *
     * @return
     */
    public int[][] matrizVal(){
        int matrizVal[][] = new int[this.grafo.length][this.grafo.length];
        for (int i = 0; i < this.grafo.length; i++){
            for(int j = 0; j < this.grafo.length; j++){
                this.grafo[i].getAristas().goToStart();
                while(this.grafo[i].getAristas().getElement() != null){
                    System.out.println("C1: "+this.grafo[i].getAristas().getElement());
                    System.out.println("C2: "+this.grafo[j].getVertice());
                    if(((String) this.grafo[i].getAristas().getElement().getElement()).equals((String) this.grafo[j].getVertice())){
                        Arista arista = this.grafo[i].getAristas().getElement();
                        Integer aristaNum = arista.getLength();
                        matrizVal[i][j]=aristaNum;
                    }else{
                        matrizVal[i][j]=0;
                    }
                    this.grafo[i].getAristas().next();
                }
            }
        }
        return matrizVal;
    }
}
