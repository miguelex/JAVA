package arreglos;

public class ejemploArreglos {
    
    public static void main(String[] args) {
        
        //Declaramos una variable de tipo arreglo. Arreglo de int
        
        int edades[];
        
        // Instanciamos el arreglo de int
        
        edades = new int[3];
        
        // Inicializamos los valores de los elementos del arreglo
        
        edades[0] = 30;
        edades[1] = 15;
        edades[2] = 20;
        
        // Imprimimos valores del arreglo
        
        System.out.println("Arreglo de enteros. Indice 0: " +edades[0]);
        System.out.println("Arreglo de enteros. Indice 1: " +edades[1]);
        System.out.println("Arreglo de enteros. Indice 2: " +edades[2]);

        // Arreglo tipo Object
        
        Persona personas[] = new Persona[4];
        
        // Inicializamos los valores del arreglo
        
        personas[0] = new Persona("Juan");
        personas[2] = new Persona("Karla");
        
        System.out.println("Arreglo personas. Indice 0: " +personas[0]);
        System.out.println("Arreglo personas. Indice 1: " +personas[1]);
        System.out.println("Arreglo personas. Indice 2: " +personas[2]);
        System.out.println("Arreglo personas. Indice 3: " +personas[3]);
        
        //Arreglos notacion simplificada
        
        String nombres[] = {"Sara", "Migue", "Inma", "Jose"};
        
        //Imprimir los valores de un arreglo
        
        for (int i = 0; i < nombres.length; i++) {
            System.out.println("Arreglo string. Indice:  " + i + " Valor: " + nombres[i]);
        }
    }
}
