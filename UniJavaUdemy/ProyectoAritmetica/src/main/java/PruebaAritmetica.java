
public class PruebaAritmetica {

    public static void main(String[] args) {
         
        // Variables locales
        int operandoA =6;
        int operandoB =2;
        
        // Creacion de un objeto clase aritmetica
        
        Aritmetica obj1 = new Aritmetica(operandoA, operandoB);
        
        // Imprimims el valor de lso operandos
        System.out.println("operandoA = " + operandoA);
        System.out.println("operandoB = " + operandoB);
        
        // Imprimimos el resutlado de la suma
        
        System.out.println("Resultado de la suma: " + obj1.sumar());
        
        // Imprimimos el resutlado de la resta
        
        System.out.println("Resultado de la resta: " + obj1.restar());
        
        // Imprimimos el resutlado de la mutiplicacion
        
        System.out.println("Resultado de la multiplicacion: " + obj1.multiplicar());
        
        // Imprimimos el resutlado de la division
        
        System.out.println("Resultado de la division: " + obj1.dividir());
    }
}
