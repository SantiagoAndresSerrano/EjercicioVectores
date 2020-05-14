/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vectoresmaterias;

import Modelo.Vector;

/**
 *
 * @author santi
 */
public class PruebaVector {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        Vector v = new Vector(23);

        System.out.println(v.toString());
        v.sortVector();
        System.out.println(v.toString());
    }

}
