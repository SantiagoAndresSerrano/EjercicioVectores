/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author santi
 */
public class Polinomio {
    
    Termino[] polinomio;
    int tam;
    
    public Polinomio(int tamanio){
    polinomio = new Termino[tamanio];
    tam=0;
    
    }

    public Termino[] getPolinomio() {
        return polinomio;
    }

    public void setPolinomio(Termino[] polinomio) {
        this.polinomio = polinomio;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }
    
    
    public void addMonomio(Termino t){
       
       if(tam<polinomio.length){
           polinomio[tam]=t;
           tam++;
       }
    
    }
    
    public void getDerivada(){
    
        for (Termino polinomio1 : polinomio) 
        {
            polinomio1.setValor(polinomio1.getExponente()*polinomio1.getValor());
            polinomio1.setExponente(polinomio1.getExponente()-1);
            
        }
    
    }
    
    @Override
    public String toString(){
    String poli="";
    String signo; 
        for (Termino t: polinomio) {
            if(t.valor>0)
                signo="+";
            else
                signo="";
            
            
            poli+=" "+signo+t.valor+"*"+t.literal+"^"+t.exponente;       
        }
    return poli;
    }
    
}
