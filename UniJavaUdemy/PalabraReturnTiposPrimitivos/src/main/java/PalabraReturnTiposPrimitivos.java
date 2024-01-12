
public class PalabraReturnTiposPrimitivos {

    public static void main(String[] args) {

        sumarSinRetornarValor(3, 6);
        
        var resultado = sumarRetornandoValor(3,0);
        System.out.println("resultado = " + resultado);
    }

    private static void sumarSinRetornarValor(int a, int b) {
        System.out.println("El resutlado de la suma es: " + (a + b));
    }
    
    private static int sumarRetornandoValor(int a, int b){
        
        if ( a == 0 && b == 0)
        {
            System.out.println("Los valores pasados son iguales a 0");
            return 0;
        }
        System.out.println("Los valores pasados son distintos a 0");
        return a + b;
    }
}
