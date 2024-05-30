
package com.farmacia.adts;

import com.farmacia.model.Usuario;

/**
 *
 * @author PERSONAL
 */
public class QueueUsuarios {
    // atributos NodoUsuario
    private NodoUsuario frente;
    private NodoUsuario fin;

    public QueueUsuarios() {
        this.frente = null;
        this.fin = null;
    }

    public void encolar(Usuario u) {
        NodoUsuario nuevoNodo = new NodoUsuario(u);
        if (fin != null) {
            fin.siguiente = nuevoNodo;
        }
        fin = nuevoNodo;
        if (frente == null) {
            frente = fin;
        }
    }

    public Usuario desencolar() {
        if (frente == null) {
            return null;
        }
        Usuario usuario = frente.usuario;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }
        return usuario;
    }

}
