package com.farmacia.model;

import com.farmacia.adts.QueueUsuarios;
import com.farmacia.adts.StackMedSolicitados;

public class Usuario {

    private String nombre;
    private String documento;
    private int edad;
    private boolean discapacidad;
    // Relación de asociación
    private StackMedSolicitados medicamentosSolicitados;

    public Usuario(String nombre, String documento, int edad, boolean discapacidad) {
        this.nombre = nombre;
        this.documento = documento;
        this.edad = edad;
        this.discapacidad = discapacidad;
        this.medicamentosSolicitados = new StackMedSolicitados();
    }

    public boolean isPrioridad() {
        return (edad >= 80 || discapacidad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public StackMedSolicitados getMedicamentosSolicitados() {
        return medicamentosSolicitados;
    }

    public void setMedicamentosSolicitados(StackMedSolicitados medicamentosSolicitados) {
        this.medicamentosSolicitados = medicamentosSolicitados;
    }

    public void encolarEnColaUsuarios(QueueUsuarios cola) {
        cola.encolar(this);
    }

    public Usuario desencolarDeColaUsuarios(QueueUsuarios cola) {
        return cola.desencolar();
    }
}
