

package zoologicomaven;

import java.util.ArrayList;
import zoologicomaven.Vistas.VentanaPrincipal;


public class ZoologicoMaven {
    
  private static VentanaPrincipal objVentana = new VentanaPrincipal();
  
   
    public static void main(String[] args) 
    {
       
       DepartamentoLogistica.DepartamentoLogistica();
       
                                      
       
       AnimalSalvaje aniSal1 = new  AnimalSalvaje("Alto",1,"Leo","Leon",'M',12);
       AnimalSalvaje aniSal2 = new  AnimalSalvaje("Alto",2,"Molly","Leon",'F',10);
       AnimalDomestico aniDom1 = new AnimalDomestico ("Mascota", 3, "Lucky", "Gato", 'M', 1);
       AnimalDomestico aniDom2 = new AnimalDomestico ("Mascota", 4, "Mia", "Gato", 'F', 1);
       AnimalDomestico aniDom3 = new AnimalDomestico ("Adorno", 5, "Orejas", "Conejo", 'M', 2);
       DepartamentoLogistica.ingresarAnimalSalvaje(aniSal1);
       DepartamentoLogistica.ingresarAnimalSalvaje(aniSal2);
       DepartamentoLogistica.ingresarAnimalDomestico(aniDom1);
       DepartamentoLogistica.ingresarAnimalDomestico(aniDom2);
       DepartamentoLogistica.ingresarAnimalDomestico(aniDom3);
       
      
        
          MostrarVentanaPrincipal();
        
    }
    
        
    public static void MostrarVentanaPrincipal(){
        
      objVentana.setVisible(true);
    }
     public static void OcultarVentanaPrincipal(){
        
       objVentana.setVisible(false);
    }
    
    
     
    
     
     
     
}
