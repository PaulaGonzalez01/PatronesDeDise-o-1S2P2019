/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones;

import ChainOfResponsibility.Manejador;
import ChainOfResponsibility.ManejadorDinero;

public class Main
{
    public static void main(String[] args)
    {
        AtmEC atm = new AtmEC();
        ManejadorDinero m1=null;
        m1.Manejador(100,20);
        
        ManejadorDinero m2=null;
        m2.Manejador(100, 10);
       
        ManejadorDinero m3=null;
       m3.Manejador(10, 0.5);
        ManejadorDinero m4=null;
        m4.Manejador(10, 0.25);
        
        ManejadorDinero m5=null;
        m5.Manejador(1000, 0.05);
        
        m1.setNext(m2);
        m2.setNext(m3);
        m3.setNext(m4);
        m4.setNext(m5);
        atm.setManejador(m1);
        
        
       

        // Crear 10 cuentas nuevas en dólares locale.US con un saldo inicial entre 100.00 y 1000.00 USD cada una.
        
        // Menú principal para seleccionar una de las 10 cuentas solo con el id
        
        // Mostrar el menú para realizar transacciones en el cajero automático
    }

    
}
