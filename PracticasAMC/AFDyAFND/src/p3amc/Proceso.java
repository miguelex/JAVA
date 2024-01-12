/**
 * Práctica 3 de la asignatura de Algorítmica y Modelos de Computación 
 * Automatas Finitos y No Finitos Deterministas
 * Curso 2015/16
 * 
 * @author migue
 */
package p3amc;

/**
 * Interface que declara los tres metodos comunes en ambos tipos de automatas
 * 
 */
public interface Proceso {

    public boolean esFinal(int estado);
    public boolean reconocer(String cadena);
    public String toString();
}
