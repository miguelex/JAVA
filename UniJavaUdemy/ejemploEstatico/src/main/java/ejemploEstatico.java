public class ejemploEstatico {
    
    public static void main(String[] args) {
        
        Persona persona1 = new Persona("Juan");
        
        System.out.println(persona1.toString());
        
        Persona persona2 = new Persona("Migue");
        
        System.out.println(persona2.toString());
        
        System.out.println("Contador de perosnas: " + Persona.getContadorPersona());
    }
}
