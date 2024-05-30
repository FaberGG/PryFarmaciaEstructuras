

package com.farmacia.model;
public class Medicamento {  
    String Nombre;
    int Gramos;
    int codigo;

    @Override
    public String toString() {
        return "Medicamento{" + "Nombre=" + Nombre + ", Gramos=" + Gramos + ", codigo=" + codigo + '}';
    }
   

   

    public Medicamento(String Nombre, int Gramos, int codigo) {
        this.Nombre = Nombre;
        this.Gramos = Gramos;
        this.codigo=codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getGramos() {
        return Gramos;
    }

    public void setGramos(int Gramos) {
        this.Gramos = Gramos;


    public int getCodigo() {
        return codigo;
    }
      
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
 }
  
    
    
   
    

