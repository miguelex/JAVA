
import java.util.Scanner;

public class HolaMundo {

    public static void main(String args[]) {

        System.out.println("Ejemplo de break");
        ini:
        for (var i = 0; i < 3; i ++)
        {
            // Imprimimos solo numeros pares
            if (i % 2 == 0)
            {
                System.out.println("i = " + i);
                break ini;
            }
        }
        System.out.println("Ahora ejemplo de continue");
        inicio:
        for (var i = 0; i < 3; i ++)
        {
            // Imprimimos solo numeors pares
            if (i % 2 != 0)
            {
                continue inicio;
            }
            System.out.println("i = " + i);
        }
        
    }
}
