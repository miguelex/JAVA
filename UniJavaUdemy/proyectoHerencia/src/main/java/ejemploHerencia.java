
import java.util.Date;


public class ejemploHerencia {

    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("Juan", 5000);
        empleado1.setEdad(25);
        empleado1.setGenero('H');
        empleado1.setDireccion("Calle Fake 123");
        System.out.println(empleado1);
        
        Cliente cliente1 = new Cliente(new Date(), true);
        cliente1.setNombre("Karla");
        System.out.println(cliente1);
    }
}
