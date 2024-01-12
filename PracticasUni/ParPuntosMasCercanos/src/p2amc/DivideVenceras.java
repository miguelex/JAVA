   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2amc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author migue
 */
public class DivideVenceras {

    // Clase que realiza la busqueda del par de puntos mas cercanos mediante algoritmo basado en divide y venceras  
    public double calDistancia(Punto p1, Punto p2) {
        //Metodo que calcula la distancia entre los dos puntos que se le pasa por parametro
        double diferenciaX = p2.getX() - p1.getX();
        double diferenciaY = p2.getY() - p1.getY();
        return Math.sqrt((diferenciaX * diferenciaX) + (diferenciaY * diferenciaY));
    }

    public void Ordenar(List<Punto> Lista, int inicio, int fin) {
        //Metodo que ordena la lista que recibe por parametro en funcion de la coordenada x. Se basa en Quicksort
        double pivote = Lista.get((inicio + fin) / 2).getX();
        int i = inicio;
        int j = fin;
        Punto aux = new Punto();
        while (i <= j) {
            while (Lista.get(i).getX() < pivote) {
                i++;
            }
            while (Lista.get(j).getX() > pivote) {
                j--;
            }
            if (i <= j) {
                aux=Lista.get(i);
                Lista.set(i, Lista.get(j));
                Lista.set(j, aux);
                i++;
                j--;
            }
        }

        if (inicio < j) {
            Ordenar(Lista, inicio, j);
        }
        if (i < fin) {
            Ordenar(Lista, i, fin);
        }
    }

    public Par DivVen(List<Punto> Lista) {
        
        //Metodo basado en estrategia Divide y Venceras que halla los dos puntos mas cercanos de una lista
        int NumPuntos = Lista.size();
        Par Solucion = new Par();
        long Inicio, Fin;
        Punto P1 = new Punto();
        Punto P2 = new Punto();
        
        Inicio = new Date().getTime();//Tomamos el tiempo inicial
        if (NumPuntos < 2) { //Si tenemos menos de dos puntos no podemos obtener un par de puntos, luego devilvemos la distnacia maxima
            Solucion.setP1(P1);
            Solucion.setP2(P2);
            Solucion.setDistancia(Double.MAX_VALUE);
        } else if (NumPuntos == 2) { //Si solo tenemso dos puntos, esa es la solucion
            P1 = Lista.get(0);
            P2 = Lista.get(1);
            Solucion.setP1(P1);
            Solucion.setP2(P2);
            Solucion.setDistancia(calDistancia(Lista.get(0), Lista.get(1)));
        } else { //Si tenemos mas de tres puntos entramos por aqui
            Par SolucionIzquierda = new Par();
            Par SolucionDerecha = new Par();
            List<Punto> ListaIzquierda = new ArrayList<Punto>();
            List<Punto> ListaDerecha = new ArrayList<Punto>();
            int medio = Math.round(NumPuntos / 2); // Hallamos el punto medio de la lista original
            //Vamos a crear dos sublistas para hallar soluciones al lado izquierdo del punto medio y solucion al lado derecho
            ListaIzquierda = Lista.subList(0, medio); 
            ListaDerecha = Lista.subList(medio + 1, Lista.size());
            SolucionIzquierda = DivVen(ListaIzquierda);//Buscamos solucion al lado izquierdo
            SolucionDerecha = DivVen(ListaDerecha); //Buscamos solucion al lado derecho
            //Ahora nos quedaremos con la solucion minima de la dos encontradas
            if (SolucionIzquierda.getDistancia() < SolucionDerecha.getDistancia()) {
                Solucion = SolucionIzquierda;
            } else {
                Solucion = SolucionDerecha;
            }
            //Ahora estudiaremos la franja central
            List<Punto> Centro = new ArrayList<Punto>();
            //Creamos una nueva lista que contendra aquellos puntos que cumpla que la diferencia en valor
            //absoluto de su componente x y la componente x del punto medio sea menor a la distancia minima
            for (int i = 0; i < NumPuntos; i++) {
                if (Math.abs(Lista.get(i).getX() - Lista.get(medio).getX()) < Solucion.getDistancia()) {
                    Centro.add(Lista.get(i));
                }
            }
            double distancia;
            //Ahora buscamos un posible par mas cercano haciendo uso del algoritmo exhaustivo
            for (int i = 0; i < Centro.size(); i++) {
                for (int j = i + 1; j < Centro.size() /*&& (Centro.get(j).getY() - Centro.get(i).getY() < Solucion.getDistancia())*/; j++) {

                    distancia = calDistancia(Centro.get(i), Centro.get(j));
                    if (distancia < Solucion.getDistancia()) {
                        Solucion.setDistancia(distancia);
                        Solucion.setP1(Centro.get(i));
                        Solucion.setP2(Centro.get(j));
                    }
                }

            }
           
        }
        Fin = new Date().getTime(); //tomamos el tiempo final
        Solucion.setTiempo(Fin - Inicio);
        return Solucion;
    }

    public Par Test(List<Punto> Lista) {
        
        //Metodo que realiza la busqueda de los pares
        Par Solucion = new Par();
        List<Punto> ListaOrdenadaX = new ArrayList<Punto>(); 

        ListaOrdenadaX = Lista;
        Ordenar(ListaOrdenadaX, 0, Lista.size() - 1);//Ordenamos la lista original
        Solucion = DivVen(ListaOrdenadaX);//Buscamos la solucion mediante Divide y Venceras
        return Solucion;
    }

}
