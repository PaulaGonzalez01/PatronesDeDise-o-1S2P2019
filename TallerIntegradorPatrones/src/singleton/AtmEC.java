/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleton;
import Patrones.Account;
import java.util.Currency

/**
 *
 * @author CltControl
 */
public class AtmEC {
        private AtmEC instance;
        private Currency moneda;
        private Double dinero ;
        private Manejador manejador;
        
        private AtmEC(){
            
        }
        public AtmEC getInstance(){
            return this.instance;
        }
        
        public boolean sacarDinero(int dinero){
            return true;
        }
        
        public boolean ingresarDinero(int n, double denominacion){
            return true;
        }
        
        public void addManejador(Manejador m){
            
        }
        
        public Manejador removeManejador(int i){
            return 
        }
        
        public void transaction(Account cuenta){
            
        }
        
        public void anotherTransaction(Account cuenta){
            
        }
}
