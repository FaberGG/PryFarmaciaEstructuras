/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farmacia.model;

/**
 *
 * @author sofi_
 */
public class Medicamento {  
    String Nombre;
    int Gramos;

    @Override
    public String toString() {
        return "Medicamento{" + "Nombre=" + Nombre + ", Gramos=" + Gramos + '}';
    }

    public Medicamento(String Nombre, int Gramos) {
        this.Nombre = Nombre;
        this.Gramos = Gramos;
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
    }

    
    
    
    
}
