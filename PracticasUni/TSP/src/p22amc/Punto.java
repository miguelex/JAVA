/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p22amc;

/**
 *
 * @author migue
 */
public class Punto {
//Clase Punto. Es igual que la usada en la primera parte de la practica, salvo
//que se ha incorporado un nuevo atributo para guardar el id de la ciudad
    private double x;
    private double y;
    private int ciudad; // Identificador de la ciudad

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }

    public int getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the id de la ciudad to set
     */
    public void setCiudad(int ciudad) {
        this.ciudad = ciudad;
    }
}
