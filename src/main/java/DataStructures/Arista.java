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
public class Arista<T>{

    /**
     *
     */
    public T element;

    /**
     *
     */
    public int length;

    /**
     *
     */
    public int time;

    /**
     *
     * @param element
     * @param length
     */
    public Arista(T element, int length){
        this.element = element;
        this.length = length;
        this.time= 0;
    }

    /**
     *
     * @param Time
     */
    public void setTime(int Time){
        this.time = time;
    }

    /**
     *
     * @param length
     */
    public void setLength(int length){
        this.length = length;
    }

    /**
     *
     * @return
     */
    public int getTime(){
        return this.time;
    }

    /**
     *
     * @return
     */
    public int getLength(){
        return this.length;
    }

    /**
     *
     * @return
     */
    public T getElement(){
        return this.element;
    }

}
