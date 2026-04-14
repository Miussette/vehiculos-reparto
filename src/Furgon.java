public class Furgon extends Vehiculo {

    private double volumenCarga;

    public Furgon(String patente, String marca, String modelo, double capacidadCarga, double volumenCarga) {
        super(patente, marca, modelo, capacidadCarga);
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
        super.mostrarDetalle();
        System.out.println("Volumen: " + volumenCarga + " m³");
    }
}
