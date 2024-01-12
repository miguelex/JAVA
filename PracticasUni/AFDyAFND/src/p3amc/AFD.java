/**
 * Práctica 3 de la asignatura de Algorítmica y Modelos de Computación 
 * Automatas Finitos y No Finitos Deterministas
 * Curso 2015/16
 * 
 * @author migue
 */
package p3amc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase AFD que es la encargada tanto de cargar las transiciones que definen a
 * un Autómata Finito Determinista (bien por teclado o bien mediante la lectura
 * de un archivo) y posteriormente evalua la cadena que se le pase para
 * determinar si es valida o no
 */
public class AFD implements Cloneable, Proceso {

    private int[] estadosFinales; // Indica cuales son los estados Finales
    private List<TransicionAFD> transiciones; // Indica la lista de transiciones 
    // del AFD

    /**
     * Constructor de la clase. Define una lista de transiciones, que es lo que
     * define a un autómata
     *
     */
    public AFD() {
        transiciones = new ArrayList<TransicionAFD>();
    }

    /**
     * Metodo que nos va a permitir duplicar un objeto de tipo AFD.
     * Debemos tener en cuenta que una AFD contiene un array de objetos
     * tipo TransicionAFD, por lo que debemos usar la duplicacion de objetos
     * compuestos
     *
     * @return obj: Objeto de tipo AFD
     */
    public Object clone() {
        AFD obj = null;
        try {
            obj = (AFD) super.clone(); // Aqui duplicamos al automata
        } catch (CloneNotSupportedException ex) {
            System.out.println(" no se puede duplicar");
        }
        obj.estadosFinales = (int[]) this.estadosFinales.clone(); //duplicamos los estados finales
        obj.transiciones = new ArrayList<TransicionAFD>(); //duplicamos el ArrayList de TransicionAFD
        for (int i = 0; i < transiciones.size(); i++) {
            obj.transiciones.add((TransicionAFD) this.transiciones.get(i).clone()); //realizamos la copia profunda
        }
        return obj;
    }

    /**
     * Metodo que permite almacenar en una variable de tipo String los
     * valores de las transciones y de los estados finales del automata
     *
     * @return cadena: Cadena con los distintos valores del automata
     */
    public String toString() {
        String cadena;
        cadena = "Lista de Transiciones:\n";
        for (int i = 0; i < transiciones.size(); i++) {
            cadena += "Origen: " + transiciones.get(i).getEI() + " Valor que genera la transicion: " 
                   + transiciones.get(i).getSimbolo() + " Destino: " + transiciones.get(i).getEF() + "\n";
        }
        cadena += "\nLista de Estados finales:\n";
        for (int i = 0; i < estadosFinales.length; i++) {
            cadena += estadosFinales[i] + "  ";
        }
        
        return cadena;
    }

    /**
     * Añade una nueva transición a la lista del autómata
     *
     * @param e1: Estado inicial de la transición.
     * @param e2: Estado final de la transición.
     * @param simbolo: simbolo que genera la transición
     */
    public void agregarTransicion(int e1, int e2, char simbolo) {
        transiciones.add(new TransicionAFD(e1, e2, simbolo));
    }

    /**
     * Dado un estado y un símbolo devuelve el estado destino de la transición o
     * -1 en caso que no exista dicha transición.
     *
     * @param estado: Estado del que partimos.
     * @param simbolo: Simbolo que genera la transición.
     * @return el numero del estado destino al que se llega con los parametros
     * pasados, -1 si no se puede llegar a ninguno
     */
    public int transicion(int estado, char simbolo) {

        for (int i = 0; i < transiciones.size(); i++) {
            if ((transiciones.get(i).getEI() == estado)
                    && (transiciones.get(i).getSimbolo() == simbolo)) {
                return transiciones.get(i).getEF();
            }
        }
        return estado;
    }

    /**
     * Metodo que devuelve true si estado es un estado final
     *
     * @param estado: Estado que queremos comprobar si es final o no
     * @return true si estado es final, false en caso contrario
     */
    public boolean esFinal(int estado) {

        for (int i = 0; i < estadosFinales.length; i++) {
            if (estadosFinales[i] == estado) {
                return true;
            }
        }

        return false;
    }

    /**
     * Metodo que devuelve una lista con las transiciones que conforman el AFD
     *
     * @return lista de transiciones
     */
    public List<TransicionAFD> Transiciones() {
        return transiciones;
    }

    /**
     * Metodo que inicializa la tabla de estados finales
     *
     * @param finales array de enteros que contiene los estados finales
     */
    public void setEstadosFinales(int[] finales) {
        estadosFinales = finales;
    }

    /**
     * Metodo que comprueba si la cadena pasada es valida para el AFD definido
     *
     * @param cadena: cadena a evaluar
     * @return true si es una cadena valida, false en caso contrario
     */
    public boolean reconocer(String cadena) {
        char[] simbolo = cadena.toCharArray();
        int estado = 0; //El estado inicial es el 0

        for (int i = 0; i < simbolo.length; i++) {
            estado = transicion(estado, simbolo[i]);
        }
        return esFinal(estado);
    }

    /**
     * Metodo que crea un AFD leyendo las transiciones y los estados finales a
     * partir del archivo indicado por el parametro fichero
     *
     * @param fichero: contiene el nombre del fichero a evaluar
     * @return un objeto de tipo AFD
     * @throws IOException
     */
    public static AFD leer(String fichero) throws IOException {

        AFD crear = new AFD();
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);

            String linea;

            // Descartamos lineas hasta encontrar el comienzo de las transiciones 
            do {
                linea = br.readLine();
            } while (!linea.equals("Transiciones"));

            linea = br.readLine();

            // Leemos lineas hasta encontrar estados finales 
            do {
                TransicionAFD transicion = new TransicionAFD();
                int turno = 0;
                String[] lineas = linea.split(" ");

                for (int i = 0; i < lineas.length; i++) {
                    if (lineas[i].equals("")) {
                        continue;
                    }

                    // El primer elemento será el estado inicial
                    if (turno == 0) {
                        transicion.setEI(Integer.parseInt(lineas[i]));
                        turno++;
                        continue;
                    }

                    // El segundo elemento será el simbolo final
                    if (turno == 1) {
                        transicion.setEF(Integer.parseInt(lineas[i]));
                        turno++;
                        continue;
                    }

                    // El tercer elemento de la linea será el simbolo
                    if (turno == 2) {
                        transicion.setSimbolo(lineas[i].charAt(0));
                        turno = 0; // Empezamos otra vez desde 0
                        continue;
                    }
                }

                crear.Transiciones().add(transicion);
                linea = br.readLine();
            } while (!linea.equals("Estados finales"));

            // Empezamos a leer los estados finales
            linea = br.readLine();
            ArrayList<Integer> finales = new ArrayList<>();
            do {
                finales.add(Integer.parseInt(linea));
                linea = br.readLine();
            } while (!linea.equals("FIN"));

            int[] Efinales = new int[finales.size()];

            for (int i = 0; i < finales.size(); i++) {
                Efinales[i] = finales.get(i);
            }
            crear.setEstadosFinales(Efinales);
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AFD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return crear;
    }
        
}
