/**
 * Práctica 3 de la asignatura de Algorítmica y Modelos de Computación 
 * Automatas Finitos y No Finitos Deterministas
 * Curso 2015/16
 * 
 * @author migue
 */
package p3amc;

public class TransicionLambda {

    private int estadoInicial;
    private int[] estadosFinales;

    /**
     * Constructor por defecto de la clase
     */
    public TransicionLambda() {
        estadoInicial = -1;
        estadosFinales = null;
    }

    /**
     * Constructor parametrizado
     *
     * @param ei estado inical
     * @param ef lista de estados finales
     */
    public TransicionLambda(int ei, int[] ef) {
        estadoInicial = ei;
        estadosFinales = ef;
    }

    /**
     * Metodo que permite clonar a un objeto de tipo TransicionLambda
     *
     * @return Objeto clonado
     */
    public Object clone() {
        TransicionLambda obj = new TransicionLambda();

        obj.setEstadoInicial(estadoInicial);
        obj.setEstadosFinales(estadosFinales);

        return obj;
    }

    /**
     * Constructor con parámetro para asignar una transición completa
     *
     * @param tl Una transicion
     */
    public TransicionLambda(TransicionLambda tl) {
        estadoInicial = tl.estadoInicial;
        estadosFinales = tl.estadosFinales.clone();
    }

    /**
     * Metodo que devuelve un estado inicla
     *
     * @return estado inial
     */
    public int getEstadoInicial() {
        return estadoInicial;
    }

    /**
     * Metodo que guarda un estado inicial
     *
     * @param estadoInicial
     */
    public void setEstadoInicial(int estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    /**
     * Metodo que devuelve una lista de estados finales
     *
     * @return
     */
    public int[] getEstadosFinales() {
        return estadosFinales;
    }

    /**
     * Metodo que almacena una lista de estados finales
     *
     * @param estadosFinales
     */
    public void setEstadosFinales(int[] estadosFinales) {
        this.estadosFinales = estadosFinales;
    }

}
