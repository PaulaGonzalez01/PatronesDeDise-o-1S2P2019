/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChainOfResponsibility;

import Patrones.Account;
import singleton.AtmEC;

public class ManejadorDinero implements Manejador
{
    private Manejador next;
    protected double denominacion;
    protected int cantidad;

    public ManejadorDinero() {
    }

    

    public ManejadorDinero(ManejadorDinero next,int cantidad, double denominacion){
        this.cantidad= cantidad;
        this.denominacion = denominacion; // Valor de cada billete
        this.next=next;
    }

    
    public double getDenominacion(){ return denominacion; }
    public void setDenominacion(double denominacion){ this.denominacion = denominacion; }

    public Manejador getNext() {
        return next;
    }

    public void setNext(Manejador next) {
        this.next = next;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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

    @Override
    public void SetNext(Manejador m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    

   
    

    

    
}