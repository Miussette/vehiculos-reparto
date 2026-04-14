import java.util.*;

public class Main {

    // 1. REGISTRAR CAMIÓN
    public static void registrarCamion(List<Vehiculo> lista, Scanner sc) {
        sc.nextLine(); // Limpiar el Enter que quedó del menú
        String p = leerTextoNoVacio(sc, "Patente: ");
        String m = leerTextoNoVacio(sc, "Marca: ");
        String mod = leerTextoNoVacio(sc, "Modelo: ");

        System.out.print("Capacidad Carga (Ton): ");
        while (!sc.hasNextDouble()) {
            System.out.println("❌ Error: Ingrese un número (usa punto para decimales).");
            sc.next();
        }
        double cap = sc.nextDouble();

        lista.add(new Camion(p, m, mod, cap));
        System.out.println("✅ Camión registrado con éxito.");
    }

    // 2. REGISTRAR FURGÓN
    public static void registrarFurgon(List<Vehiculo> lista, Scanner sc) {
        sc.nextLine();
        String p = leerTextoNoVacio(sc, "Patente: ");
        String m = leerTextoNoVacio(sc, "Marca: ");
        String mod = leerTextoNoVacio(sc, "Modelo: ");

        System.out.print("Volumen Carga (m3): ");
        while (!sc.hasNextDouble()) {
            System.out.println("❌ Error: Ingrese un número.");
            sc.next();
        }
        double vol = sc.nextDouble();

        lista.add(new Furgon(p, m, mod, vol));
        System.out.println("✅ Furgón registrado con éxito.");
    }

    // 3. REGISTRAR MOTO
    public static void registrarMoto(List<Vehiculo> lista, Scanner sc) {
        sc.nextLine();
        String p = leerTextoNoVacio(sc, "Patente: ");
        String m = leerTextoNoVacio(sc, "Marca: ");
        String mod = leerTextoNoVacio(sc, "Modelo: ");

        System.out.print("¿Tiene caja térmica? (true/false): ");
        while (!sc.hasNextBoolean()) {
            System.out.println("❌ Error: Escriba true o false.");
            sc.next();
        }
        boolean caja = sc.nextBoolean();

        lista.add(new MotoReparto(p, m, mod, caja));
        System.out.println("✅ Moto registrada con éxito.");
    }

    // MÉTODO AUXILIAR: Evita que la patente o marca queden en blanco
    public static String leerTextoNoVacio(Scanner sc, String mensaje) {
        String texto;
        do {
            System.out.print(mensaje);
            texto = sc.nextLine().trim(); // Captura toda la línea y quita espacios
            if (texto.isEmpty()) {
                System.out.println("⚠️ Error: Este campo no puede quedar vacío.");
            }
        } while (texto.isEmpty());
        return texto;
    }

    // --- Los demás métodos (mostrarTodos, reporte, etc.) se mantienen igual ---

    public static void mostrarTodos(List<Vehiculo> lista) {
        System.out.println("\n--- LISTADO COMPLETO DE LA FLOTA ---");
        if (lista.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
        } else {
            for (Vehiculo v : lista) {
                v.mostrarDetalle();
            }
        }
    }

    public static void mostrarDisponibles(List<Vehiculo> lista) {
        System.out.println("\n--- VEHÍCULOS DISPONIBLES ---");
        boolean hay = false;
        for (Vehiculo v : lista) {
            if (v.isDisponible()) {
                v.mostrarDetalle();
                hay = true;
            }
        }
        if (!hay) System.out.println("No hay vehículos disponibles actualmente.");
    }

    public static void marcarNoDisponible(List<Vehiculo> lista, Scanner sc) {
        System.out.print("Ingrese patente del vehículo que sale a ruta: ");
        String p = sc.next();
        for (Vehiculo v : lista) {
            if (v.getPatente().equalsIgnoreCase(p)) {
                v.setDisponible(false);
                System.out.println("✅ El vehículo " + p + " ha cambiado su estado a: EN REPARTO.");
                return;
            }
        }
        System.out.println("❌ Patente no encontrada.");
    }

    public static void mostrarReporte(List<Vehiculo> lista) {
        int total = lista.size();
        int disp = 0;
        for (Vehiculo v : lista) {
            if (v.isDisponible()) disp++;
        }
        System.out.println("\n--- REPORTE GENERAL DEL SISTEMA ---");
        System.out.println("Vehículos totales: " + total);
        System.out.println("Disponibles: " + disp);
        System.out.println("En ruta: " + (total - disp));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // CLAVE: Para que el punto (.) funcione como decimal siempre
        scanner.useLocale(Locale.US);

        List<Vehiculo> vehiculos = new ArrayList<>();
        int opcion = 0;

        do {
            System.out.println("\n=== SISTEMA DE VEHÍCULOS DE REPARTO ===");
            System.out.println("1. Registrar camión");
            System.out.println("2. Registrar furgón");
            System.out.println("3. Registrar moto de reparto");
            System.out.println("4. Mostrar todos los vehículos");
            System.out.println("5. Mostrar vehículos disponibles");
            System.out.println("6. Marcar vehículo como no disponible");
            System.out.println("7. Mostrar reporte general");
            System.out.println("8. Salir");
            System.out.print("Ingrese una opción: ");

            if (!scanner.hasNextInt()) {
                System.out.println("❌ Debe ingresar un número válido (1-8)");
                scanner.next();
                continue;
            }
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1: registrarCamion(vehiculos, scanner);    break;
                case 2: registrarFurgon(vehiculos, scanner);    break;
                case 3: registrarMoto(vehiculos, scanner);      break;
                case 4: mostrarTodos(vehiculos);               break;
                case 5: mostrarDisponibles(vehiculos);         break;
                case 6: marcarNoDisponible(vehiculos, scanner); break;
                case 7: mostrarReporte(vehiculos);             break;
                case 8: System.out.println("¡Hasta luego!");    break;
                default: System.out.println("Opción inválida.");
            }
        } while (opcion != 8);

        scanner.close();
    }
}