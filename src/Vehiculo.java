public class Vehiculo {

    private String patente;
    private String marca;
    private String modelo;
    private double capacidadCarga;
    private boolean disponible;

    public Vehiculo(String patente, String marca, String modelo, double capacidadCarga) {
        setPatente(patente);
        setMarca(marca);
        setModelo(modelo);
        setCapacidadCarga(capacidadCarga);
        this.disponible = true;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        if (patente == null || patente.trim().isEmpty()) {
            throw new IllegalArgumentException("Patente no puede estar vacia");
        }
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if (marca == null || marca.trim().isEmpty()) {
            throw new IllegalArgumentException("Marca no puede estar vacia");
        }
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        if (modelo == null || modelo.trim().isEmpty()) {
            throw new IllegalArgumentException("Modelo no puede estar vacio");
        }
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

    public void mostrarDetalle() {
        System.out.print(
                "Patente: " + getPatente() +
                        " | Marca: " + getMarca() +
                        " | Modelo: " + getModelo() +
                        " | Carga: " + getCapacidadCarga() + " Ton" +
                        " | Disponible: " + (isDisponible() ? "SI" : "EN REPARTO") +
                        " | "
        );
    }
}
