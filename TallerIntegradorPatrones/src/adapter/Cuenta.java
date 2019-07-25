/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

/**
 *
 * @author CltControl
 */
public interface Cuenta {
    double balance();
    boolean retirar(int monto);
    boolean depositar(int n, double denominacion);
}
