public class Bronze extends Avion{
    private int precio;
    public Bronze(){}

    public Bronze(int combustible, int capacidadMAxima, Propulsion propulsion) {
        super(combustible, capacidadMAxima, propulsion);
        this.precio = 3000;
    }

    public void setPresio(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }



}
