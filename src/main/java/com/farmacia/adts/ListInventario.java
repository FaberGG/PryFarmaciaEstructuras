/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farmacia.adts;

import com.farmacia.model.Medicamento;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author PERSONAL
 */
public class ListInventario {

    private NodeMedDis inicio;
    private NodeMedDis fin;

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
        if (inicio == null) {
            System.out.println("El inventario está vacío.");
            return;
        }

        NodeMedDis actual = inicio;
        do {
            Medicamento medicamento = actual.getMedicamento();
            System.out.println(medicamento.toString());
            actual = actual.getSiguiente();
        } while (actual != inicio);

    }

     public List<Medicamento> getLista() {
        List<Medicamento> lista = new ArrayList<>();
        if (inicio == null) {
            return lista;
        }
        NodeMedDis actual = inicio;
        Set<NodeMedDis> visitados = new HashSet<>();
        while (actual != null && !visitados.contains(actual)) {
            visitados.add(actual);
            lista.add(actual.getMedicamento());
            actual = actual.getSiguiente();
        }
        return lista;
    }

    public int size() {
        if (inicio == null) {
            return 0;
        }
        int count = 0;
        NodeMedDis actual = inicio;
        Set<NodeMedDis> visitados = new HashSet<>();
        while (actual != null && !visitados.contains(actual)) {
            visitados.add(actual);
            count++;
            actual = actual.getSiguiente();
        }
        return count;
    }
}
