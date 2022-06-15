public class Gold extends Avion {
    private boolean conexionWifi;
    private boolean catering;
    public static float precio=6000F;
    public static float costoKilometro=300F;


    public Gold() {
    }

    public Gold(int combustible, int capacidadMAxima, Propulsion propulsion, boolean conexionWifi, boolean catering) {
        super(combustible, capacidadMAxima, propulsion,precio,costoKilometro);
        this.conexionWifi = conexionWifi;
        this.catering = catering;
    }




}
