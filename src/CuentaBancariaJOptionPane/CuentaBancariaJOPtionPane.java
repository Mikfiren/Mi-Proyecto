/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CuentaBancariaJOptionPane;
import javax.swing.JOptionPane;

/**
 *
 * @author Mikfiren
 */
public class CuentaBancariaJOPtionPane {
    
    //Defino los atributos. Incluyo también "antiguotitular" pues se me ha ocurrido implementar también una opción de cambio de titular,
    //Este atributo va a ser necesario para poder mostrar la información del anterior
    
    private String nombretitular, antiguotitular;
    private double saldoactual;
    
    
    //Defino un constructor por defecto
    public CuentaBancariaJOPtionPane(){}
    
    //Defino otro constructor con parámetros de la cuenta bancaria. No establezco el valor del parámetro de antiguotitular pues sólo se va a determinar cuando se modifique el titular
    //Por tanto esa inicialización va a estar definida en el metodo "cambioTitular".
    
   
    public CuentaBancariaJOPtionPane(String nombretitular, double saldoactual){
        this.nombretitular=nombretitular;
        this.saldoactual=saldoactual;
    }
    
    
    //Defino los Getters y Sett ers para poder acceder a los atributos privados sin romper la encapsulación.
    
    public String getNombretitular(){
    return nombretitular;
    }
    
    public double getSaldoactual(){
    return saldoactual;
    }
    
    public String getAntiguotitular(){
    return antiguotitular;
    }
    
    public void setAntiguotitular(String antiguotitular){
    this.antiguotitular=antiguotitular;
    }
    
    public void setNombretitular(String nombretitular){
    this.nombretitular=nombretitular;
    }
    
    public void setSaldoactual(double saldoactual){
    this.saldoactual=saldoactual;
    }
    
    
    
    //Defino los métodos que van a ser acciones como tal.
    
    /*Primero defino el primer método de depositar dinero que se me ha ocurrido, sin tener que predefinir el parámetro 'monto' como requisito, sino que se define directamente
    dentro del método. 
    Primero te indica del saldo actual, luego te solicita una cantidad y la almacena en la variable monto.
    Lo siguiente es actualizar el saldo actual al saldo + monto y por último te muestra tanto la cantidad ingresada como el nuevo saldo. */
    
    public void depositarA(){
    double monto = Double.parseDouble(JOptionPane.showInputDialog("Tienes " + saldoactual + " euros.\nEscribe cuánto dinero quieres ingresar: "));
    saldoactual+=monto;
    JOptionPane.showMessageDialog(null,"Has ingresado: " + monto + " euros.\n" +
            "Tu saldo actual es de: " + saldoactual);
    }
    
    
    
   //Esta segunda opción es igual pero requiere que se indique el monto desde la clase Main, por lo que lo veo menos óptimo que la anterior.
        
    public void depositarB(double monto){
   saldoactual=+monto;
    JOptionPane.showMessageDialog(null,"Has ingresado: " + monto + " euros.\n" +
            "Tu saldo actual es de: " + saldoactual);
    }
    
    
    
    /*Defino el método de retirar. Podría haber hecho lo mismo y crear una opción secundaria para que fuese public void retirar(double monto){}, pero opino lo mismo.
    Lo primero que hace es enseñarte también el saldo del que dispones en la cuenta, solicita una cantidad y la almacena en la variable 'monto'.
    Para que no se pueda retirar más dinero del que se dispone, lo he metido en un bucle while, el cual te avisa del saldo actual.
    Podría haberlo hecho con un If, pero quiero que, si solicita más cantidad de la disponible, se repita la acción hasta que la cantidad sea inferior.
    Si la cantidad es inferior o igual a la disponible, se actualiza el saldo a saldo - monto, te informa de la cantidad retirada y del saldo actual.
    */
          
