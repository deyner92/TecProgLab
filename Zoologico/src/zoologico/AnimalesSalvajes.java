/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zoologico;

/**
 *
 * @author Deyner Tenorio
 */
public class AnimalesSalvajes extends Animal 

{

    private String nivelPeligrosidad;
   

     public AnimalesSalvajes()
     {
         
     }

    public AnimalesSalvajes(String nivelPeligrosidad, int codigo, String nombre, String especie, char sexo, int edad) {
        super(codigo, nombre, especie, sexo, edad);
        this.nivelPeligrosidad = nivelPeligrosidad;
    }
    
           

    public String getNivelPeligrosidad() 
    
    {
        return nivelPeligrosidad;
    }

    public void setNivelPeligrosidad(String nivelPeligrosidad) 
    
    {
        this.nivelPeligrosidad = nivelPeligrosidad;
    }

    
    
}
