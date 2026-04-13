package src;
public class Camion extends Vehiculo {
    private int cantidadEjes;

    public Camion(String patente, String marca, String modelo, Integer capacidadCarga, Boolean disponible, Integer cantidadEjes) {
        super(patente, marca, modelo, capacidadCarga, disponible);
        if (cantidadEjes <= 0) {
            throw new IllegalArgumentException("La cantidad de ejes debe ser mayor a 0");
        }
        this.cantidadEjes =  cantidadEjes;
    }
    @Override
    public void mostrarDetalle(){
        super.mostrarDetalle();
        System.out.println("Cantidad de Ejes: " + cantidadEjes);
    }
}
