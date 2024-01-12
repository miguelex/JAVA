/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p22amc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


/**
 *
 * @author migue
 */
public class P22AMC {

    public static void leerFichero(String nombre, ArrayList<Punto> Lista) {
        //Metodo que lle los datos del fichero indicado en el parametro nombre    
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(nombre); //No hace falta indicar ruta ni extension.
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Leemos el fichero e insertamos los datos de cada ciudad en el arraylist
            String linea;
            while (!br.readLine().contains("NODE")); //Leermos el fichero pero no hacemos nada hasta encontrar l palabra NODE
            do { //A partir de aqui si que guardamos en la lista
                linea = br.readLine();
                if (!linea.contains("EOF")) { //Si leemos EOF es que hemos terminado el fichero
                    String[] partes = linea.split(" ");
                    Punto point = new Punto();
                    point.setCiudad(Integer.parseInt(partes[0]));
                    point.setX(Double.parseDouble(partes[1]));
                    point.setY(Double.parseDouble(partes[2]));
                    Lista.add(point); //Añado la nueva ciudad
                }
            } while (!linea.contains("EOF"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static Solucion TSPExhaustivo(ArrayList<Punto> Lista, int NumCiudades) {
        //Metodo que llama al meodo exhaustivo. Primeo creamos una nueva lista con el numero
        //de ciudades indicados por NumCiudades
        ArrayList<Punto> subLista = new ArrayList<Punto>();
        for (int i = 0; i < NumCiudades; i++) { //Creamos la sublistas de NumCIudades
            subLista.add(Lista.get(i));
        }
        FuerzaBruta FB = new FuerzaBruta(subLista, NumCiudades); //Creamos un objeto de tipo FuerzaBruta
        return FB.TSP();//Llamada al algortimo exhaustivo
    }

    public static Solucion TSPVoraz(ArrayList<Punto> Lista) //Metodo que realzia la exploracion voraz
    {
        Voraz V = new Voraz(Lista);
        return V.TSP();//Llamada al algoritmo voraz
    }

     
    /**
     * FUncion principal
     *
     * @param args
     */
    public static void main(String[] args) {
             
        FormPral Formulario = new FormPral();
        Formulario.setVisible(true);
        
    }
}
