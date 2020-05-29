/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 * Clase contenedora: Cada uno de sus elementos con cajas parametrizadas
 * Conjunto es una estructura da datos estática
 *
 * @author MADARME
 * @param <T> puede ser cualquier tipo de objeto
 */
public class Conjunto<T>implements Comparable {

    //Estructura de datos estática
    private Caja<T>[] cajas;
    private int i = 0;

    public Conjunto() {
    }

    public Conjunto(int cantidadCajas) {
        if (cantidadCajas <= 0) {
            throw new RuntimeException("No se pueden crear el Conjunto");
        }

        this.cajas = new Caja[cantidadCajas];
    }

    public void adicionarElemento(T nuevo) throws Exception {
        if (i >= this.cajas.length) {
            throw new Exception("No hay espacio en el Conjunto");
        }

        if (this.existeElemento(nuevo)) {
            throw new Exception("No se puede realizar inserción, elemento repetido");
        }

        this.cajas[i] = new Caja(nuevo);
        this.i++;

    }

    public T get(int indice) {
        if (indice < 0 || indice >= this.getLength()) {
            throw new RuntimeException("Índice fuera de rango");
        }

        return this.cajas[indice].getObjeto();

    }

    public void setCajas(Caja<T>[] cajas) {
        this.cajas = cajas;

    }

    public int indexOf(T objBuscar) {

        for (int j = 0; j < i; j++) {

            //Sacando el estudiante de la caja:
            T x = this.cajas[j].getObjeto();

            if (x.equals(objBuscar)) {
                return j;
            }
        }

        return -1;

    }

    public void set(int indice, T nuevo) {
        if (indice < 0 || indice >= this.getLength()) {
            throw new RuntimeException("Índice fuera de rango");
        }

        this.cajas[indice].setObjeto(nuevo);

    }

    public boolean existeElemento(T nuevo){

        //Sólo estoy comparando por los estudiantes matriculados
        for (int j = 0; j < i; j++) {

            //Sacando el estudiante de la caja:            
            T x = this.cajas[j].getObjeto();

            if (x.equals(nuevo)) 
            {
                return true;
            }
        }

        return false;

    }
    
    public Caja<T>[] getCajas()
    {
    
    return this.cajas;
    }
    /**
     * para el grupo A--> Selección para el grupo C--> Inserción
     *
     *
     */
    public void ordenar() //inserccion
    {
        //:)
        Caja<T> aux;//Esta será la caja ordenada
        int pos;

        for (int itereador = 0; itereador < this.getLength(); itereador++) {
            pos = itereador;
            aux = this.cajas[itereador];
            
            Comparable c =(Comparable)this.cajas[pos - 1].getObjeto(); 
            while (pos > 0 && (c.compareTo(aux.getObjeto())) > 0) 
            {
                this.cajas[pos] = this.cajas[pos - 1];
                pos--;
            }
            this.cajas[pos] = aux;
        }

    }

    /**
     * Realiza el ordenamiento por burbuja
     */
    
    
    public void ordenarBurbuja()
    {
        Caja<T> aux;//Sera la caja ordenada
        
        
        for (int j = 0; j < cajas.length - 1; j++) 
        {

            for (int k = 0; k < cajas.length - 1; k++) 
            {
                Comparable c =(Comparable) cajas[k].getObjeto();
                if (c.compareTo(cajas[k + 1].getObjeto()) > 0)
                {
                    aux = cajas[k];
                    cajas[k] = cajas[k + 1];
                    cajas[k + 1] = aux;
                }

            }
        }
    }

    /**
     * Elimina un elemento del conjunto y compacta
     *
     * @param objBorrado es el objeto que deseo eliminar
     * @throws java.lang.Exception
     */
    public void remover(T objBorrado) throws Exception 
    {
        if (existeElemento(objBorrado)==false) 
            throw new Exception("No existe el elemento que quiere borrar");
        

        int posicionDelObjetoEliminar = this.indexOf(objBorrado);

        Caja<T> cajaAux[];
        cajaAux = new Caja[this.cajas.length - 1];

        for (int j = 0; j < cajaAux.length; j++) 
        {

            if (posicionDelObjetoEliminar == j) 
            {
                cajaAux[j] = cajas[j + 1];

                posicionDelObjetoEliminar = -1; 
            }

            if (posicionDelObjetoEliminar == -1)
            {
                cajaAux[j] = cajas[j + 1];      

            }
            if (posicionDelObjetoEliminar > -1)
            {
                cajaAux[j] = cajas[j];             
            }

        }
        this.setCapacidad(cajaAux.length);
        this.setCajas(cajaAux);
        
        
        System.out.println("Se eliminó el elemento " + objBorrado);
    }