    public void retirar(){
    double monto = Double.parseDouble(JOptionPane.showInputDialog("Tienes " + saldoactual + " euros.\nEscribe cuánto dinero quieres retirar: "));
    
    while(monto > saldoactual){
    monto = Double.parseDouble(JOptionPane.showInputDialog("No tienes tanto dinero.\nTu saldo es de: " + saldoactual 
            + "\nPor favor introduce una cantidad inferior.\n"));
    }
    setSaldoactual(saldoactual-monto);
    JOptionPane.showMessageDialog(null, "Has retirado " + monto + " euros. \n"
            + "Tu saldo actual es de: " + getSaldoactual());
    
    }
    
    
    
    //Este método es sencillo. Simplemente mediante los getters, te muestra el titular y el saldo actual.
    
    public void mostrarInformacion(){
        JOptionPane.showMessageDialog(null,"El titular de la cuenta es: " + getNombretitular() + "\n"
                + "El saldo actual de la cuenta es: " + getSaldoactual());
                }
    
  
    
    /*Este último método es el que se me ha ocurrido añadir. 
    Defino una variable llamada 'titular' que va a almacenar una entrada de texto.
    Primero informo del titular actual, luego solicito el nuevo titular.
    Luego lo que hago es, al atributo Antiguotitular le doy el valor del titular actual mediante un Setter
    Lo siguiente es, al atributo Nombretitular le doy el valor del nuevo titular introducido.
    Por último, inform tanto del titular anterior como del nuevo.
    */
    
    public void cambioTitular(){
    String titular;
    JOptionPane.showMessageDialog(null, "El titular actual de la cuenta es: " + nombretitular);
    titular = JOptionPane.showInputDialog("Escribe el nombre del nuevo titular: ");
    
    antiguotitular=nombretitular;
    nombretitular=titular;

    JOptionPane.showMessageDialog(null,"Se ha cambiado el titular de: \n" + 
            antiguotitular + " a \n" +
            nombretitular);
    
    }
    
    
    
    /*El último método que queda por definir es el de la bienvenida (o menú).
    Primero creo una variable opción para almacenar la opción que va a elegir el usuario.
    Este método primero te da un mensaje de bienvenida.
    Creo un bucle while para que si se escribe algo distinto a 5, se pueda repetir cualquier operación, así lo convierto en una acción 'infinita' hasta que el usuario escriba 5 (salir).
    Dentro del bucle, lo comiento con un try-catch para asegurarme que se recoja el error en caso de que el usuario digite algo distinto a números.
    En el try, primero se va a mostrar en pantalla una lista de las opciones y va a recoger una entrada de datos.*/
    
    public void menu(){

        int opcion = 0;
        
        JOptionPane.showMessageDialog(null,"Bienvenido a tu cajero virtual.\n");
                        
        while(opcion != 5){
            try{
        opcion = Integer.parseInt(JOptionPane.showInputDialog("\nElige una de las tres opciones: \n\n"
                + "1.- Mostrar información de la cuenta\n"
                + "2.- Depositar dinero\n"
                + "3.- Retirar dinero\n"
                + "4.- Cambio de titular\n"
                + "5.- Salir\n"));
        
        /*Si la entrada de datos es un número entero, va a almacenar el dato en la variable 'opcion'.
        Aquí entra el Switch. Como hay que analizar un único valor de una sola variable, es el condicional más adecuado para esto.
        En caso 1, llama al método mostrarInformación(); y así sucesivamente con el 2, 3 y 4.
        En caso 5, se despide y se finaliza el programa mediante el return;
        En caso de que el número sea distinto a 1,2,3,4 o 5, te informa que es una "Opción no válida" y te lo solicita de nuevo..
        En caso de que sea un valor no numérico, te informa "No has escrito un número" y te lo solicita de nuevo.*/
        
        switch(opcion){
            case 1 : mostrarInformacion();
            break;
            case 2 : depositarA();
            break;
            case 3 : retirar();
            break;
            case 4 : cambioTitular();
            break;
            case 5 : 
                JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                return;
            default : JOptionPane.showMessageDialog(null, "Opción no válida.");
        } 
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "No has escrito un número.");
                }
              }
    }
}
