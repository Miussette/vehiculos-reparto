public class Furgon extends Vehiculo {

    private double volumenCarga;

    public Furgon(String patente, String marca, String modelo, double volumenCarga) {
        super(patente, marca, modelo, 0);
        setVolumenCarga(volumenCarga);
    }

    public double getVolumenCarga() {
        return volumenCarga;
    }

    public void setVolumenCarga(double volumenCarga) {
        if (volumenCarga <= 0) {
            throw new IllegalArgumentException("Volumen debe ser > 0");
        }
        this.volumenCarga = volumenCarga;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println(
                "Patente: " + getPatente() +
                        " | Marca: " + getMarca() +
                        " | Modelo: " + getModelo() +
                        " | Volumen: " + volumenCarga + " m3" +
                        " | Disponible: " + (isDisponible() ? "SI" : "EN REPARTO")
        );
    }
}
