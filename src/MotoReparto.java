public class MotoReparto extends Vehiculo {

    private boolean cajaTermica;

    public MotoReparto(String patente, String marca, String modelo, boolean cajaTermica) {
        super(patente, marca, modelo, 0);
        this.cajaTermica = cajaTermica;
    }

    public boolean isCajaTermica() {
        return cajaTermica;
    }

    public void setCajaTermica(boolean cajaTermica) {
        this.cajaTermica = cajaTermica;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println(
                "Patente: " + getPatente() +
                        " | Marca: " + getMarca() +
                        " | Modelo: " + getModelo() +
                        " | Caja termica: " + (cajaTermica ? "SI" : "NO") +
                        " | Disponible: " + (isDisponible() ? "SI" : "EN REPARTO")
        );
    }
}
