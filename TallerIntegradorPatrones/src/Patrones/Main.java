/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones;

import ChainOfResponsibility.ManejadorDinero;

public class Main
{
    public static void main(String[] args)
    {
        AtmEC atm = new AtmEC();
        ManejadorDinero m1=new ManejadorDinero(20,100);
        ManejadorDinero m2=new ManejadorDinero(10,100);
        ManejadorDinero m3=new ManejadorDinero(0.5,10);
        ManejadorDinero m4=new ManejadorDinero(0.25,10);
        ManejadorDinero m5=new ManejadorDinero(0.05,1000);
        m1.setNext(m2);
        m2.setNext(m3);
        m3.setNext(m4);
        m4.setNext(m5);
        atm.setManejador(m1);
        
        
        atm.addManejador(m1);
        // Crear un único cajero Automático de dólares con 100 billetes de 20, 100 de 10, 
        // 10 monedas de 0.50, 10 de 0.25 y 1000 de 0.05

        // Crear 10 cuentas nuevas en dólares locale.US con un saldo inicial entre 100.00 y 1000.00 USD cada una.
        
        // Menú principal para seleccionar una de las 10 cuentas solo con el id
        
        // Mostrar el menú para realizar transacciones en el cajero automático
    }

    
}
