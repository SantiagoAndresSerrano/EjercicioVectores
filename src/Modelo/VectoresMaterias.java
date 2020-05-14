/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Objects;
import java.util.Vector;

/**
 *
 * @author santi
 */
public class VectoresMaterias {
    
    Long[]prog3,mate3,fisica2;
    Vector<Long> estudiante=new Vector();
    public VectoresMaterias(){
    }

    public VectoresMaterias(Long[] prog3, Long[] mate3, Long[] fisica2) {
        this.prog3 = prog3;
        this.mate3 = mate3;
        this.fisica2 = fisica2;
        estudiante=estudiantes();
    }

  

    public Vector<Long> getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Vector<Long> estudiante) {
        this.estudiante = estudiante;
    }
    
    
    public final Vector<Long> estudiantes(){
    
        
        for (int i = 0; i < prog3.length || i<mate3.length || i<fisica2.length; i++) {
            
           agregarEstudiante(prog3,i);
           agregarEstudiante(mate3,i);
           agregarEstudiante(fisica2,i);
            
        }
    
    return estudiante;
    }
    
    
    public void agregarEstudiante(Long[]materia,int i){
    
    if(i>=materia.length)
        return;
        
        
    if(materia[i]!=null && !existeEstudiante(materia[i])){
            
            estudiante.add(materia[i]);
            }
    
    }
    public Boolean existeEstudiante(Long codigo){
    
        if(this.estudiante==null)
            return false;
        
        for (int i = 0; i < estudiante.size(); i++) {
           
            if(estudiante.get(i).compareTo(codigo)==0){
            return true;
            }
                
           
        }
       return false; 
    }
    public Long[] getProg3() {
        return prog3;
    }

    public void setProg3(Long[] prog3) {
        this.prog3 = prog3;
    }

    public Long[] getMate3() {
        return mate3;
    }

    public void setMate3(Long[] mate3) {
        this.mate3 = mate3;
    }

    public Long[] getFisica2() {
        return fisica2;
    }

    public void setFisica2(Long[] fisica2) {
        this.fisica2 = fisica2;
    }
    
    public Boolean estaEnTodo(Long codigo){
        
        Boolean m=false,f=false,p=false;
        
         for (int j = 0; j < prog3.length || j<fisica2.length || j<mate3.length; j++) 
            {   if(j<prog3.length)
                    if(prog3[j].compareTo(codigo)==0){
                    p=true;
                }
                if(j<mate3.length)
                    if(mate3[j].compareTo(codigo)==0){
                        m=true;
                }
                if(j<fisica2.length)
                    if(fisica2[j].compareTo(codigo)==0){
                    f=true;
                }
                
            }
         
         return p && m && f;
    }
        
   
    public Vector<Long> matricularonTodos()
    {
        Vector<Long> matriculados = new Vector();

           for (int i = 0; i < estudiante.size(); i++) 
                if(estaEnTodo(estudiante.get(i)))
                    matriculados.add(estudiante.get(i));

    return matriculados;  
    }
    
    
    public Boolean existeEstudiante(Long[]materia,Long codigo){        
        for (Long materia1 : materia)
        if (materia1.compareTo(codigo) == 0) 
                return true;        
    return false;
    }
    public Vector<Long> noMatricularonMate()
    {
        
        Vector<Long> matriculados = new Vector();
        
        for (int i = 0; i < estudiante.size(); i++) {
            Long codigoI = estudiante.get(i);
            if(existeEstudiante(prog3,codigoI) && existeEstudiante(fisica2,codigoI) && !existeEstudiante(mate3,codigoI))
            {
                matriculados.add(codigoI);
            }
            
        }
        
    return matriculados;
    }
    public Vector<Long> matriculadosEnUnaMateria()
    {
        return estudiante;
    }
    public Vector<Long> noMatricularonFisica2()
    {
        
        Vector<Long> matriculados = new Vector();
        
        for (int i = 0; i < estudiante.size(); i++) {
            Long codigoI = estudiante.get(i);
            if(existeEstudiante(prog3,codigoI) && !existeEstudiante(fisica2,codigoI) && existeEstudiante(mate3,codigoI))
            {
                matriculados.add(codigoI);
            }
            
        }
        
    return matriculados;
    }
    
}
