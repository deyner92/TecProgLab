
package zoologicomaven;

import java.util.Calendar;


public class Vehiculo extends Parqueadero
{
   private String placa;
   private Calendar horaIngreso;
   private Calendar horaSalida;

    public Vehiculo() {
    }

    public Vehiculo(String placa, Calendar horaIngreso, Calendar horaSalida, String piso, String puesto) {
        super(piso, puesto);
        this.placa = placa;
        this.horaIngreso = horaIngreso;
        this.horaSalida = horaSalida;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Calendar getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(Calendar horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public Calendar getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Calendar horaSalida) {
        this.horaSalida = horaSalida;
    }
   
    
   
   
}

