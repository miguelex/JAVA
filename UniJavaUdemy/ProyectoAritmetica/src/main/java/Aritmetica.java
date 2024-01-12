
public class Aritmetica {

    // Atributos de la clase
    int a, b;

    public Aritmetica() {
        System.out.println("Ejecutando constructor vacio...");
    }

    // Constructor con paso de valores
    
    public Aritmetica(int a, int b){
        this.a = a;
        this.b = b;
    }
    public int sumar() {
        return a + b;
    }
    
    public int restar(){
        return a-b;
    }
    
    public int multiplicar(){
        return a*b;
    }
    
    public int dividir(){
        return a/b;
    }
}
