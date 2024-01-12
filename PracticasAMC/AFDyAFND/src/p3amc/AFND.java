/**
 * Práctica 3 de la asignatura de Algorítmica y Modelos de Computación 
 * Automatas Finitos y No Finitos Deterministas
 * Curso 2015/16
 * 
 * @author migue
 */
package p3amc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase AFND que es la encargada tanto de cargar las transiciones que definen a
 * un Autómata Finito No Determinista (bien por teclado o bien mediante la
 * lectura de un archivo) y posteriormente evalua la cadena que se le pase para
 * determinar si es valida o no
 */
public class AFND implements Cloneable, Proceso {

    private int[] estadosFinales; //indica cuales son los estados Finales
    private List<TransicionAFND> transiciones; //indica la lista de transiciones del AFND
    private List<TransicionLambda> transicionesLambda; //indica la lista de transiciones lambda del AFND

    /**
     * Constructor de la clase
     */
    public AFND() {
        transiciones = new ArrayList<TransicionAFND>();
        transicionesLambda = new ArrayList<TransicionLambda>();
    }

    /**
     * Metodo que nos va a permitir duplicar un objeto de tiopo AFND.
     * Debemos tener en cuenta que una AFND contiene un array de
     * objetos tipo TransicionAFND y otro de tipo TransicionLambda por lo que
     * debemos usar la duplicacion de objetos compuestos
     *
     * @return obj: Objeto de tipo AFND
     */
    public Object clone() {
        AFND obj = null;
        try {
            obj = (AFND) super.clone();
        } catch (CloneNotSupportedException ex) {
            System.out.println("No se puede duplicar");
        }

        obj.estadosFinales = (int[]) this.estadosFinales.clone(); //duplicamos los estados finales
        obj.transiciones = new ArrayList<TransicionAFND>(); //duplicamos el ArrayList de TransicionAFND
        for (int i = 0; i < transiciones.size(); i++) {
            obj.transiciones.add((TransicionAFND) this.transiciones.get(i).clone());//realizamos la copia profunda
        }

        obj.transicionesLambda = new ArrayList<TransicionLambda>(); //duplicamos el ArrayList de TransicionLambda
        for (int i = 0; i < transicionesLambda.size(); i++) {
            obj.transicionesLambda.add((TransicionLambda) this.transicionesLambda.get(i).clone()); //realizamos la copia profunda
        }

        return obj;
    }

    /**
     * Metodo que nos va a permitir insertar una nueva transcion en el automata
     *
     * @param e1 estado inicial
     * @param simbolo simbolo que desencadena la transicion
     * @param e2 array de estados finales a los que llegamos
     */
    public void agregarTransicion(int e1, char simbolo, int[] e2) {
        getTransiciones().add(new TransicionAFND(e1, simbolo, e2));
    }

    /**
     * Metodo para insertar en el automata una nueva transicion lmabda
     *
     * @param e1 estado inicila
     * @param e2 conjunto de estados finales a los que llegamos
     */
    public void agregarTransicionLambda(int e1, int[] e2) {
        getTransicionesLambda().add(new TransicionLambda(e1, e2));
    }

