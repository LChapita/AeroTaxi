public class Silver extends Avion{
    private boolean conexionWifi;
    private int precio;

    public Silver() {
    }

    public Silver(int combustible, int capacidadMAxima, Propulsion propulsion, boolean conexionWifi) {
        super(combustible, capacidadMAxima, propulsion);
        this.precio = 4000;
        this.conexionWifi = conexionWifi;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
