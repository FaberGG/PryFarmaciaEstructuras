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

public class ListMedDisponibles {

    private NodeMedDis inicio;
    private NodeMedDis fin;

    public ListMedDisponibles() {
        this.inicio = null;
        this.fin = null;
    }

    public void AgregarMedicamento(Medicamento medicamento) {
        NodeMedDis nuevoNodo = new NodeMedDis();
        nuevoNodo.setMedicamento(medicamento);
        if (inicio == null) {
            inicio = nuevoNodo;
            fin = nuevoNodo;
            nuevoNodo.setSiguiente(nuevoNodo);
        } else {
            nuevoNodo.setSiguiente(inicio);
            fin.siguiente = nuevoNodo;
            nuevoNodo.anterior = fin;
            fin = nuevoNodo;
        }
    }

    public String EliminarMedicamento(int dato) {

        NodeMedDis actual = BuscarMedicamento(dato);
        if (actual == null) {
            if (MedicamentoVencido(dato) == true) {

                return "EL MEDICAMENTO SE ENCUENTRA VENCIDO";
            } else {
                return "EL MEDICAMENTO SE ENCUENTRA AGOTADO ";
            }

        }
        if (actual.anterior != null) {
            actual.anterior.siguiente = actual.siguiente;
        } else {
            inicio = actual.siguiente;  // Eliminar cabeza
        }

        if (actual.siguiente != null) {
            actual.siguiente.anterior = actual.anterior;
        } else {
            fin = actual.anterior;  // Eliminar cola
        }
        return "ELEMENTO AGREGADO AL CARRRITO";
    }

    public NodeMedDis BuscarMedicamento(int codigobuscar) {

        NodeMedDis actual = inicio;
        while (actual != null) {
            if (codigobuscar == actual.getMedicamento().getCodigo()) {
                return actual;
            }
            actual = actual.siguiente;
        }

        return null;

    }

    public Medicamento buscarMedicamentoPorCodigo(int codigoBuscar) {
        NodeMedDis actual = inicio;
        while (actual != null) {
            if (codigoBuscar == actual.getMedicamento().getCodigo()) {
                return actual.getMedicamento();
            }
            actual = actual.getSiguiente();
        }
        return null; // Medicamento no encontrado
    }

    //CODIGO DE CADUCIDAD-------------- 1111 
    public boolean MedicamentoVencido(int codigo) {
        NodeMedDis actual = inicio;
        while (actual != null) {
            if (actual.getMedicamento().getCodigo() == codigo && codigo == 1111) {
                if (actual.anterior != null) {
                    actual.anterior.siguiente = actual.siguiente;
                } else {
                    inicio = actual.siguiente; // Eliminar cabeza
                }
                if (actual.siguiente != null) {
                    actual.siguiente.anterior = actual.anterior;
                } else {
                    fin = actual.anterior;  // Eliminar cola
                }
                return true;
                //EL MEDICAMENTO ESTÁ VENCIDO Y SE ELIMINA POR ESO
            }
        }
        return false;// EL MEDICAMENTO NO ESTÁ VENCIDO 
    }

    public List<Medicamento> getLista() {
        List<Medicamento> lista = new ArrayList<>();
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
