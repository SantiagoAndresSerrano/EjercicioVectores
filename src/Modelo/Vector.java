/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Arrays;

/**
 *
 * @author santi
 */
public class Vector {

    Object[] vector;
    int tamanio;

    public Vector(int tamanio) throws Exception {
        if (tamanio < 0) {
            throw new Exception("Tamaño invalido");
        }

        vector = new Object[tamanio];
        this.tamanio = tamanio;
        llenarVectorNumeros();
    }

    public final void llenarVectorNumeros() {
        for (int i = 0; i < vector.length; i++) {
            int numero = (int) (Math.random() * 68);
            vector[i] = numero;
        }
    }

    public Object[] getVector() {
        return vector;
    }

    public void setVector(Object[] vector) {
        this.vector = vector;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    @Override
    public String toString() {
        return "Vector=" + Arrays.toString(vector);
    }

    public void addElementoFin(Object e) {

        Object copia[] = new Object[tamanio + 1];

        for (int i = 0; i <= vector.length; i++) {

            if (i < vector.length) {
                copia[i] = vector[i];
            } else {
                copia[i] = e;
            }
        }
        this.setVector(copia);
        tamanio += 1;
    }

    public void addElementoInicio(Object e) {
        Object copia[] = new Object[tamanio + 1];

        for (int i = 0; i <= vector.length; i++) {
            if (i == 0) {
                copia[i] = e;
            } else if (i < vector.length) {
                copia[i] = vector[i - 1];
            } else {
                copia[tamanio] = vector[tamanio - 1];
            }
        }

        this.setVector(copia);
        tamanio += 1;

    }

    public int comparar(Object s1, Object s2) {
        Comparable c = (Comparable) s1;
        return c.compareTo(s2);

    }

    public void sortVector() {
        Boolean terminado = false,cambios=false;
        
        while (!terminado) {
            
            cambios=false;
            for (int i = 0; i < vector.length; i++) {
                if ((i + 1) < vector.length) {

                    if (comparar(vector[i], vector[i + 1]) > 0) {
                        Object e = vector[i + 1];
                        vector[i + 1] = vector[i];
                        vector[i] = e;
                        cambios=true;
                    }
                }
            }
                if(cambios==false)
                    terminado=true;
        }

    }

}
