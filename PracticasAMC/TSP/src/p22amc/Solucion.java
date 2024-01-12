/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p22amc;

import java.util.ArrayList;

/**
 *
 * @author Migue
 */
public class Solucion {

    private double distancia; //Distancia entre los dos puntos de la solucion
    private long tiempo; //Tiempo requerido para hallar la opcion
    private ArrayList<Integer> Ruta = new ArrayList();
    private ArrayList<Punto> RutaV = new ArrayList();
    private String Nombre;

    /**
     * @return the distancia
     */
    public double getDistancia() {
        return distancia;
    }

    public void setRuta(ArrayList<Integer> Ruta) {
        this.Ruta = Ruta;
    }

    public void setRutaV(ArrayList<Punto> RutaV) {
        this.RutaV = RutaV;
    }

    public ArrayList<Punto> getRutaV() {
        return RutaV;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public ArrayList<Integer> getRuta() {
        return Ruta;
    }

    public String getNombre() {
        return Nombre;
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