    /**
     * El método adiciona todos los elementos de nuevo en el conjunto
     * original(this) y el nuevo queda vacío. En este proceso no se toma en
     * cuenta los datos repetidos Ejemplo: conjunto1=<1,2,3,5,6> y
     * conjunto2=<9,1,8>
     * conjunto1.concatenar(conjunto2) da como resultado:
     * conjunto1=<1,2,3,5,6,9,1,8> y conjunto2=null
     *
     * @param nuevo el objeto conjunto a ser colocado en el conjunto original
     */
    public void concatenar(Conjunto<T> nuevo) 
    {
        
        
        int cantidadCajasNuevo=nuevo.getCajas().length;
        
        Caja<T> aux[];
        Caja<T> cajaNueva[];
        
        cajaNueva=nuevo.getCajas();
        
        aux=new Caja[this.cajas.length+cantidadCajasNuevo];
        int posicionCajaNueva=0;
        for (int j = 0; j < aux.length; j++) 
        {
            if(j<this.cajas.length)
            {
                aux[j]=this.cajas[j];
            }else
            {
                
                aux[j]=cajaNueva[posicionCajaNueva];
                posicionCajaNueva++;
            }
        }
        
            this.setCajas(aux);
            nuevo.setCajas(null);
            nuevo.i=0;
    }

    /**
     * El método adiciona todos los elementos de nuevo en el conjunto
     * original(this) y el nuevo queda vacío. En este proceso SI toma en cuenta
     * los datos repetidos Ejemplo: conjunto1=<1,2,1,5,6> y conjunto2=<9,1,8>
     * conjunto1.concatenar(conjunto2) da como resultado:
     * conjunto1=<1,2,3,5,6,9,8> y conjunto2=null
     *
     * @param c2
     * @param nuevo el objeto conjunto a ser colocado en el conjunto original
     */
   
   
    
    public void concatenarRestrictivo(Conjunto<T> nuevo) throws Exception 
    {       
        Caja<T> []aux; //Será el Arreglo con cajas concatenadas
        Caja<T> []nuevos; // es el Arreglo con cajas que recibo (nuevo)
 
        nuevos=nuevo.getCajas();
        
        int cantidadRepetidos=0;
        int total=this.cajas.length+nuevos.length;
        String repetidos="";
        
        for (int j = 0; j < cajas.length ; j++)
        {  
           
            for (int k = 0; k < nuevos.length; k++) 
            {   
                Comparable c = (Comparable)cajas[j].getObjeto();
                if(c.compareTo(nuevos[k].getObjeto())==0)
                {
                    
                    repetidos+=cajas[j].getObjeto().toString()+"\n";
                    
                    if(nuevo.existeElemento(nuevos[k].getObjeto()))
                    {
                        cantidadRepetidos++;
                        nuevo.remover(nuevos[k].getObjeto()); 
                    }                   
                }
            }
        }
        
        nuevos=nuevo.getCajas();
        
        System.out.println("Cantidad de elementos repetidos "+cantidadRepetidos);
        System.out.println("Elementos repetidos=\n"+repetidos);  
        
        aux=new Caja[(total)-cantidadRepetidos];
        int posicionCajaNueva=0;
        for (int j = 0; j < aux.length; j++) 
        {
            
            if(j<this.cajas.length)
            {              
                aux[j]=this.cajas[j];               
            }
            else
            {                
                aux[j]=nuevos[posicionCajaNueva];
                
                posicionCajaNueva++;              
            }
        }    
         this.setCajas(aux);

    }
    
    
     public Conjunto<T> getDiferencia(Conjunto <T> c2) throws Exception
    {
      
        
        
        Conjunto <T> c;
        Caja <T>[] aux;
        
    
        int tamanio=0;
        
        
        
           
            
                for (int j = 0; j <this.cajas.length; j++)
                {
                   if(c2.existeElemento(cajas[j].getObjeto()))
                   {
                       tamanio++;
                   
                   }
                  
                }
                
                
            System.out.println(tamanio);
            
            c=new Conjunto(this.cajas.length-tamanio);
            int iterador=0;

            for (int j = 0; j < this.cajas.length; j++) 
            {
                
                for (int k = 0; k < c2.cajas.length; k++) 
                {
                    if(!(this.cajas[j].equals(c2.cajas[k])))
                    {   
                        if(j<c.cajas.length){
                        if(c.existeElemento(cajas[j].getObjeto())==false)
                        c.adicionarElemento(cajas[j].getObjeto());
                        }
                    }
                }
                 
            }
            
            
            
        
       return c;
    }

      
        
    
    
   
    public void removeAll() {
        this.cajas = null;
        this.i = 0;
    }

    @Override
    public String toString() {
        String msg = "CONJUNTO" + "\n";

        for (Caja c : this.cajas) {
            msg += c.getObjeto().toString() + ", ";
        }

        return msg ;
    }
    
    
    
    

                          


    
    
    
    /**
     * Obtiene la cantidad de elementos almacenados
     *
     * @return retorna un entero con la cantidad de elementos
     */
    public int getCapacidad() {
        return this.i;
    }
    
    public void setCapacidad(int i){
        this.i=i;
    }
    /**
     * Obtiene el tamaño máximo de cajas dentro del Conjunto
     *
     * @return int con la cantidad de cajas
     */
    public int getLength()
    {
        return this.cajas.length;
    }

    @Override
    public int compareTo(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
