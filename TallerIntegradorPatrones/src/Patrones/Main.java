/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones;

import adapter.Cuenta;
import adapter.CuentaAdapter;
import ChainOfResponsibility.ManejadorDinero;
import java.util.Currency;
import java.util.Locale;
import ChainOfResponsibility.Manejador;

public class Main
{
    public static void main(String[] args)
    {
        // Crear un único cajero Automático de dólares con 100 billetes de 20, 100 de 10, 
        // 10 monedas de 0.50, 10 de 0.25 y 1000 de 0.05
        Manejador billete100 = new ManejadorDinero(100,100);
        Manejador billete20 = new ManejadorDinero(100,20);
        Manejador billete10 = new ManejadorDinero(1000,10);
        Manejador moneda50 = new ManejadorDinero(10,0.50);
        Manejador moneda25 = new ManejadorDinero(10,0.25);
        Manejador moneda5 = new ManejadorDinero(1000,0.05);
        billete100.setNext(billete20);
        billete20.setNext(billete10);
        billete10.setNext(moneda50);
        moneda50.setNext(moneda25);
        moneda25.setNext(moneda5);
        
        // Crear 10 cuentas nuevas en dólares locale.US con un saldo inicial entre 100.00 y 1000.00 USD cada una.
        Cuenta c1 = new CuentaAdapter(1, 1000);
        // Menú principal para seleccionar una de las 10 cuentas solo con el id
        
        // Mostrar el menú para realizar transacciones en el cajero automático
        AtmEC atm = AtmEC.getInstance();
        atm.addManejador(billete100);
        AtmEC.transaction(c1);
    }

    
}