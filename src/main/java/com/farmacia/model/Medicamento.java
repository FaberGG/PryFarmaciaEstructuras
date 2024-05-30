/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farmacia.model;

public class Medicamento {

    String nombre;
    int Gramo;
    int codigo;
    String Estado;

    @Override
    public String toString() {
        return "Medicamento{" + "Nombre=" + nombre + "', Gramos='" + Gramo + "'Codigo'" + codigo + "'Estado'" + Estado
                + '}';
    }

    public Medicamento(String Nombre, int Gramo, int codigo, String Estado) {
        this.nombre = Nombre;
        this.Gramo = Gramo;
        this.codigo = codigo;
        this.Estado = Estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public int getGramo() {
        return Gramo;
    }

    public void setGramo(int Gramo) {
        this.Gramo = Gramo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int Codigo) {
        this.codigo = Codigo;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
}
