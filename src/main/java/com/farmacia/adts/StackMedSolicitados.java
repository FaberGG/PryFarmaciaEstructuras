
package com.farmacia.adts;

import com.farmacia.model.Medicamento;
import java.util.EmptyStackException;

/**
 *
 * @author Yineidy
 */
public class StackMedSolicitados {
    // Relación de composición

    private NodeMedDis tope;

    public StackMedSolicitados() {
        this.tope = null;
    }

    // Relación de composición:
    public void agregarMedicamento(Medicamento medicamento) {
        NodeMedDis nuevoNodo = new NodeMedDis(medicamento);
        nuevoNodo.siguiente = tope;
        tope = nuevoNodo;
    }

    public Medicamento vaciarMedicamento() {
        if (tope == null) {
            throw new EmptyStackException();
        }
        Medicamento med = tope.med;
        tope = tope.siguiente;
        return med;
    }

    public void vaciarPilaCompleta() {
        tope = null;
    }

    public boolean estaVacia() {
        return tope == null;
    }
}