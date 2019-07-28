/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

import Patrones.Account;
import java.util.Currency;

/**
 *
 * @author CltControl
 */
public class CuentaAdapter implements Cuenta {
    protected Account cuenta;
    protected Currency moneda;
    
    public CuentaAdapter(int id, double monto){
        cuenta = new Account(id, monto);
    }

    @Override
    public double balance() {
        return cuenta.getAmount();
    }

    @Override
    public boolean retirar(double monto) {
        String s = cuenta.withdraw(cuenta.getAmount());
        if(s.startsWith("Error")){
            return false;
        }
        return true;
    }

    @Override
    public boolean depositar(int n, double denominacion) {
        cuenta.deposit(cuenta.getAmount());
        return true;
    }
}
