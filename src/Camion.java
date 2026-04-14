public class Camion extends Vehiculo {
    private int cantidadEjes;

    public Camion(String patente, String marca, String modelo, double capacidadCarga, int cantidadEjes) {
        super(patente, marca, modelo, capacidadCarga);
        setCantidadEjes(cantidadEjes);
    }

    public int getCantidadEjes() {
        return cantidadEjes;
    }

    public void setCantidadEjes(int cantidadEjes) {
        if (cantidadEjes <= 0) {
            throw new IllegalArgumentException("La cantidad de ejes debe ser mayor que 0.");
        }
        this.cantidadEjes = cantidadEjes;
    }

    @Override
    public void mostrarDetalle() {
        super.mostrarDetalle();
        System.out.println("Cantidad de Ejes: " + cantidadEjes);
        System.out.println("---------------------------");
    }
}
