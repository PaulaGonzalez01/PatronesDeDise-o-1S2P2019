/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones;

public class Manejador
{
    private Manejador next;
    protected double denominacion;
    protected int cantidad;

    public Manejador() {
    }

    public Manejador(Manejador next,int cantidad, double denominacion){
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
    

    public boolean retirar(int monto){
        
        return false;
    }
    public boolean depositar(int monto, int denominacion){
            
        return false;
    }
}