public class Persona {
    
    private int idPersona; // Se asocia con la isntacina
    private String nombre;
    private static int contadorPersona; //se asocia con la clase
    
    public Persona(String nombre) {
        
        this.idPersona = ++contadorPersona;
        this.nombre = nombre;
    }
    
    public int getIdPersona (){
        return this.idPersona;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre( String nombre) {
        this.nombre =nombre;
    }
    
    public static int getContadorPersona() {
        return contadorPersona;
    }
    
    @Override
    public String toString() {
        return "idPersona : " + idPersona + ", nombre: " + nombre + ", contador de persona: " + contadorPersona; 
    }
}
