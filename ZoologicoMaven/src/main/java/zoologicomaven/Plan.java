/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoologicomaven;

/**
 *
 * @author Deyner Tenorio
 */
public class Plan extends Ticket
{

    private String tipoPlan;
    private int cantAdultos;
    private int cantNinos;
    private int descuento;

    public Plan() 
    {
       
    }

    public Plan(String tipoPlan, int cantAdultos, int cantNinos, int descuento, float valor,int id) {
        super(valor,id);
        this.tipoPlan = tipoPlan;
        this.cantAdultos = cantAdultos;
        this.cantNinos = cantNinos;
        this.descuento = descuento;
    }

    public String getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    public int getCantAdultos() {
        return cantAdultos;
    }

    public void setCantAdultos(int cantAdultos) {
        this.cantAdultos = cantAdultos;
    }

    public int getCantNinos() {
        return cantNinos;
    }

    public void setCantNinos(int cantNinos) {
        this.cantNinos = cantNinos;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Plan{" + "tipoPlan=" + tipoPlan + ", cantAdultos=" + cantAdultos + ", cantNinos=" + cantNinos + ", descuento=" + descuento + '}';
    }
    
    
    
    
}
