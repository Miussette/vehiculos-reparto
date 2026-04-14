package modelo;

public class Motoreparto extends Vehiculo {

    private boolean cajaTermica;

    // Constructor
    public Motoreparto(String patente, String marca, String modelo, boolean disponible, boolean cajaTermica) {
        super(patente, marca, modelo, disponible);
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
        System.out.println("Caja térmica: " + (cajaTermica ? "Sí" : "No"));
    }
}
