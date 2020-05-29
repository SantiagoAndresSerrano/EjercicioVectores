/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Arrays;
import java.util.Vector;

/**
 *
 * @author santi
 */
public class ManejoCadena {

    public void copiarCadena(String s, String s2) throws Exception {

        char[] vectorS = s.toCharArray();
        char[] vectorS2 = s2.toCharArray();

        if (vectorS2.length > 0) {
            throw new Exception("La cadena s2 debe estar vacía.");
        }

        vectorS2 = new char[vectorS.length];

        for (int i = 0; i < vectorS.length; i++) {
            vectorS2[i] = vectorS[i];

        }
        System.out.println("Cadena 1" + Arrays.toString(vectorS));
        System.out.println("Cadena 2" + Arrays.toString(vectorS2));

    }

    public void contarFrases(String oracion) {

        char oraciones[] = oracion.toCharArray();

        int cantidadOraciones = 0;
        int cantidadFrases = 0;
        for (int i = 0; i < oraciones.length; i++) {
            if (oraciones[i] == ' ') {

                cantidadFrases++;
            }
            if (oraciones[i] == '.') {
                cantidadFrases++;
                cantidadOraciones++;
                System.out.println("Frases en la oracion " + cantidadOraciones + " =" + cantidadFrases);
                cantidadFrases = 0;

            }

        }

    }

    public void separarFrases(String oracion) {
        char oraciones[] = oracion.toCharArray();

        for (int i = 0; i < oraciones.length; i++) {
            if (oraciones[i] == ' ' || oraciones[i] == '.') {
                System.out.println("");
            } else {
                System.out.print(oraciones[i]);
            }

        }

    }

    public Boolean esOracionPalindroma(String oracion) {
        char[] frase = oracion.toCharArray();
       
        for (int i = 0, j = frase.length - 1; i < frase.length; i++, j--) {

            if (frase[j] != frase[i]) {
                return false;
            }
        }
        return true;
    }

    public Boolean sonSimilares(String l1, String l2) {

        char[] vl1 = l1.toCharArray();
        char[] vl2 = l2.toCharArray();

        if (vl1.length != vl2.length) {
            return false;
        }

        int repetido = 0;
        for (int i = 0; i < vl1.length; i++) {

            for (int j = 0; j < vl2.length; j++) {

                if (vl1[i] == vl2[j]) {
                    repetido++;
                    j = vl2.length;
                }

            }

        }
        if (repetido == vl1.length) {
            return true;
        }

        return false;
    }

    public int vecesQueEstaUnaCadenaEnOtra(String s1, String s2) {
        char[] vectorS = s1.toCharArray();
        char[] vectorS2 = s2.toCharArray();

        for (int j = 0; j < vectorS2.length; j++) {
            for (int i = 0; i < vectorS.length; i++) {
                if(vectorS2[j]==vectorS[i]){
                    
                }
            }
        }

        return -1;
    }

    public void copiarAlFinal(String s1, String s2) {
        char[] vectorS = s1.toCharArray();
        char[] vectorS2 = s2.toCharArray();
        char[] vectorS3 = new char[vectorS.length + vectorS2.length];
        int contador = 0;
        for (int i = 0; i < vectorS3.length; i++) {
            if (i < vectorS.length) {
                vectorS3[i] = vectorS[i];
            } else {

                vectorS3[i] = vectorS2[contador];
                contador++;
            }

        }
        vectorS = vectorS3;
        vectorS2 = vectorS3;

        System.out.println(vectorS);
        System.out.println(vectorS2);
    }

}
