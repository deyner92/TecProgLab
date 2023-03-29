/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoologicomaven;

import java.util.ArrayList;

public class DepartamentoLogistica
{
    
    private static ArrayList<AnimalSalvaje> arrayAnimalSalvaje;
    private static ArrayList<AnimalDomestico> arrayAnimalDomestico;
    
    public static void DepartamentoLogistica(){
        
         arrayAnimalSalvaje = new ArrayList<>();
        arrayAnimalDomestico = new ArrayList<>();
            
    }

    public static ArrayList<AnimalSalvaje> getArrayAnimalSalvaje() {
        return arrayAnimalSalvaje;
    }

    public static ArrayList<AnimalDomestico> getArrayAnimalDomestico() {
        return arrayAnimalDomestico;
    }



    
    public static void  ingresarAnimalSalvaje (AnimalSalvaje aniSal) //no sabemos si es estatico
        {
           
            arrayAnimalSalvaje.add(aniSal);
            
        }
    
   //  public AnimalesDomesticos(String uso, int codigo, String nombre, String especie, char sexo, int edad) {
    
    public static void ingresarAnimalDomestico (AnimalDomestico aniDom)
        {
            arrayAnimalDomestico.add(aniDom);
        }

    public static void MostrarAnimalDomestico(){
    int i;
    ArrayList <AnimalDomestico>  lista =new ArrayList();
    lista=getArrayAnimalDomestico();
    
    for (i=0; i<lista.size();i++)
    {
        
        System.out.println(lista.get(i).getCodigo());
        System.out.println(lista.get(i).getNombre());
        System.out.println(lista.get(i).getUso());
        System.out.println(lista.get(i).getEspecie());
        System.out.println(lista.get(i).getSexo());
        System.out.println(lista.get(i).getEdad());
        System.out.println("---------------------");
        
         }
                
        } 
    public static void MostrarAnimalSalvaje(){
    int i;
    ArrayList <AnimalSalvaje>  lista =new ArrayList();
    lista=DepartamentoLogistica.getArrayAnimalSalvaje();
    
    for (i=0; i<lista.size();i++)
    {
        System.out.println(lista.get(i).getCodigo());
        System.out.println(lista.get(i).getNombre());
        System.out.println(lista.get(i).getEspecie());
        System.out.println(lista.get(i).getNivelPeligrosidad());
        System.out.println(lista.get(i).getSexo());
        System.out.println(lista.get(i).getEdad());
        System.out.println("---------------------");
        
         }
                
        } 
  

}