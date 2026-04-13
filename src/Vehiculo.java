public class Vehiculo {

    private String patente;
    private String marca;
    private String modelo;
    private double capacidadCarga;
    private boolean disponible;

    // Constructor
    public Vehiculo(String patente, String marca, String modelo, double capacidadCarga) {
        setPatente(patente);
        setMarca(marca);
        setModelo(modelo);
        setCapacidadCarga(capacidadCarga);
        this.disponible = true;
    }

    // GETTERS Y SETTERS (ENCAPSULACIÓN)

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        if (patente == null || patente.trim().isEmpty()) {
            throw new IllegalArgumentException("Patente no puede estar vacía");
        }
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if (marca == null || marca.trim().isEmpty()) {
            throw new IllegalArgumentException("Marca no puede estar vacía");
        }
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        if (capacidadCarga < 0) {
            throw new IllegalArgumentException("Capacidad no puede ser negativa");
        }
        this.capacidadCarga = capacidadCarga;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // METODO POLIMÓRFICO
    public void mostrarDetalle() {
        System.out.println("Patente: " + patente +
                " | Marca: " + marca +
                " | Modelo: " + modelo +
                " | Carga: " + capacidadCarga +
                " | Disponible: " + disponible);
    }
}