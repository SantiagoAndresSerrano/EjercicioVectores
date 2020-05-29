/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Util.Conjunto;

/**
 *
 * @author santi
 */
public class SistemaPolinomio {

    Conjunto<Polinomio> polinomios;

    public SistemaPolinomio(int numero) {

        polinomios = new Conjunto(numero);

    }

    public void addPolinomio(Polinomio p) throws Exception {

        polinomios.adicionarElemento(p);

    }
    public Termino sumarDosMonomios(Termino t1,Termino t2){
    
        Termino t = null;
        int ex1=t1.getExponente(),ex2=t2.getExponente();
        char lit1=t1.getLiteral(),lit2=t2.getLiteral();
        float val1=t1.getValor(),val2=t2.getValor();
    
        if(ex1== ex2 && lit1==lit2){
            
            t=new Termino(lit1,ex1,val1+val2);
        }
        
        return t;
    }
    
    
    public void sumarPolinomios() {

        Polinomio suma;
        Conjunto<Polinomio> copia=polinomios;
        for (int i = 0; i < copia.getLength(); i++) {

            Polinomio polinomioI = copia.get(i);
            Termino terminoI=null;
            
            
           
                
            

        }

        
    }

    @Override
    public String toString() {
        String polinomioTotal = "";
        System.out.println(polinomios.getLength());
        for (int i = 0; i < polinomios.getLength(); i++) {
            polinomioTotal += polinomios.get(i).toString();

        }
        return polinomioTotal;
    }

}
