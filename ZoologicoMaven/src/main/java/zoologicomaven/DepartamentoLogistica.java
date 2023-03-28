/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoologicomaven;

import java.util.ArrayList;

public class DepartamentoLogistica
{

    private ArrayList<AnimalSalvaje> arrayAnimalSalvaje;
    private ArrayList<AnimalDomestico> arrayAnimalDomestico;
    
      public void DepartamentoLogistica(){
        
         arrayAnimalSalvaje = new ArrayList<AnimalSalvaje>();
        arrayAnimalDomestico = new ArrayList<AnimalDomestico>();
            
    }

    public ArrayList<AnimalSalvaje> getArrayAnimalSalvaje() {
        return arrayAnimalSalvaje;
    }

    public ArrayList<AnimalDomestico> getArrayAnimalDomestico() {
        return arrayAnimalDomestico;
    }



    
    public void  ingresarAnimalSalvaje (AnimalSalvaje aniSal) //no sabemos si es estatico
        {
           
            arrayAnimalSalvaje.add(aniSal);
            
        }
    
   //  public AnimalesDomesticos(String uso, int codigo, String nombre, String especie, char sexo, int edad) {
    
    public  void ingresarAnimalDomestico (AnimalDomestico aniDom)
        {
            arrayAnimalDomestico.add(aniDom);
        }


}