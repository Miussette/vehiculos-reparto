public class Camion extends Vehiculo {
    private int cantidadEjes;

    // 2. Constructor ajustado a lo que el Main envía (4 parámetros)
    public Camion(String patente, String marca, String modelo, double capacidadCarga) {
        // 3. Llamada al padre corregida (4 parámetros)
        super(patente, marca, modelo, capacidadCarga);
        this.cantidadEjes = 2; // Valor por defecto o podrías pedirlo en el Main si quieres
    }

    @Override
    public void mostrarDetalle(){
        super.mostrarDetalle(); // Llama a la info básica de Vehiculo
        System.out.println("Cantidad de Ejes: " + cantidadEjes);
        System.out.println("---------------------------");
    }
}