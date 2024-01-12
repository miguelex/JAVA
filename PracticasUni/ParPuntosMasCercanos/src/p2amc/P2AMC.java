/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2amc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;
import java.util.List;
import java.util.Random;


/**
 *
 * @author Migue
 */
public class P2AMC {

    public static void crearLista(List<Punto> Lista, int numPuntos) {
        //Metodo que crea una lista de tantos puntos como indique numPuntos

        Random r = new Random();
        r.setSeed(new Date().getTime());
        Lista.clear();

        for (int i = 0; i < numPuntos; i++) {
            Punto point = new Punto();
            point.setX(r.nextDouble());
            point.setY(r.nextDouble());
            point.setId(i + 1);
            Lista.add(point);
        }
    }

    public static void MejorPeor(List<Punto> Lista, int numPuntos, int opcion) {
        //Metodo que crea una lista de tantos puntos como indique numPuntos. Opcion
        //nos indica si la lista se va a usar para el caso mejor o peor

        Random r = new Random();
        r.setSeed(new Date().getTime());
        Lista.clear();
        double X;

        if (opcion == 1)//Caso mejor. Todos los puntos estan en el eje x (por tanto y=0)
        {
            for (int i = 0; i < numPuntos; i++) {
                Punto point = new Punto();
                point.setX(r.nextDouble());
                point.setY(0);
                point.setId(i + 1);
                Lista.add(point);
            }
        } else //Caso peor. Todos los puntos estan en el mismo eje vertical (todos los puntos tienen la misma x)
        {
            X = r.nextDouble();
            for (int i = 0; i < numPuntos; i++) {
                Punto point = new Punto();
                point.setX(X);
                point.setY(r.nextDouble());
                point.setId(i + 1);
                Lista.add(point);
            }
        }
    }

    public static void leerFichero(String nombre, List<Punto> Lista) {
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
                    point.setId(Integer.parseInt(partes[0]));
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

    /**
     * Lanzamos el formulario principal
     */
    public static void main(String[] args) throws InterruptedException {
        FormPral Formulario = new FormPral();
        Formulario.setVisible(true);
    }

}
