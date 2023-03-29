

package zoologicomaven;

import java.util.ArrayList;
import zoologicomaven.Vistas.VentanaPrincipal;


public class ZoologicoMaven {
    
  private static VentanaPrincipal objVentana = new VentanaPrincipal();
  
   
    public static void main(String[] args) 
    {
       
       DepartamentoLogistica.DepartamentoLogistica();
       
                                      
       
       AnimalSalvaje aniSal1 = new  AnimalSalvaje("alto",1,"Leo","Leon",'M',12);
       AnimalSalvaje aniSal2 = new  AnimalSalvaje("alto",2,"Molly","Leon",'F',10);
       AnimalDomestico aniDom1 = new AnimalDomestico ("hogar", 3, "Lucky", "Gato", 'M', 1);
       AnimalDomestico aniDom2 = new AnimalDomestico ("hogar", 4, "Mia", "Gato", 'F', 1);
        
       DepartamentoLogistica.ingresarAnimalSalvaje(aniSal1);
       DepartamentoLogistica.ingresarAnimalSalvaje(aniSal2);
       DepartamentoLogistica.ingresarAnimalDomestico(aniDom1);
        DepartamentoLogistica.ingresarAnimalDomestico(aniDom2);
      
       //DepartamentoLogistica.MostrarAnimalSalvaje();
       //DepartamentoLogistica.MostrarAnimalDomestico();
      
        
          MostrarVentanaPrincipal();
        
    }
    
        
    public static void MostrarVentanaPrincipal(){
        
      objVentana.setVisible(true);
    }
     public static void OcultarVentanaPrincipal(){
        
       objVentana.setVisible(false);
    }
    
    
     
    
     
     
     
}
