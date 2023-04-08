
package zoologicomaven;

import zoologicomaven.Interfaces.ComportaminetoAnimal;

public class AnimalDomestico extends Animal implements ComportaminetoAnimal
{
    private String uso;
    private boolean alimentado;
    private boolean descansando;
    
    public AnimalDomestico(String uso, int codigo, String nombre, String especie, char sexo, int edad) {
        super(codigo, nombre, especie, sexo, edad);
        this.uso = uso;
  
    }

    public AnimalDomestico()
    {
        
    }
   
    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public boolean isAlimentado() {
        return alimentado;
    }

    public void setAlimentado(boolean alimentado) {
        this.alimentado = alimentado;
    }

    public boolean isDescansando() {
        return descansando;
    }

    public void setDescansando(boolean descansando) {
        this.descansando = descansando;
    }

    
    
    
    @Override
    public void Comer(boolean alimentar) 
    {
       
       alimentado=alimentar;
            
    }

    @Override
    public void Descansar(boolean descansar) 
    {
        descansando=descansar;
    }   
      
    
    
}
