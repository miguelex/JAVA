
public class PalabraThis {

    public static void main(String[] args) {
        Persona p = new Persona("Migue");
    }
}

class Persona {
    String nombre;
    
    Persona (String nombre) {
        this.nombre = nombre; // this apunta a objeto de tipo persona
        System.out.println("Impresión del operador this de la clase persona = " + this);// this apunta a objeto de tipo persona
        Imprimir imprimir = new Imprimir();
        imprimir.imprimir(this); // this cotinee una referencia al objeto persona
    }
}

class Imprimir {
    
    public void imprimir (Persona p){
        System.out.println("Imprimimos argumento persona = " + p); // Imprimimos el valor del obejto persona
        System.out.println("Imprimimos el valor del objeto actual (this)= " + this); // this apunta a un obejto de tipo imprimir en este moemnto
    }
}