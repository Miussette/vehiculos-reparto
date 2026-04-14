import java.util.*;

public class Main {

    public static void registrarCamion(List<Vehiculo> lista, Scanner sc) {
        String p = leerTextoNoVacio(sc, "Patente: ");
        String m = leerTextoNoVacio(sc, "Marca: ");
        String mod = leerTextoNoVacio(sc, "Modelo: ");

        System.out.print("Capacidad Carga (Ton): ");
        while (!sc.hasNextDouble()) {
            System.out.println("Error: ingrese un numero valido.");
            sc.next();
        }
        double cap = sc.nextDouble();
        sc.nextLine();

        System.out.print("Cantidad de ejes: ");
        while (!sc.hasNextInt()) {
            System.out.println("Error: ingrese un numero entero valido.");
            sc.next();
        }
        int ejes = sc.nextInt();
        sc.nextLine();

        if (cap < 0) {
            System.out.println("Error: la capacidad no puede ser negativa.");
            return;
        }

        if (ejes <= 0) {
            System.out.println("Error: la cantidad de ejes debe ser mayor que 0.");
            return;
        }

        try {
            lista.add(new Camion(p, m, mod, cap, ejes));
            System.out.println("Camion registrado con exito.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void registrarFurgon(List<Vehiculo> lista, Scanner sc) {
        String p = leerTextoNoVacio(sc, "Patente: ");
        String m = leerTextoNoVacio(sc, "Marca: ");
        String mod = leerTextoNoVacio(sc, "Modelo: ");

        System.out.print("Volumen Carga (m3): ");
        while (!sc.hasNextDouble()) {
            System.out.println("Error: ingrese un numero valido.");
            sc.next();
        }
        double vol = sc.nextDouble();
        sc.nextLine();

        if (vol <= 0) {
            System.out.println("Error: el volumen debe ser mayor que 0.");
            return;
        }

        try {
            lista.add(new Furgon(p, m, mod, vol));
            System.out.println("Furgon registrado con exito.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void registrarMoto(List<Vehiculo> lista, Scanner sc) {
        String p = leerTextoNoVacio(sc, "Patente: ");
        String m = leerTextoNoVacio(sc, "Marca: ");
        String mod = leerTextoNoVacio(sc, "Modelo: ");

        String respuesta = leerTextoNoVacio(sc, "Tiene caja termica? (si/no): ").toLowerCase();

        if (!respuesta.equals("si") && !respuesta.equals("no")) {
            System.out.println("Error: escriba si o no.");
            return;
        }

        boolean caja = respuesta.equals("si");

        try {
            lista.add(new MotoReparto(p, m, mod, caja));
            System.out.println("Moto registrada con exito.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static String leerTextoNoVacio(Scanner sc, String mensaje) {
        String texto;
        do {
            System.out.print(mensaje);
            texto = sc.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("Error: este campo no puede quedar vacio.");
            }
        } while (texto.isEmpty());
        return texto;
    }

    public static void mostrarTodos(List<Vehiculo> lista) {
        System.out.println("\n--- LISTADO COMPLETO DE LA FLOTA ---");
        if (lista.isEmpty()) {
            System.out.println("No hay vehiculos registrados.");
        } else {
            for (Vehiculo v : lista) {
                v.mostrarDetalle();
            }
        }
    }

    public static void mostrarDisponibles(List<Vehiculo> lista) {
        System.out.println("\n--- VEHICULOS DISPONIBLES ---");
        boolean hay = false;
        for (Vehiculo v : lista) {
            if (v.isDisponible()) {
                v.mostrarDetalle();
                hay = true;
            }
        }
        if (!hay) {
            System.out.println("No hay vehiculos disponibles actualmente.");
        }
    }

    public static void marcarNoDisponible(List<Vehiculo> lista, Scanner sc) {
        String p = leerTextoNoVacio(sc, "Ingrese patente del vehiculo que sale a ruta: ");

        for (Vehiculo v : lista) {
            if (v.getPatente().equalsIgnoreCase(p)) {
                if (!v.isDisponible()) {
                    System.out.println("El vehiculo ya esta en reparto.");
                    return;
                }
                v.setDisponible(false);
                System.out.println("El vehiculo " + p + " ha cambiado su estado a: EN REPARTO.");
                return;
            }
        }

        System.out.println("Patente no encontrada.");
    }

    public static void mostrarReporte(List<Vehiculo> lista) {
        int total = lista.size();
        int disp = 0;

        for (Vehiculo v : lista) {
            if (v.isDisponible()) {
                disp++;
            }
        }

        System.out.println("\n--- REPORTE GENERAL DEL SISTEMA ---");
        System.out.println("Vehiculos totales: " + total);
        System.out.println("Disponibles: " + disp);
        System.out.println("En ruta: " + (total - disp));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        List<Vehiculo> vehiculos = new ArrayList<>();
        int opcion = 0;

        do {
            System.out.println("\n=== SISTEMA DE VEHICULOS DE REPARTO ===");
            System.out.println("1. Registrar camion");
            System.out.println("2. Registrar furgon");
            System.out.println("3. Registrar moto de reparto");
            System.out.println("4. Mostrar todos los vehiculos");
            System.out.println("5. Mostrar vehiculos disponibles");
            System.out.println("6. Marcar vehiculo como no disponible");
            System.out.println("7. Mostrar reporte general");
            System.out.println("8. Salir");
            System.out.print("Ingrese una opcion: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Error: debe ingresar un numero valido (1-8).");
                scanner.next();
                continue;
            }

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarCamion(vehiculos, scanner);
                    break;
                case 2:
                    registrarFurgon(vehiculos, scanner);
                    break;
                case 3:
                    registrarMoto(vehiculos, scanner);
                    break;
                case 4:
                    mostrarTodos(vehiculos);
                    break;
                case 5:
                    mostrarDisponibles(vehiculos);
                    break;
                case 6:
                    marcarNoDisponible(vehiculos, scanner);
                    break;
                case 7:
                    mostrarReporte(vehiculos);
                    break;
                case 8:
                    System.out.println("Hasta luego.");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 8);

        scanner.close();
    }
}
