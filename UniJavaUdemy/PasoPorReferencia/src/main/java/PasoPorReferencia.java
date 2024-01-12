
public class PasoPorReferencia {

    public static void main(String[] args) {
        Persona persona = new Persona();
        
        persona.cambiarNombre("Juan");
        System.out.println("Nombre es: " + persona.obtenerNombre());
        
        modificaPersona(persona);
        
        System.out.println("Nombre modificado: " + persona.obtenerNombre());
        
    }

    private static void modificaPersona(Persona personaArg) {
        personaArg.cambiarNombre("Carlos");
    }
}
