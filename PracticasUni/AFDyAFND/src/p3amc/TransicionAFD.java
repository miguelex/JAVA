/**
 * Práctica 3 de la asignatura de Algorítmica y Modelos de Computación 
 * Automatas Finitos y No Finitos Deterministas
 * Curso 2015/16
 * 
 * @author migue
 */
package p3amc;

/**
 * Clase que define los elementos de un AFD. Tenemos tres atributos para definir
 * dichos elementos: Estado_inicial: Estado del cual parte la transición
 * Estado_final: Estado al cual llega la transición Simbolo: Simbolo por el cual
 * se pasa del estado inicial al final
 */
public class TransicionAFD implements Cloneable {

    private int Estado_inicial;
    private int Estado_final;
    private char Simbolo;

    /**
     * public TransicionAFD(). Constructor de la clase
     */
    public TransicionAFD() {
        Estado_inicial = 0;
        Simbolo = 'a';
        Estado_final = 0;
    }

    /**
     * Constructor de la clase. Define una transición asociada a un AFD
     *
     * @param e1: Estado inicial de la transición.
     * @param e2: Estado final de la transición.
     * @param simbolo: simbolo que genera la transición
     */
    public TransicionAFD(int e1, int e2, char simbolo) {
        Estado_inicial = e1;
        Estado_final = e2;
        Simbolo = simbolo;
    }

    /**
     * es el metodo que nos va a permitir duplicar un objeto de tipo
     * TransicionAFD.
     *
     * @return obj: Objeto de tipo TransicionAFD
     */
    public Object clone() {
        TransicionAFD obj = null;
        try {
            obj = (TransicionAFD) super.clone();
        } catch (CloneNotSupportedException ex) {
            System.out.println(" no se puede duplicar");
        }
        return obj;
    }

    /**
     * Método que devuelve el estado inicial
     *
     */
    public int getEI() {
        return Estado_inicial;
    }

    /**
     * Método que devuelve el estado inicial
     *
     */
    public int getEF() {
        return Estado_final;
    }

    /**
     * Método que devuelve el simbolo
     *
     */
    public char getSimbolo() {
        return Simbolo;
    }

    /**
     * Método que nos permite definir el estado inicial
     *
     * @param ei: Estado inicial de la transición.
     *
     */
    public void setEI(int ei) {
        Estado_inicial = ei;
    }

    /**
     * Método que nos permite definir el estado final
     *
     * @param ef: Estado final de la transición.
     *
     */
    public void setEF(int ef) {
        Estado_final = ef;
    }

    /**
     * Método que nos permite definir el simbolo
     *
     * @param simb: simbolo que genera la transición
     *
     */
    public void setSimbolo(char simb) {
        Simbolo = simb;
    }

}
