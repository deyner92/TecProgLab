
package zoologicomaven;


import java.time.LocalDateTime;

public class Vehiculo extends Parqueadero
{
   private String placa;
   private LocalDateTime  horaIngreso;
   

    public Vehiculo() {
    }

    public Vehiculo(String placa, LocalDateTime  horaIngreso,  String piso, String puesto) {
        super(piso, puesto);
        this.placa = placa;
        this.horaIngreso = horaIngreso;
        
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public LocalDateTime  getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(LocalDateTime  horaIngreso) {
        this.horaIngreso = horaIngreso;
    }


   
    
   
   
}

