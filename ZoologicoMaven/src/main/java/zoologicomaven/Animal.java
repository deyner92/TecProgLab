/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoologicomaven;

/**
 *
 * @author Deyner Tenorio
 */
public class Animal {
    private int codigo;
    private String nombre;
    private String especie;
    private char sexo;
    private int edad;

    public Animal(int codigo, String nombre, String especie, char sexo, int edad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.especie = especie;
        this.sexo = sexo;
        this.edad = edad;
    }


    
    public Animal(){
        
    }

    
   public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
    

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override//objet
    public String toString (){
        
        return  "Animal {"+"codigo="+codigo+", nombre="+nombre+", especie="+especie+", sexo="+sexo+", edad="+edad+"}";
    }
}
