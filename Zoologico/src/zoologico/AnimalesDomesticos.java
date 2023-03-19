/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zoologico;

/**
 *
 * @author Deyner Tenorio
 */
public class AnimalesDomesticos extends Animal{
    private String uso;

    public AnimalesDomesticos(String uso, int codigo, String nombre, String especie, char sexo, int edad) {
        super(codigo, nombre, especie, sexo, edad);
        this.uso = uso;
    }

   
    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }
    
    
}
