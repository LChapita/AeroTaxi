public class Silver extends Avion{
    private boolean conexionWifi;
    private static float precio=4000F;
    public static float costoKilometro=225;
    public static String avionSilver = "Silver";
    public Silver() {
    }

    public Silver(int combustible, int capacidadMAxima, Propulsion propulsion, boolean conexionWifi) {
        super(combustible, capacidadMAxima, propulsion,precio,costoKilometro,avionSilver);
        this.precio = 4000F;
        this.conexionWifi = conexionWifi;
    }


    @Override
    public String toString() {
        return " Silver";
    }
}
