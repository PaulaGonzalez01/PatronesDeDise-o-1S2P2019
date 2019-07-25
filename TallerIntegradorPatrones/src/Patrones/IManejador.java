/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones;

/**
 *
 * @author CltControl
 */
public interface IManejador {
    
    public void IManejador(int n, double denominacion);
    public void SetNext(IManejador m);
    public boolean Retirar(int monto);
    public boolean Depositar(int n, double denominacion);
    
    
}
