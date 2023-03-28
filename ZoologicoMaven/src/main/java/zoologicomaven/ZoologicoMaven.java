

package zoologicomaven;

import java.util.ArrayList;
import zoologicomaven.Vistas.VentanaPrincipal;


public class ZoologicoMaven {
    
  private static VentanaPrincipal objVentana = new VentanaPrincipal();
  private static  DepartamentoLogistica departamentoLogistica;
   
    public static void main(String[] args) 
    {
       departamentoLogistica = new DepartamentoLogistica();
       departamentoLogistica.DepartamentoLogistica();
       
                                      
       
       AnimalSalvaje aniSal1 = new  AnimalSalvaje("alto",1,"Leo","Leon",'M',12);
       AnimalSalvaje aniSal2 = new  AnimalSalvaje("alto",2,"Molly","Leon",'F',10);
       AnimalDomestico aniDom1 = new AnimalDomestico ("hogar", 3, "Lucky", "Gato", 'M', 1);
       AnimalDomestico aniDom2 = new AnimalDomestico ("hogar", 4, "Mia", "Gato", 'F', 1);
        
       departamentoLogistica.ingresarAnimalSalvaje(aniSal1);
       departamentoLogistica.ingresarAnimalSalvaje(aniSal2);
       departamentoLogistica.ingresarAnimalDomestico(aniDom1);
        departamentoLogistica.ingresarAnimalDomestico(aniDom2);
      
       MostrarAnimalSalvaje();
       MostrarAnimalDomestico();
      
        
             MostrarVentanaPrincipal();
        
    }
    
        
    public static void MostrarVentanaPrincipal(){
        
      objVentana.setVisible(true);
    }
     public static void OcultarVentanaPrincipal(){
        
       objVentana.setVisible(false);
    }
    
    
     
    public static void MostrarAnimalSalvaje(){
    int i;
    ArrayList <AnimalSalvaje>  lista =new ArrayList();
    lista=departamentoLogistica.getArrayAnimalSalvaje();
    
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
     public static void MostrarAnimalDomestico(){
    int i;
    ArrayList <AnimalDomestico>  lista =new ArrayList();
    lista=departamentoLogistica.getArrayAnimalDomestico();
    
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
  
     
     
}
