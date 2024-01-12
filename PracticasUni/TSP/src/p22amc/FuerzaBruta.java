 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p22amc;

import java.util.ArrayList;


/**
 *
 * @author migue
 */
public class FuerzaBruta {

    private int Recorrido; //Aqui guardaremos la distancia que recorre el viajante
    private ArrayList<Integer> Ruta = new ArrayList(); //Aqui almacenamos la lista de ciudades que vamos visitando
    private ArrayList<Punto> Ciudades = new ArrayList();//El conjunto de ciudades que vamos a estudiar
    private int numCiudades; //Numero de ciudades que componen la lista
    private Solucion Sol;
    
    public FuerzaBruta(ArrayList<Punto> Lista, int ciudades) {
        //Constructor de la clase
        Recorrido = Integer.MAX_VALUE; //Inicializamos con el mayor valor posible para los double
        Ciudades = Lista;
        numCiudades = ciudades;
        Sol=new Solucion();
    }

    public int Distancia(Punto p1, Punto p2) {
        //Metodo para calcular l distancia entre dos puntos (ciudades)
        double diferenciaX = p2.getX() - p1.getX();
        double diferenciaY = p2.getY() - p1.getY();
        return (int)(Math.sqrt((diferenciaX * diferenciaX) + (diferenciaY * diferenciaY)));
    }

    private Solucion Mejor(ArrayList<Integer> ruta) {
        //Este metodo evalua si la ruta que se le pasa por parametro es mejor que la que ya teniamos    
        int totalRecorrido = 0;

        //Primero calculamos el valor del recorrido pasado por parametro
        for (int i = 0; i < ruta.size() - 1; i++) {
            totalRecorrido += Distancia(Ciudades.get(ruta.get(i) - 1), Ciudades.get(ruta.get(i + 1) - 1));
        }
        //Añadimos el valor desde la ultima ciudad al inicial
        totalRecorrido += Distancia(Ciudades.get(ruta.get(numCiudades - 1) - 1), Ciudades.get(ruta.get(0) - 1));
        //Ahora comparamos esi el valor obtenido mejora lo que ya teniamos             
        if (totalRecorrido < Recorrido) {
            Recorrido = totalRecorrido;
            Ruta = ruta;
            Sol.setDistancia(Recorrido);
            Sol.setRuta(Ruta);
        }
        return Sol;
    }

    private void Exhaustivo(int cantidad, ArrayList<Integer> ruta, boolean[] Visitadas) {
        //Metodo que realiza el metodo exhaustivo como tal

        int NumRepe = cantidad; //NUmero de veces que tenemos que repetir el estudio 

        if (NumRepe > 0) {
            for (int i = 0; i < numCiudades; i++) {

                if (Visitadas[i] == true) {
                    continue;
                }

                Visitadas[i] = true;
                ArrayList<Integer> aux = new ArrayList<Integer>(ruta);
                aux.add(Ciudades.get(i).getCiudad());
                Exhaustivo(NumRepe - 1, aux, Visitadas);
                Visitadas[i] = false;
            }
        } else {
            Mejor(ruta); //Hemos visitado todas las ciudades, asi que evaluamos si la rupta es optima o no
        }
    }

    public Solucion TSP() {
        //Metodo que se llama para hacer el metodo exhaustivo

        boolean[] Visitadas = new boolean[numCiudades]; //Matriz para saber si ya hemos pasado o no por una ciudad
        
        //Inicialiazmos a falso (aun no hemos visitado ninguna ciudad)
        for (int i = 0; i < numCiudades; i++) {
            Visitadas[i] = false;
        }

        long Inicio, Fin;
        Inicio = System.currentTimeMillis(); //Tomamos el tiempo inicial
        Exhaustivo(numCiudades, new ArrayList<Integer>(), Visitadas);       
        Fin = System.currentTimeMillis();
        Sol.setTiempo(Fin-Inicio);
        return Sol;
        
    }

}
