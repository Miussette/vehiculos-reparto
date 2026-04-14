public class Furgon extends Vehiculo {

    private double volumenCarga;

    // 2. Ajustamos el constructor a 4 parámetros para que coincida con tu Main.java
    public Furgon(String patente, String marca, String modelo, double volumenCarga) {
        // 3. Llamamos al padre (Vehiculo) pasando los datos básicos.
        // Si el padre pide capacidadCarga, le pasamos 0 o el dato que prefieras.
        super(patente, marca, modelo, 0);
        setVolumenCarga(volumenCarga);
    }

    // GETTER
    public double getVolumenCarga() {
        return volumenCarga;
    }

    // SETTER con validación
    public void setVolumenCarga(double volumenCarga) {
        if (volumenCarga <= 0) {
            throw new IllegalArgumentException("Volumen debe ser > 0");
        }
        this.volumenCarga = volumenCarga;
    }

    // POLIMORFISMO
    @Override
    public void mostrarDetalle() {
        super.mostrarDetalle(); // Muestra la info base de la clase Vehiculo
        System.out.println("Volumen: " + volumenCarga + " m³");
        System.out.println("---------------------------");
    }
}