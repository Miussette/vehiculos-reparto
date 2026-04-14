import java.util.*;

public class Main {

    public static void registrarCamion() {
        System.out.println("(pendiente) Registrar camión");
    }

    public static void registrarFurgon() {
        System.out.println("(pendiente) Registrar furgón");
    }

    public static void registrarMoto() {
        System.out.println("(pendiente) Registrar moto");
    }

    public static void mostrarTodos() {
        System.out.println("(pendiente) Registrar furgón");
    }

    public static void mostrarDisponibles() {
        System.out.println("(pendiente) Vehículos Disponibles");
    }

    public static void marcarNoDisponible() {
        System.out.println("(pendiente) I");
    }

    public static void mostrarReporte() {
        System.out.println("(pendiente) Mostrar");
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Vehiculo> vehiculos = new ArrayList<>();

        int opcion;

        do {
            System.out.println("=== SISTEMA DE VEHÍCULOS DE REPARTO ===");
            System.out.println("1. Registrar camión");
            System.out.println("2. Registrar furgón");
            System.out.println("3. Registrar moto de reparto");
            System.out.println("4. Mostrar todos los vehículos");
            System.out.println("5. Mostrar vehículos disponibles");
            System.out.println("6. Marcar vehículo como no disponible");
            System.out.println("7. Mostrar reporte general");
            System.out.println("8. Salir");

            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1: registrarCamion();          break;
                case 2: registrarFurgon();          break;
                case 3: registrarMoto();            break;
                case 4: mostrarTodos();             break;
                case 5: mostrarDisponibles();       break;
                case 6: marcarNoDisponible();       break;
                case 7: mostrarReporte();           break;
                case 8: System.out.println("¡Hasta luego!"); break;
                default: System.out.println("Opción inválida.");
            }

        } while (opcion != 8);

        scanner.close();


    }
}