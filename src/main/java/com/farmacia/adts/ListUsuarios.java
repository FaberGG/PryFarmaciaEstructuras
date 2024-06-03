/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farmacia.adts;

import com.farmacia.model.Usuario;

/**
 *
 * @author PERSONAL
 */
public class ListUsuarios {

    private NodoUsuario cabeza;

    public ListUsuarios() {
        this.cabeza = null;
    }

    public void agregarUsuario(Usuario usuario) {
        NodoUsuario nuevoNodo = new NodoUsuario(usuario);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoUsuario actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    public boolean eliminarCuenta(String documento) {
        if (cabeza == null) {
            return false;
        }
        if (cabeza.usuario.getDocumento().equals(documento)) {
            cabeza = cabeza.siguiente;
            return true;
        }
        NodoUsuario actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.usuario.getDocumento().equals(documento)) {
            actual = actual.siguiente;
        }
        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            return true;
        }
        return false;
    }

    public Usuario buscarUsuario(String documento) {
        NodoUsuario actual = cabeza;
        while (actual != null) {
            if (actual.usuario.getDocumento().equals(documento)) {
                return actual.usuario;
            }
            actual = actual.siguiente;
        }
        return null;
    }

}
