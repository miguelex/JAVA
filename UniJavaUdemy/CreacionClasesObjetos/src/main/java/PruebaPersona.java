
public class PruebaPersona {

    public static void main(String[] args) {
        
        // Creacion de un objeto tipo persona
        
        Persona persona1;
        persona1 = new Persona();
        
        persona1.desplegarNombres();
        
        // Modificar lo valroes de lso atributos
        
        persona1.nombre = "Migue";
        persona1.apellidos = "Delgado";
        
        persona1.desplegarNombres();
        
        Persona persona2 = new Persona();
        
        persona2.nombre = "Carla";
        persona2.apellidos = "Gomez";
        
        persona2.desplegarNombres();
    }
}
