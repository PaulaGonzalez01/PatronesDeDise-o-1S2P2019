/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones;
import adapter.Cuenta;
import adapter.CuentaAdapter;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Scanner;
import ChainOfResponsibility.Manejador;

/**
 *
 * @author CltControl
 */
public class AtmEC {
    private static AtmEC instance = new AtmEC();
    private Currency moneda;
    private double dinero;
    private static Manejador manejador;
    private static Cuenta cuentaAdap;
  
    
    
    private AtmEC() {
    }

    public static AtmEC getInstance() {
        return instance;
    }

       public boolean sacarDinero(double dinero){
            if(manejador!= null){
                return manejador.Retirar(dinero);
            }
            return false;
       }

       public boolean ingresarDinero(int n, double denominacion){
           if(manejador!= null){
                return manejador.Depositar(n, denominacion);
            }
           return false;
       }

       public void addManejador(Manejador m){
           if(manejador == null){
               manejador = m;
           }
        }
       
       
       public Manejador removeManejador(Manejador m){
           return null;
       }
       
       
       public static void transaction(Cuenta cuenta){
        cuentaAdap = cuenta;
        // here is where most of the work is
        Scanner in= new Scanner(System.in);
        int choice; 
        System.out.println("Please select an option"); 
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Balance");
        System.out.println("4. Balance ATM");
        System.out.print("opcion: ");
        choice = in.nextInt();
        switch(choice){
            case 1:
                float amount; 
                System.out.print("Por favor ingrese el monto a retirar: "); 
                amount = in.nextFloat();
                if(amount > cuenta.balance()|| amount == 0){
                    System.out.println("Su saldo es insuficiente!!\n\n"); 
  
                    anotherTransaction(cuenta); // ask if they want another transaction
                } else {
                    // Todo: verificar que se puede realizar el retiro del atm
                    if(amount<cuenta.balance()){
                        cuentaAdap.retirar(amount);
                    }    
                    // Todo: actualizar tanto la cuenta como el atm y de los manejadores
                    cuenta.retirar(amount);
                    if(instance.sacarDinero(amount)){
                        System.out.println("Se realizó el retiro exitosamente");
                    }else{
                        System.out.println("No hay suficiente efectivo en el ATM.");
                    }

                    // Todo: Mostrar resumen de transacción o error
                    // "You have withdrawn "+amount+" and your new balance is "+balance;
                    anotherTransaction(cuenta); 
                }
            break; 
            case 2:
                    // option number 2 is depositing 
                    float deposit; 
                    System.out.println("Please enter amount you would wish to deposit: "); 
                    deposit = in.nextFloat();
                    // Todo: actualizar tanto la cuenta como el atm
                    
                    // Todo: Mostrar resumen de transacción o error
                    // "You have withdrawn "+amount+" and your new balance is "+balance;
                    anotherTransaction(cuenta);
            break; 
            case 3:
                    // Todo: mostrar el balance de la cuenta
                    // "Your balance is "+balance
                    anotherTransaction(cuenta); 
            break;
            case 4:
                    // Todo: mostrar el balance del ATM con los billetes en cada manejador
                    anotherTransaction(cuenta); 
            break;
            default:
                    System.out.println("Invalid option:\n\n"); 
                    anotherTransaction(cuenta);
            break;
        }
    }

       public static void anotherTransaction(Cuenta cuenta){

          Scanner in = new Scanner(System.in);
        int op;
        System.out.println("Do you want another transaction?\n\nPress 1 for another transaction\n2 To exit");
        op = in.nextInt();
        if (op == 1) {
            transaction(cuenta); // call transaction method
        } else if (op == 2) {
            System.out.println("Thanks for choosing us. Good Bye!");
        } else {
            System.out.println("Invalid choice\n\n");
            anotherTransaction(cuenta);
        }
    }
}