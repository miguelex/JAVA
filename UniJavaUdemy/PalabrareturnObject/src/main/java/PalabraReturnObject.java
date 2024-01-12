
public class PalabraReturnObject {

    public static void main(String[] args) {
        Suma s = creaObjetoSuma();
        
        System.out.println("Suma = " + s.sumar());
    }
    
    private static Suma creaObjetoSuma() {
        return new Suma(4,6);
    }
}

class Suma {

    int a;
    int b;
    
    public Suma(int a, int b){
        this.a = a;
        this.b = b;
    }
    
    public int sumar() {
        return this.a + this.b;
    }
}
