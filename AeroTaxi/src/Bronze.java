public class Bronze extends Avion{
    private static float precio=3000F;

    public static float costoKilometro=150;
    public static String avionBronze = "Bronze";
    public Bronze(){}

    public Bronze(int combustible, int capacidadMAxima, Propulsion propulsion) {
        super(combustible, capacidadMAxima, propulsion,precio,costoKilometro,avionBronze);
        this.precio = 3000F;
    }




}
