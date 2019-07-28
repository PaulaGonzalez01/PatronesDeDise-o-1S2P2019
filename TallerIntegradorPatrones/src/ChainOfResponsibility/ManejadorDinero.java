/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChainOfResponsibility;

import Patrones.Account;
import Patrones.AtmEC;

public class ManejadorDinero implements Manejador
{
    private Manejador next;
    protected double denominacion;
    protected int cantidad;

    public ManejadorDinero() {
    }

    public ManejadorDinero(int n, double denominacion) {
        cantidad = n;
        this.denominacion = denominacion;
        next = null;
    }


    public ManejadorDinero(ManejadorDinero next,int cantidad, double denominacion){
        this.cantidad= cantidad;
        this.denominacion = denominacion; // Valor de cada billete
        this.next=next;
    }

    
    

    public Manejador getNext() {
        return next;
    }

    public void setNext(Manejador m) {
        this.next = m;
    }

   
    

    public boolean Retirar(double monto){
        if(monto >= this.denominacion){
			double num = monto/this.denominacion;
			double remainder = monto % this.denominacion;
			System.out.println("Retirando "+num+" billetes/monedas de "  +this.denominacion);
			if(remainder !=0) this.Retirar(remainder);
                        this.cantidad=cantidad-(int)num;
		}else{
			this.next.Retirar(monto);
		}
        return true;
        
        
    }
    public boolean Depositar(int n, double denominacion){
        
            boolean v=true;
            while(v){
                if(this.denominacion==denominacion){
                    this.cantidad=this.cantidad+n;
                    v=false;
                    return true;
                } else 
                    this.getNext().Depositar(n, denominacion);
            
                
                
            }
            
            
            
        return false;
    }

    @Override
    public void Manejador(int n, double denominacion) {
        this.denominacion = denominacion;
        this.cantidad = cantidad;
    }

    public double getDenominacion() {
        return this.denominacion;
    }

 
}