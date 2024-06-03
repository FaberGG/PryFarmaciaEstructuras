package com.farmacia.view;

import com.farmacia.controller.FarmaciaController;
import com.farmacia.model.Medicamento;
import com.farmacia.model.Usuario;
import java.util.Scanner;

public class FarmaciaView {

    private final FarmaciaController farmaciaController;
    private final Scanner scanner;

    public FarmaciaView(FarmaciaController farmaciaController) {
        this.farmaciaController = farmaciaController;
        this.scanner = new Scanner(System.in);

    }

    public void mostrarMenuPrincipal() {
        boolean salir = false;
        while (!salir) {
            limpiarConsola();
            farmaciaController.guardarDatos();

            System.out.println("1. Ingreso como Administrador");
            System.out.println("2. Ingreso como Usuario");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer
            switch (opcion) {
                case 1 ->
                    mostrarMenuAdministrador();
                case 2 ->
                    mostrarMenuUsuario();
                case 3 -> {
                    salir = true;
                }
                default ->
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    private void mostrarMenuAdministrador() {
        boolean salir = false;
        while (!salir) {
            limpiarConsola();
            System.out.println("1. Agregar Medicamento");
            System.out.println("2. Registrar Usuario");
            System.out.println("3. Eliminar Usuario");
            System.out.println("4. Guardar datos");
            System.out.println("5. Volver");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            limpiarConsola();

            switch (opcion) {
                case 1 ->
                    agregarMedicamento();

                case 2 ->
                    registrarUsuario();
                case 3 ->
                    eliminarUsuario();
                case 4 -> {
                    farmaciaController.guardarDatos();
                }
                case 5 ->
                    salir = true;
                default ->
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    private void mostrarMenuUsuario() {
        boolean salir = false;
        while (!salir) {
            limpiarConsola();
            System.out.println("1.Registrarse");
            System.out.println("2. Comprar Medicamentos ");
            System.out.println("3. Entrar a la fila");
            System.out.println("4. Volver");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer
            limpiarConsola();

            switch (opcion) {
                case 1 ->
                    registrarUsuario();
                case 2 ->
                    comprarMedicamento();
                case 3 -> {
                    EntrarALaFila();

                }
                case 4 ->
                    salir = true;
                default ->
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    private void limpiarConsola() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void agregarMedicamento() {
        System.out.println("Ingresa el Nombre del Medicamento");
        String nombre = scanner.nextLine();
        System.out.println("Ingresa los gramos del medicamento");
        int gramos = scanner.nextInt();
        System.out.println("Ingresa el codigo del medicamento ");
        int codigo = scanner.nextInt();

        Medicamento AgregarListDouble = new Medicamento(nombre, gramos, codigo);

        // crear el medicamento en la lista dispomnibles
        farmaciaController.agregarMedicamentoDisponible(AgregarListDouble);
        farmaciaController.agregarAlInventario(AgregarListDouble);
    }

    private void registrarUsuario() {
        System.out.println("Ingresa el Nombre del Usuario");
        String nombre = scanner.nextLine();
        System.out.println("Ingresa el documento de identidad ");
        String documento = scanner.nextLine();
        System.out.println("Ingresa la edad entera");
        int edad = scanner.nextInt();
        System.out.println("En caso de tener discapacidad ingrese (si), de lo contrio ingrese (no)");
        String prioridad = scanner.next();

        boolean prioridadbool = (prioridad.equals("si"));

        Usuario usuarioagregado = new Usuario(nombre, documento, edad, prioridadbool);
        farmaciaController.registrarUsuario(usuarioagregado);
    }

    private void eliminarUsuario() {
        System.out.print("Ingrese el documento del usuario a eliminar: ");
        String documento = scanner.nextLine();
        farmaciaController.eliminarCuentaUsuario(documento);
        System.out.println("Usuario eliminado exitosamente.");
    }

    private void comprarMedicamento() {
        System.out.print("Ingrese el documento del usuario que desea llenar el carrito: ");
        String documento = scanner.nextLine();
        Usuario usuario = farmaciaController.buscarUsuario(documento);
        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }
        System.out.println("Medicamentos de la farmacia");
        farmaciaController.imprimirInventario();
        int opcion;

        do {
            System.out.print("Ingrese el código del medicamento a comprar: ");
            int codigo = scanner.nextInt();
            scanner.nextLine();
            Medicamento medicamento = farmaciaController.buscarMedicamento(codigo);
            if (medicamento == null) {
                System.out.println("Medicamento no encontrado.");
                return;
            }
            usuario.comprarMedicamento(medicamento);
            farmaciaController.eliminarMedicamentoDisponible(codigo);
            System.out.println("Medicamento agregado con exito al carrito");
            System.out.println("Desea añadir otro medicamento");
            System.out.println("1.Si");
            System.out.println("2.No");
            opcion = scanner.nextInt();
        } while (2 != opcion);

    }

    public void EntrarALaFila() {
        System.out.println("Ingrese su identidad para que pueda entrar en la fila");
        String documento = scanner.nextLine();
        Usuario usuario = farmaciaController.buscarUsuario(documento);
        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }
        farmaciaController.encolarUsuario(usuario);
        System.out.println("INGRESADO A LA FILA CON EXITO");
        usuario.vaciarPilaDefinitivamente();
    }

}
