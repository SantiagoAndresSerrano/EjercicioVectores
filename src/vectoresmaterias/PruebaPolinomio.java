/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vectoresmaterias;

import Modelo.Polinomio;
import Modelo.SistemaPolinomio;
import Modelo.Termino;

/**
 *
 * @author santi
 */
public class PruebaPolinomio {

    //(char literal, int exponente, float valor) 
    public static void main(String[] args) throws Exception {
        Termino t = new Termino('x',5,3.0f);
        Termino t2 = new Termino('y',6,8.0f);
        Termino t5 = new Termino('y',4,2.0f);
        Termino t6 = new Termino('y',1,12.0f);
        
        Termino t3 = new Termino('x',2,10.0f);
        Termino t4 = new Termino('y',1,9.0f);
        
        Polinomio p =new Polinomio(2);
        
        p.addMonomio(t);
        p.addMonomio(t2);
        System.out.println(p.toString());
        p.getDerivada();
        
        System.out.println(p.toString());
         p.getDerivada();
         System.out.println(p.toString());
        
    }
    
}
