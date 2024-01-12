package matrices;

public class ejemploMatrices {
    
    public static void main(String[] args) {
        
        // declaramos matriz de tipo entero
        
        int edades[][];
        
        // Instanciamos la matriz
        
        edades = new int[3][2];
        
        // Instanciar los valroes de la matriz
        edades[0][0] = 15;
        edades[0][1] = 5;
        edades[1][0] = 45;
        edades[1][1] = 22;
        edades[2][0] = 8;
        edades[2][1] = 55;
        
        // Imprimir valores
        System.out.println("Matriz entero en indice 0,0: " + edades[0][0]);
        System.out.println("Matriz entero en indice 1,1: " + edades[1][1]);
        System.out.println("Matriz entero en indice 2,1: " + edades[2][1]);
        
        // Declaramos e instanciamos una matriz de objetos
        
        Persona personas[][] = new Persona[1][2];
        personas[0][0] = new Persona("Juan");
        personas[0][1] = new Persona("Karla");
        
        // Imprimir valores
        System.out.println("Matriz persoan en el indice 0,0: " + personas[0][0]);
        System.out.println("Matriz persoan en el indice 0,1: " + personas[0][1]);
        
        // Imprimir toda la matriz
        
        for (int i = 0; i < personas.length; i++) {
            for (int j = 0; j < personas[i].length; j++) {
                System.out.println("Valor de la matriz en la posicion " + i + " - " + j+ ": " + personas[i][j]);        
            }  
        }
        
    }
    
}
