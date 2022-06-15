public class Gold extends Avion {
    private boolean conexionWifi;
    private boolean catering;
    private int precio;

    public Gold() {
    }

    public Gold(int combustible, int capacidadMAxima, Propulsion propulsion, boolean conexionWifi, boolean catering) {
        super(combustible, capacidadMAxima, propulsion);
        this.conexionWifi = conexionWifi;
        this.catering = catering;
        this.precio = 6000;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return " Gold";
    }
}
