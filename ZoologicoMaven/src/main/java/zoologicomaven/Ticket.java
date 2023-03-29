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
    private float valor;

    public Ticket(float valor,int id)
    {
        this.valor = valor;
        this.id= id;
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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
  
    
}
