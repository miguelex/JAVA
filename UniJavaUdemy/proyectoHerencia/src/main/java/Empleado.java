
public class Empleado extends Persona{
    
    private int idEmpleado;
    private double Sueldo;
    private static int contadorEmpleado;
    
    public Empleado (String Nombre, double Sueldo) {
        super(Nombre);
        this.idEmpleado = ++contadorEmpleado;
        this.Sueldo = Sueldo;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public double getSueldo() {
        return Sueldo;
    }

    public void setSueldo(double Sueldo) {
        this.Sueldo = Sueldo;
    }

    public static int getContadorEmpleado() {
        return contadorEmpleado;
    }

    @Override
    public String toString() {
        return super.toString() + "Empleado{" + "idEmpleado=" + idEmpleado + ", Sueldo=" + Sueldo + '}';
    }

    
    
    
}
