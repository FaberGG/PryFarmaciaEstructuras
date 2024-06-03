/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farmacia.adts;
import com.farmacia.model.Medicamento;

/**
 *
 * @author sofi_
 */
public class NodeMedDis {
  
    NodeMedDis anterior;
    NodeMedDis siguiente;

    Medicamento medicamento;

    
      public NodeMedDis() {
        this.anterior = null;
        this.siguiente = null;
 }

    public NodeMedDis(Medicamento medicamento) {
    this.anterior = null;
    this.siguiente = null;
    
    }
      
    

    public NodeMedDis getAnterior() {
        return anterior;
    }

    public void setAnterior(NodeMedDis anterior) {
        this.anterior = anterior;
    }

    public NodeMedDis getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodeMedDis siguiente) {
        this.siguiente = siguiente;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

}
