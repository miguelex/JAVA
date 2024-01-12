
public class sobrecargConstructores {

    public static void main(String[] args) {

        Persona persona1 = new Persona("Juan", 25);
        System.out.println("Persona = " + persona1);
        
        Empleado empleado1 = new Empleado("Karla", 30, 32000);
        System.out.println("Empleado = " + empleado1);
    }
}
