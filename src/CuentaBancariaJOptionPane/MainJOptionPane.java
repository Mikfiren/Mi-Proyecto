/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package CuentaBancariaJOptionPane;


/**
 *
 * @author Mikfiren
 */
public class MainJOptionPane {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        CuentaBancariaJOPtionPane miCuenta = new CuentaBancariaJOPtionPane("Miguel", 1000);
        
        
        miCuenta.menu();
        
        //miCuenta.depositarB(500);
        //miCuenta.depositarB(Double.parseDouble(JOptionPane.showInputDialog("\nEscribe cuánto dinero quieres ingresar: "))); 
        /*
        Esta es otra opción que se me ha ocurrido para el método de depositar dinero, el cual tendría el parámetro double monto como requisito del método. 
        Creo que no es tan óptimo pues además al ser privados los atributos de la clase CuentaBancaria, no es posible hacer un llamamiento al saldoactual ni a ningún otro
        
        */
        
        }
    
}