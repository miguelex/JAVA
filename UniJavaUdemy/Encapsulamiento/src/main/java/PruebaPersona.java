
public class PruebaPersona {

    public static void main(String[] args) {
        Persona persona = new Persona("Juan", 5000, false);

//        System.out.println("Nombre de la persona: " + persona.getNombre());
//        System.out.println("Sueldo de la persona: " + persona.getSueldo());
//        System.out.println("Persona eliminada? : " + persona.isEliminado());
        System.out.println("Persona -> " + persona.toString());
        System.out.println("persona = " + persona);// Funciona igual que lo anteriro

        persona.setNombre("Miguel");
        persona.setSueldo(3000);
        persona.setEliminado(true);

//        System.out.println("Nombre de la persona: " + persona.getNombre());
//        System.out.println("Sueldo de la persona: " + persona.getSueldo());
//        System.out.println("Persona eliminada? : " + persona.isEliminado());
        System.out.println("Persona -> " + persona.toString());
        System.out.println("persona = " + persona); //FUnciona igual que lo anterior
    }
}
