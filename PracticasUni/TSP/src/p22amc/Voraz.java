//Juan Jesus Vazquez Bernal

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
public class Voraz {

    private int Recorrido; //Aqui guardaremos la distancia que recorre el viajante
    private ArrayList<Punto> Ruta = new ArrayList(); //Aqui almacenamos la lista de ciudades que vamos visitando
    private ArrayList<Punto> Ciudades = new ArrayList();//El conjunto de ciudades que vamos a estudiar
    private Solucion Sol;
    
    public Voraz(ArrayList<Punto> Lista) {
        //Constructor de la clase
        Recorrido = 0;
        Ciudades = Lista;
        Sol=new Solucion();
    }

    private int Distancia(Punto p1, Punto p2) {
        //Metodo para calcular l distancia entre dos puntos (ciudades)
        double diferenciaX = p2.getX() - p1.getX();
        double diferenciaY = p2.getY() - p1.getY();
        //return Math.rint(Math.sqrt((diferenciaX * diferenciaX) + (diferenciaY * diferenciaY)));
        return (int)(Math.sqrt((diferenciaX * diferenciaX) + (diferenciaY * diferenciaY)));
    }

    private int vecinoMasCercano(Punto Ciudad, ArrayList<Punto> Lista) {
        //BUscamos al vecino mas cercano al punto Ciudad, que es la ultima posicion que viistamos    
        int mejor = Integer.MAX_VALUE;
        double distanciamejor = Double.MAX_VALUE;
        double distancia;
        
        for (int i = 0; i < Lista.size(); i++) {

            distancia = Distancia(Ciudad, Lista.get(i));

            if (distancia < distanciamejor) {
                mejor = i;
                distanciamejor = distancia;
            }
        }
        return mejor;
    }

    private void Voraz(int inicio, ArrayList<Punto> Lista) {

        Ruta.add(Lista.get(inicio));//Añadimos el priemr punto y
        Punto anterior = Lista.get(inicio); //Almacenamos el punto que ya hemos visitado para usarlo luego para el caluclo de la distancia
        Lista.remove(inicio);//lo sacmos de la lista
        //int iteraciones = Lista.size();
        
        //for (int i = 0; i < iteraciones; i++) 
        while (!Lista.isEmpty()) {
            int eleccion = vecinoMasCercano(anterior, Lista);//Buscamos el vecino mas cercano
            Ruta.add(Lista.get(eleccion));//y lo insertamos
            Punto actual = Lista.get(eleccion);//Guardamos ese punto para calcualr la distancia
            Lista.remove(eleccion);//lo eliminamo
            Recorrido += Distancia(anterior, actual);//Calculo distancia
            anterior = actual;//Actualziamos el ultimo punto visitado
        }
        Recorrido += Distancia(anterior, Ruta.get(0));//Calculamos la distancia desde el punto final al inical
        Sol.setDistancia(Recorrido);
        Sol.setRutaV(Ruta);
        
    }

    public Solucion TSP() {
        //Metodo que se llama para hacer el metodo exhaustivo

         long Inicio, Fin;
        Inicio = System.currentTimeMillis(); //Tomamos el tiempo inicial
        Voraz(0, Ciudades);
        Fin = System.currentTimeMillis();
        Sol.setTiempo(Fin-Inicio);
        return Sol;
        

    }

}
