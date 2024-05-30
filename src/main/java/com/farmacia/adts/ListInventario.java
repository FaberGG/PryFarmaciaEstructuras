/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farmacia.adts;

import com.farmacia.model.Medicamento;

/**
 *
 * @author PERSONAL
 */
public class ListInventario {
    private NodeMedDis  inicio;
    private NodeMedDis  fin;

    public ListInventario() {
        this.inicio = null;
        this.fin = this.inicio;
    }

      public void AgregarAlInventario(Medicamento medicamento) {
     
        NodeMedDis nuevoNodo = new NodeMedDis();
        nuevoNodo.setMedicamento(medicamento);
        if (inicio == null) {
            inicio = nuevoNodo;
            fin = nuevoNodo;
            nuevoNodo.setSiguiente(nuevoNodo);
            
        } else {
            nuevoNodo.setSiguiente(inicio);
            fin.setSiguiente(nuevoNodo);
            inicio = nuevoNodo;
        }
    }
      
       public void ImprimirLista() {
        NodeMedDis puntero = inicio;
        System.out.println();
        do {
            System.out.print(" [" + puntero.getMedicamento().toString() + "]-->");
            puntero = puntero.getSiguiente();
        } while (puntero == fin);
        System.out.println();
    }
   
       
     
    
}
