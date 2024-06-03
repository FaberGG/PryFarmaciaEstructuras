package com.farmacia.controller;

import com.farmacia.adts.ListInventario;
import com.farmacia.adts.ListMedDisponibles;
import com.farmacia.adts.ListUsuarios;
import com.farmacia.adts.QueueUsuarios;
import com.farmacia.model.Medicamento;
import com.farmacia.model.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class FarmaciaController {

    private ListInventario inventario;
    private ListMedDisponibles medDisponibles;
    private ListUsuarios usuarios;
    private QueueUsuarios colaUsuarios;

    public FarmaciaController() {
        this.inventario = new ListInventario();
        this.medDisponibles = new ListMedDisponibles();
        this.usuarios = new ListUsuarios();
        this.colaUsuarios = new QueueUsuarios();
        cargarDatos();
    }

    // GSON
    public void guardarDatos() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter("farmacia_datos.json")) {
            // Crear un contenedor de datos
            DatosFarmacia datos = new DatosFarmacia(inventario, medDisponibles, usuarios, colaUsuarios);
            System.out.println("Tamaño del inventario: " + inventario.size());
            gson.toJson(datos, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarDatos() {
        Gson gson = new Gson();

        try (FileReader reader = new FileReader("farmacia_datos.json")) {
            // Definir el tipo del contenedor de datos
            Type tipoDatosFarmacia = new TypeToken<DatosFarmacia>() {
            }.getType();
            DatosFarmacia datos = gson.fromJson(reader, tipoDatosFarmacia);

            // Restaurar los datos a partir del contenedor
            this.inventario = datos.getInventario();
            this.medDisponibles = datos.getMedDisponibles();
            this.usuarios = datos.getUsuarios();
            this.colaUsuarios = datos.getColaUsuarios();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Clase interna para contener todos los datos
    private class DatosFarmacia {

        private List<Medicamento> inventarioTemporal;
        private List<Medicamento> medDisponiblesTemporal;
        private ListUsuarios usuarios;
        private QueueUsuarios colaUsuarios;

        public DatosFarmacia(ListInventario inventario, ListMedDisponibles medDisponibles, ListUsuarios usuarios, QueueUsuarios colaUsuarios) {
            this.inventarioTemporal = inventario.getLista();
            this.medDisponiblesTemporal = medDisponibles.getLista();
            this.usuarios = usuarios;
            this.colaUsuarios = colaUsuarios;
        }

        public ListInventario getInventario() {
            ListInventario inventario = new ListInventario();
            for (Medicamento medicamento : inventarioTemporal) {
                inventario.AgregarAlInventario(medicamento);
            }
            return inventario;
        }

        public ListMedDisponibles getMedDisponibles() {
            ListMedDisponibles medDisponibles = new ListMedDisponibles();
            for (Medicamento medicamento : medDisponiblesTemporal) {
                medDisponibles.AgregarMedicamento(medicamento);
            }
            return medDisponibles;
        }

        public ListUsuarios getUsuarios() {
            return usuarios;
        }

        public QueueUsuarios getColaUsuarios() {
            return colaUsuarios;
        }
    }

    public Usuario buscarUsuario(String documento) {
        return usuarios.buscarUsuario(documento);
    }

    // Gestionar inventario
    public void agregarAlInventario(Medicamento medicamento) {
        inventario.AgregarAlInventario(medicamento);
    }

    public void imprimirInventario() {
        inventario.ImprimirLista();
    }

    // Gestionar medicamentos disponibles
    public Medicamento buscarMedicamento(int codigo) {
        return medDisponibles.buscarMedicamentoPorCodigo(codigo);
    }

    public void agregarMedicamentoDisponible(Medicamento medicamento) {
        medDisponibles.AgregarMedicamento(medicamento);
    }

    public String eliminarMedicamentoDisponible(int codigo) {
        return medDisponibles.EliminarMedicamento(codigo);
    }

    // Gestionar usuarios
    public void registrarUsuario(Usuario usuario) {
        usuarios.agregarUsuario(usuario);
    }

    public boolean eliminarCuentaUsuario(String documento) {
        return usuarios.eliminarCuenta(documento);
    }

    // Gestionar cola de usuarios
    public void encolarUsuario(Usuario usuario) {
        colaUsuarios.encolar(usuario);
    }

    public Usuario desencolarUsuario() {
        return colaUsuarios.desencolar();
    }

    public ListInventario getInventario() {
        return inventario;
    }

    public ListUsuarios getUsuarios() {
        return usuarios;
    }

}