    /**
     * Metodo que añade a una lista todos los estados dinales que son alcanzables 
     * desde un estado con un simbolo especificado por parametro
     * @param estado Estado inicial.
     * @param simbolo Símbolo.
     * @return Lista de estados finales a los que llegamos
     */
    private ArrayList<Integer> transicion(int estado, char simbolo) {
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = 0; i < getTransiciones().size(); i++) {
            TransicionAFND temp = getTransiciones().get(i);
            if (estado == temp.getEstadoInicial() && simbolo == temp.getCaracter()) {
                int[] tempfinales = temp.getEstadosFinales();
                for (int j = 0; j < tempfinales.length; j++) {
                    ret.add(tempfinales[j]);
                }
            }
        }
        return ret;
    }

    /**
     * Metodo que permite almacenar en una variable de tipo String los valores
     * de las transciones y de los estados finales del automata
     *
     * @return Cadena de texto con la informacion del automata
     */
    public String toString() {
        String cadena;
        cadena = "Lista de Transiciones:\n";
        for (int i = 0; i < transiciones.size(); i++) {
            int[] aux = transiciones.get(i).getEstadosFinales(); //Ahora podemos tener mas de un estado final
            for (int j = 0; j < aux.length; j++) {
                cadena += "Origen " + transiciones.get(i).getEstadoInicial()
                        + " Valor que genera la transicion: " + transiciones.get(i).getCaracter()
                        + " Destino: " + aux[j] + "\n";
            }
        }
        cadena += "\nLista de Transiciones Lambda:\n";
        for (int i = 0; i < transicionesLambda.size(); i++) {
            int[] aux = transicionesLambda.get(i).getEstadosFinales(); //Ahora podemos tener mas de un estado final
            for (int j = 0; j < aux.length; j++) {
                cadena += "Origen " + transicionesLambda.get(i).getEstadoInicial()
                        + " Destino " + aux[j] + "\n";
            }
        }
        cadena += "\nLista de Estados finales:\n";
        for (int i = 0; i < estadosFinales.length; i++) {
            cadena += estadosFinales[i] + "  ";
        }

        return cadena;
    }

    /**
     * Metodo que nos devuelve una lista con los estados finales que se pueden
     * alcanzar desde un macroestado inicial con un determinado simbolo
     *
     * @param macroestado Conjunto de estados iniciales.
     * @param simbolo Símbolo.
     * @return Conjunto de estados finales alcanzables.
     */
    public int[] transicion(int[] macroestado, char simbolo) {
        ArrayList<Integer> ret = new ArrayList<>();

        for (int i = 0; i < macroestado.length; i++) {
            ret.addAll(transicion(macroestado[i], simbolo));
        }

        return lambda_clausura(ListToInt(ret));
    }

    /**
     * Metodo que nos va a devolver una lista de estados que se pueden alcanzar 
     * desde el estado pasado por parametro mediante transiciones lambda.
     * @param estado indica el estado en el que estamos
     * @return array de estados alcanzables mediante transiciones lambda
     */
    public int[] transicionLambda(int estado) {
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = 0; i < getTransicionesLambda().size(); i++) {
            TransicionLambda temp = getTransicionesLambda().get(i);
            if (estado == temp.getEstadoInicial()) {
                int[] tempfinales = temp.getEstadosFinales();
                for (int j = 0; j < tempfinales.length; j++) {
                    ret.add(tempfinales[j]);
                }
            }
        }
        return ListToInt(ret);
    }

    /**
     * Este método comprueba si un estado se encuentra en la lista de estados
     * finales. Devuelve verdadero si lo está y falso si no.
     * @param estado Estado a comprobar.
     * @return Verdad si se alcanza un estado final, falso en caso contrario.
     */
    public boolean esFinal(int estado) {
        for (int i = 0; i < getEstadosFinales().length; i++) {
            if (estado == getEstadosFinales()[i]) {
                return true;
            }
        }

        return false;
    }

    /**
     * Metodo que comprueba  si al menos uno de los estados contenido en el macroestado 
     * alcanza un estado final
     * @param macroestado Lista de estados a comprobar.
     * @return Verdadero si alguno de los estados es un estado final.
     */
    public boolean esFinal(int[] macroestado) {
        for (int i = 0; i < macroestado.length; i++) {
            if (esFinal(macroestado[i])) {
                return true;
            }
        }

        return false;
    }

    /**
     * Metodo que  crea y devuelve una lista de estados finales a los que se puede
     * acceder mediante cualquiera de los estados del macroestado inicial mas 
     * los propios estados iniciales.
     * @param macroestado
     */
    private int[] lambda_clausura(int[] macroestado) {

        ArrayList<Integer> clausura=new ArrayList<Integer>();
        ArrayList<Integer> nueva_clausura=new ArrayList<Integer>();
        ArrayList<Integer> transiciones=new ArrayList<Integer>();
        boolean fin=false;
        for (int i = 0; i < macroestado.length; i++) 
            clausura.add(macroestado[i]);
        
        while(!fin)
        {
            nueva_clausura=(ArrayList<Integer>)clausura.clone();
            for(int aux:clausura)
            {
                int[] trans=this.transicionLambda(aux);
                for(int i=0;i<trans.length;i++)
                {
                    if(!transiciones.contains(trans[i]))
                        transiciones.add(trans[i]);
                }
                for(int transicion:transiciones)
                {
                    if(!nueva_clausura.contains(transicion))
                        nueva_clausura.add(transicion);
                }
                transiciones.clear();
            }
            
            if(clausura.size()==nueva_clausura.size())
                fin=true;
            clausura=(ArrayList<Integer>)nueva_clausura.clone();
        }
        
        int[] ret_trans=new int[clausura.size()];
        for(int i=0;i<clausura.size();i++){
            ret_trans[i]=clausura.get(i);
        }
        return ret_trans;   
    }

    /**
     * public boolean reconocer(String cadena) Metodo que comprueba si la cadena
     * pasada es valida para el AFD definido
     *
     * @param cadena: cadena a evaluar
     * @return true si es una cadena valida, false en caso contrario
     */
    public boolean reconocer(String cadena) {
        char[] simbolo = cadena.toCharArray();
        int[] estado = {0}; //El estado inicial es el 0
        int[] macroestado = lambda_clausura(estado);

        for (int i = 0; i < simbolo.length; i++) {
            macroestado = transicion(macroestado, simbolo[i]);
        }
        return esFinal(macroestado);
    }

    /**
     * Metodo que crea un AFND leyendo las transiciones y los estados finales a
     * partir del archivo indicado por el parametro fichero
     *
     * @param fichero
     * @return AFND
     */
    public static AFND pedir(String fichero) {
        AFND ret = new AFND();
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);
            String linea;
            //Esquivando el enunciado
            do {
                linea = br.readLine();
            } while (!linea.equals("Transiciones"));

            linea = br.readLine();

            //Introduciendo transiciones
            do {

                TransicionAFND transicion = new TransicionAFND();
                int turno = 0;
                String[] lineas = linea.split(" ");
                ArrayList<Integer> estadosfinales = new ArrayList<>();
                for (int i = 0; i < lineas.length; i++) {
                    if (lineas[i].equals("")) {
                        continue;
                    }

                    if (turno == 0) {
                        transicion.setEstadoInicial(Integer.parseInt(lineas[i]));
                        turno = (turno + 1) % 3;
                        continue;
                    }
                    if (turno == 1) {
                        transicion.setCaracter(lineas[i].charAt(0));
                        turno = (turno + 1) % 3;
                        continue;
                    }
                    if (turno == 2) {
                        estadosfinales.add(Integer.parseInt(lineas[i]));
                        continue;
                    }
                }
                transicion.setEstadosFinales(ListToInt(estadosfinales));
                ret.getTransiciones().add(transicion);
                linea = br.readLine();
            } while (!linea.equals("Transiciones lambda"));

            //Obteniendo las transiciones lambda
            linea = br.readLine();

            //Introduciendo transiciones
            do {
                if (linea.equals("")) {
                    linea = br.readLine();
                    break;
                }
                TransicionLambda transicion = new TransicionLambda();
                int turno = 0;
                String[] lineas = linea.split(" ");
                ArrayList<Integer> estadosfinales = new ArrayList<>();
                for (int i = 0; i < lineas.length; i++) {
                    if (lineas[i].equals("")) {
                        continue;
                    }

                    if (turno == 0) {
                        transicion.setEstadoInicial(Integer.parseInt(lineas[i]));
                        turno = (turno + 1) % 2;
                        continue;
                    }
                    if (turno == 1) {
                        estadosfinales.add(Integer.parseInt(lineas[i]));
                        turno = (turno + 1) % 2;
                        continue;
                    }
                }
                transicion.setEstadosFinales(ListToInt(estadosfinales));
                ret.getTransicionesLambda().add(transicion);
                linea = br.readLine();
            } while (!linea.equals("Finales"));

            //Obteniendo los estados finales
            linea = br.readLine();
            ArrayList<Integer> estadosFinales = new ArrayList<>();
            do {
                if (linea.equals("")) {
                    linea = br.readLine();
                    break;
                }
                estadosFinales.add(Integer.parseInt(linea));
                linea = br.readLine();
            } while (!linea.equals("EOF"));

            int[] finales = new int[estadosFinales.size()];

            for (int i = 0; i < estadosFinales.size(); i++) {
                finales[i] = estadosFinales.get(i);
            }
            ret.setEstadosFinales(finales);
            br.close();
        } catch (IOException e) {
            return null;
        } catch (Exception e) {
            return null;
        } finally {

        }
        return ret;
    }

    /**
     * Metodo que transfomar la lista de entero que le pasamos mediante parametro
     * en un array del mismo tipo
     * @param l lista de enteros
     * @return array de enteros
     */
    public static int[] ListToInt(List<Integer> l) {
        int[] ret = new int[l.size()];

        for (int i = 0; i < l.size(); i++) {
            ret[i] = l.get(i);
        }

        return ret;
    }

    /**
     * @return the estadosFinales
     */
    public int[] getEstadosFinales() {
        return estadosFinales;
    }

    /**
     * @param estadosFinales the estadosFinales to set
     */
    public void setEstadosFinales(int[] estadosFinales) {
        this.estadosFinales = estadosFinales;
    }

    /**
     * @return the transiciones
     */
    public List<TransicionAFND> getTransiciones() {
        return transiciones;
    }

    /**
     * @param transiciones the transiciones to set
     */
    public void setTransiciones(List<TransicionAFND> transiciones) {
        this.transiciones = transiciones;
    }

    /**
     * @return the transicionesLambda
     */
    public List<TransicionLambda> getTransicionesLambda() {
        return transicionesLambda;
    }

    /**
     * @param transicionesLambda the transicionesLambda to set
     */
    public void setTransicionesLambda(List<TransicionLambda> transicionesLambda) {
        this.transicionesLambda = transicionesLambda;
    }

}
