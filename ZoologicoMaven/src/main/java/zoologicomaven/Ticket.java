/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoologicomaven;

/**
 *
 * @author Deyner Tenorio
 */
public class Ticket{
    private int id=0;
    private double valor;

    public Ticket(double valor)
    {
        this.valor = valor;
        
     }
    public Ticket()
    {
               
     }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
  
    
}
