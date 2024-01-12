/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author migue
 */
public class Operaciones {
    
    //Metodo Sumar
    public static int sumar (int a, int b){
        System.out.println("metodo sumar con ambos argumentos int-int");
        return a + b;
    }
    
    //Sobrecarga del metodo sumar
    public static double sumar (double a, double b){
        System.out.println("Metodo sumar con ambos argumentos double-double");
        return a + b;
    }
    
    //Sobrecarga del metodo sumar
    public static double sumar (int a, double b){
        System.out.println("Metodo sumar con ambos argumentos int-double");
        return a + b;
    }
    
    //Sobrecarga del metodo sumar
    public static double sumar (double a, int b){
        System.out.println("Metodo sumar con ambos argumentos double-int");
        return a + b;
    }
}
