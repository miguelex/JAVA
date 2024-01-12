package palabrafinal;

public final class claseFinal {
    
    // No se puede crear clases hijas por estar marcada como final
    
    //variable marcadas como final
    public final int varNumero = 1; //Se debe inicializar la variable bien aqui o en el constructor
    
    //Constante en java
    public static final int VAR_PRIMITIVO = 14; //Constantes en mayusculas
    
    public static final Persona VAR_PERSONA = new Persona(); //Accede a los atributos de ese objeto pero el objeto es constante
    
    // metodo final
    public final void metodoFinal(){
        //No podremos redefinir el comportamiento de este metodo en una clase hija
    }
}

/* Ejemplo de lo cicho en el anterior comentario
class claseHija extends claseFinal
*/