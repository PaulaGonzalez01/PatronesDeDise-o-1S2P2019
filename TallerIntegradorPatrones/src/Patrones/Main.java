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
        ManejadorDinero m1=new ManejadorDinero();
        m1.setCantidad(100);
        m1.setDenominacion(20);
        ManejadorDinero m2=new ManejadorDinero();
        m2.setCantidad(100);
        m2.setDenominacion(10);
        ManejadorDinero m3=new ManejadorDinero();
        m3.setCantidad(10);
        m3.setDenominacion(0.5);
        ManejadorDinero m4=new ManejadorDinero();
        m4.setCantidad(10);
        m4.setDenominacion(0.25);
        ManejadorDinero m5=new ManejadorDinero();
        m5.setCantidad(1000);
        m5.setDenominacion(0.05);
        m1.setNext(m2);
        m2.setNext(m3);
        m3.setNext(m4);
        m4.setNext(m5);
        atm.setManejador(m1);
        
        
       
        // Crear un único cajero Automático de dólares con 100 billetes de 20, 100 de 10, 
        // 10 monedas de 0.50, 10 de 0.25 y 1000 de 0.05

        // Crear 10 cuentas nuevas en dólares locale.US con un saldo inicial entre 100.00 y 1000.00 USD cada una.
        
        // Menú principal para seleccionar una de las 10 cuentas solo con el id
        
        // Mostrar el menú para realizar transacciones en el cajero automático
    }

    
}
