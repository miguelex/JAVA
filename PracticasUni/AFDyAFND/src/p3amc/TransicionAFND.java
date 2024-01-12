/**
 * Práctica 3 de la asignatura de Algorítmica y Modelos de Computación 
 * Automatas Finitos y No Finitos Deterministas
 * Curso 2015/16
 * 
 * @author migue
 */
package p3amc;

public class TransicionAFND {

    private int estadoInicial;
    private char caracter;
    private int[] estadosFinales;

    /**
     * Constructor de la clase
     */
    public TransicionAFND() {
        estadoInicial = -1;
        caracter = '0';
        estadosFinales = null;
    }

    /**
     * Metodo clone
     * @return objeto de tipo TransicionAFND
     */
    public Object clone() {
        TransicionAFND obj = new TransicionAFND();

        obj.setEstadoInicial(estadoInicial);
        obj.setCaracter(caracter);
        obj.setEstadosFinales(estadosFinales);

        return obj;
    }

    /**
     * Constructor parametrizado
     * @param ei estado inicla
     * @param c cimbolo que provoca la transicion
     * @param ef conjunto de estados finales a los que podemos llegar
     */
    public TransicionAFND(int ei, char c, int[] ef) {
        estadoInicial = ei;
        caracter = c;
        estadosFinales = ef;
    }

    /**
     * Constructor pasandole unatransicion
     * @param t una transicion de tipo TransicionAFND
     */
    public TransicionAFND(TransicionAFND t) {
        estadoInicial = t.estadoInicial;
        caracter = t.caracter;
        estadosFinales = t.estadosFinales.clone();
    }

    /**
     * Metodo que devuelve el estado inicial
     * @return estado inicla
     */
    public int getEstadoInicial() {
        return estadoInicial;
    }

    /**
     * Metodo que inserta en el objeto el estado inicial pasado por parametro
     * @param estadoInicial 
     */
    public void setEstadoInicial(int estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    /** 
     * Metodo que nos devuelve el simbolo asociado a una transicion
     * @return simbolo
     */
    public char getCaracter() {
        return caracter;
    }

    /**
     * Metodo que almacena el caracter pasado por parametro en el atributo 
     * caracter del objeto
     * @param caracter caracter que va asociado a una transición
     */
    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    /**
     * Metodo que devuelve el array de estados finales alcanzable por la transicion
     * @return array de estados finales que se alcanzan con las transiciones
     */
    public int[] getEstadosFinales() {
        return estadosFinales;
    }

    /**
     * Metodo que almacena en la transicion una lista de estados finales que es 
     * alcanzable por la misma
     * @param estadosFinales array de estados finales
     */
    public void setEstadosFinales(int[] estadosFinales) {
        this.estadosFinales = estadosFinales;
    }

}
