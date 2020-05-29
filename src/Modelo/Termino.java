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
public class Termino {
    
    char literal;
    int exponente;
    float valor;

    public Termino() {
    }

    public Termino(char literal, int exponente, float valor) {
        this.literal = literal;
        this.exponente = exponente;
        this.valor = valor;
    }
    
    public char getLiteral() {
        return literal;
    }

    public void setLiteral(char literal) {
        this.literal = literal;
    }

    public int getExponente() {
        return exponente;
    }

    public void setExponente(int exponente) {
        this.exponente = exponente;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString(){
    return valor+""+literal+"^"+exponente;
    }
    
}
