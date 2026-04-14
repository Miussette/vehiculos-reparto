public class MotoReparto extends Vehiculo {

    private boolean cajaTermica;

    // 2. Constructor ajustado a los 4 parámetros que envía tu Main.java
    public MotoReparto(String patente, String marca, String modelo, boolean cajaTermica) {
        // 3. Enviamos al padre los datos básicos.
        // Como la moto no suele usar capacidadCarga en Toneladas, le pasamos 0.
        super(patente, marca, modelo, 0);
        this.cajaTermica = cajaTermica;
    }

    // Getter
    public boolean isCajaTermica() {
        return cajaTermica;
    }

    // Setter
    public void setCajaTermica(boolean cajaTermica) {
        this.cajaTermica = cajaTermica;
    }

    // Polimorfismo
    @Override
    public void mostrarDetalle() {
        super.mostrarDetalle(); // Imprime Patente, Marca, Modelo (lo que hizo el Alumno 1)
        System.out.println("Caja térmica: " + (cajaTermica ? "Sí" : "No"));
        System.out.println("---------------------------");
    }
}