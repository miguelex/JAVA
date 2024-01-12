/**
 * Práctica 3 de la asignatura de Algorítmica y Modelos de Computación 
 * Automatas Finitos y No Finitos Deterministas
 * Curso 2015/16
 * 
 * @author migue
 */
package p3amc;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que contiene el metodo main. 
 *
 */
public class P3AMC {

    
    /**
     * Programa principal a través del cual se inicia la aplicación Nos pedirá
     * si queremos evaluar un AFD o un AFND. A partir de hay llamara al método
     * correspondiente
     *
     * @param args vacío. No pasamos parámetro en la llamada
     */
    public static void main(String[] args) throws IOException {
        
        FormPral Formulario = new FormPral();
        Formulario.setVisible(true);

    }

}
