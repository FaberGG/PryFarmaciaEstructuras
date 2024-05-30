/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farmacia.model;
import com.farmacia.adts.StackMedSolicitados;
/**
 *
 * @author PERSONAL
 */
public class Usuario {

    private final String nombre;
    private final String documento;
    private final int edad;
    private final boolean discapacidad;
    private StackMedSolicitados medicamentos;

    public Usuario(String nombre, String documento, int edad, boolean discapacidad) {
        this.nombre = nombre;
        this.documento = documento;
        this.edad = edad;
        this.discapacidad = discapacidad;
    }
    
    public boolean isPrioridad(){
        return ( edad >= 80 || discapacidad);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public StackMedSolicitados getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(StackMedSolicitados medicamentos) {
        this.medicamentos = medicamentos;
    }
    
    
}
