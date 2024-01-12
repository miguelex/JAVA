/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2amc;

/**
 *
 * @author JyM
 */
public class Par {

    //Clase que recoge los datos de una solucion ocncreta
    private Punto p1; //Primer punto del par mas cercano
    private Punto p2; //Segundo punto del par mas cercano
    private double distancia; //Distancia entre los dos puntos de la solucion
    private long tiempo; //Tiempo requerido para hallar la opcion

    /**
     * @return the p1
     */
    public Punto getP1() {
        return p1;
    }

    /**
     * @param p1 the p1 to set
     */
    public void setP1(Punto p1) {
        this.p1 = p1;
    }

    /**
     * @return the p2
     */
    public Punto getP2() {
        return p2;
    }

    /**
     * @param p2 the p2 to set
     */
    public void setP2(Punto p2) {
        this.p2 = p2;
    }

    /**
     * @return the distancia
     */
    public double getDistancia() {
        return distancia;
    }

    /**
     * @param distancia the distancia to set
     */
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    /**
     * @return the tiempo
     */
    public long getTiempo() {
        return tiempo;
    }

    /**
     * @param tiempo the tiempo to set
     */
    public void setTiempo(long tiempo) {
        this.tiempo = tiempo;
    }

}
