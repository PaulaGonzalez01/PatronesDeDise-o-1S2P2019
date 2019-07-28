/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChainOfResponsibility;

/**
 *
 * @author CltControl
 */
public interface Manejador {
    
    public void IManejador(int n, double denominacion);
    public void SetNext(Manejador m);
    public boolean Retirar(int monto);
    public boolean Depositar(int n, double denominacion);
    
    
}
