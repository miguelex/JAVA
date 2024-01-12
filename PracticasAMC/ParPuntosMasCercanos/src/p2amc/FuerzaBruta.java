/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2amc;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Migue
 */
public class FuerzaBruta {

    //Clase que realiza el metodo exhaustivo
    public double calDistancia(Punto p1, Punto p2) {
        // Metodo que calcula la distancia entre los dos puntos que se le pada por parametros 
        double diferenciaX = p2.getX() - p1.getX();
        double diferenciaY = p2.getY() - p1.getY();
        return Math.sqrt((diferenciaX * diferenciaX) + (diferenciaY * diferenciaY));
    }

    public Par Test(List<Punto> Lista) {
        // Metodo que busca los dos puntos mas cercanos dentro de la lista que se le pasa
        Par Solucion = new Par();
        
        Solucion.setDistancia(Double.MAX_VALUE); //Como buscamos la distncia minima, inicializamos la variale con el valor maximo
        double distancia;
        long Inicio, Fin;
        int numElementos = Lista.size();
        Inicio = new Date().getTime(); //Tomamos la fecha de inicio
        for (int i = 0; i < numElementos - 1; i++) {
            for (int j = i + 1; j < numElementos; j++) {
                distancia = calDistancia(Lista.get(i), Lista.get(j));
                if (distancia < Solucion.getDistancia()) //Como la nueva distancia en menor, actualziamos los datos
                {
                    Solucion.setDistancia(distancia);
                    Solucion.setP1(Lista.get(i));
                    Solucion.setP2(Lista.get(j));
                }
                
            }
        }
        
        Fin = new Date().getTime(); // Tomamos el tiempo de finalizacion 
        Solucion.setTiempo(Fin - Inicio);
        
        return Solucion;
    }
}