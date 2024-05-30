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
public class NodoUsuario {
    Usuario usuario;
    NodoUsuario siguiente;

    NodoUsuario(Usuario usuario) {
        this.usuario = usuario;
        this.siguiente = null;
    }
}
