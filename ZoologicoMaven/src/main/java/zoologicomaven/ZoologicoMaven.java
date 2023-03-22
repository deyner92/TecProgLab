

package zoologicomaven;

public class ZoologicoMaven {
    
    private static VentanaPrincipal objVentana = new VentanaPrincipal();

    public static void main(String[] args) 
    {
         
        MostrarVentanaPrincipal();
    }
    
    
    public static void MostrarVentanaPrincipal(){
        
        objVentana.setVisible(true);
    }
     public static void OcultarVentanaPrincipal(){
        
        objVentana.setVisible(false);
    }
}
