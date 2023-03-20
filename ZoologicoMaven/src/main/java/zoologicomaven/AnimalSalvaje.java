
package zoologicomaven;

public class AnimalSalvaje extends Animal  implements ComportaminetoAnimal

{

    private String nivelPeligrosidad;
    private boolean alimentado=false;
    private boolean descansando=false;
    
     public AnimalSalvaje()
     {
         
     }

    public AnimalSalvaje(String nivelPeligrosidad, int codigo, String nombre, String especie, char sexo, int edad) {
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

    public boolean isDescansando() {
        return descansando;
    }

    public void setDescansando(boolean dormido) {
        this.descansando = dormido;
    }

    public boolean isAlimentado() {
        return alimentado;
    }

    public void setAlimentado(boolean alimentado) {
        this.alimentado = alimentado;
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
