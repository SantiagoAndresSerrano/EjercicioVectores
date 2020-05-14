/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vectoresmaterias;

/**
 *
 * @author santi
 */
public class VectoresMaterias {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Long[] prog3 = {new Long(1234), new Long(786), new Long(678), new Long(3456)};
        Long[] mate3 = {new Long(1234), new Long(789), new Long(678)};
        Long[] fisica2 = {new Long(12), new Long(786), new Long(678), new Long(3456)};
        Modelo.VectoresMaterias v = new Modelo.VectoresMaterias(prog3, mate3, fisica2);

        System.out.println("Estudiantes " + v.getEstudiante().toString());
        System.out.println("Estudiantes matriculados en todas las materias " + v.matricularonTodos().toString());
        System.out.println("Estudiantes matriculados en prog3,Fisica2 " + v.noMatricularonMate().toString());
        System.out.println("Estudiantes matriculados en prog3,mate3 " + v.noMatricularonFisica2().toString());
    }

}
