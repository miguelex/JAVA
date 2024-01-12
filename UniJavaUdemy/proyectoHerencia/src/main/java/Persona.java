public class Persona {
    private String Nombre;
    private char Genero;
    private int Edad;
    private String Direccion;
    
    
    public Persona ()
    {
        
    }
    // Cosntructo con 1 argumento
    
    public Persona (String Nombre) {
        this.Nombre = Nombre;
    }
    // Constructor completo

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public char getGenero() {
        return Genero;
    }

    public void setGenero(char Genero) {
        this.Genero = Genero;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    
    public Persona (String Nombre, char Genero, int Edad, String Direccion){
        this.Nombre = Nombre;
        this.Genero = Genero;
        this.Edad = Edad;
        this.Direccion = Direccion;
    }

    @Override
    public String toString() {
        return "Persona{" + "Nombre=" + Nombre + ", Genero=" + Genero + ", Edad=" + Edad + ", Direccion=" + Direccion + '}';
    }
    
    
}
