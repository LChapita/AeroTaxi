public class Gold extends Avion {
    private boolean conexionWifi;
    private boolean catering;
    public static float precio=6000F;
    public static float costoKilometro=300F;
    public static String  avionGold="Gold";


    public Gold() {
    }

    public Gold(int combustible, int capacidadMAxima, Propulsion propulsion, boolean conexionWifi, boolean catering) {
        super(combustible, capacidadMAxima, propulsion,precio,costoKilometro,avionGold);
        this.conexionWifi = conexionWifi;
        this.catering = catering;
    }

    @Override
    public String toString() {
        return "Gold{" +
                "conexionWifi=" + conexionWifi +
                ", catering=" + catering +
                '}';
    }
}
