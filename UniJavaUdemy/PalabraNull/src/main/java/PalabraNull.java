
public class PalabraNull {

    public static void main(String[] args) {
        Persona p1 = new Persona("Juan");
        System.out.println("Persona1 = " + p1.obtenerNombre());
        
        Persona p2 = p1;
        System.out.println("Parsona2 = " + p2.obtenerNombre());
        
        p1 = null;
        if (p1 != null)
            System.out.println("Persona1 = " + p1.obtenerNombre());
        else
            System.out.println("Persona1 no apunta a ningun objeto");
    }
}

class Persona {
    String nombre;
    
    Persona (String nombre){
        this.nombre = nombre;
    }
    
    public String obtenerNombre() {
        return this.nombre;
    }
}