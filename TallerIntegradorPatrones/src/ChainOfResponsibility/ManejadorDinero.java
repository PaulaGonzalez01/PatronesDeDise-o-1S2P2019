/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChainOfResponsibility;

import Patrones.Account;
import singleton.AtmEC;

public class ManejadorDinero
{
    private ManejadorDinero next;
    protected double denominacion;
    protected int cantidad;

    public ManejadorDinero() {
    }

    public ManejadorDinero(double denominacion, int cantidad) {
        this.denominacion = denominacion;
        this.cantidad = cantidad;
    }

    public ManejadorDinero(ManejadorDinero next,int cantidad, double denominacion){
        this.cantidad= cantidad;
        this.denominacion = denominacion; // Valor de cada billete
        this.next=next;
    }

    
    public double getDenominacion(){ return denominacion; }
    public void setDenominacion(double denominacion){ this.denominacion = denominacion; }

    public ManejadorDinero getNext() {
        return next;
    }

    public void setNext(ManejadorDinero next) {
        this.next = next;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    

    public boolean retirar(double monto,Account a){
        if(monto >= this.denominacion){
			double num = monto/this.denominacion;
			double remainder = monto % this.denominacion;
			System.out.println("Retirando "+num+" billetes/monedas de "  +this.denominacion);
			if(remainder !=0) this.retirar(remainder,a);
                        a.withdraw(monto);
		}else{
			this.next.retirar(monto, a);
		}
        return true;
        
        
    }
    public boolean depositar(int n, int denominacion, Account a){
            double cantidad= n*denominacion;
            a.deposit(cantidad);
        return false;
    }
}