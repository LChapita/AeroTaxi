public class Bronze extends Avion{
    private static float precio=3000F;

    public static float costoKilometro=150;
    public Bronze(){}

    public Bronze(int combustible, int capacidadMAxima, Propulsion propulsion) {
        super(combustible, capacidadMAxima, propulsion,precio,costoKilometro);
        this.precio = 3000F;
    }




}
