public class Avion{ // ver de quitarle el abstract a la clase Avion para poder crear los archivos
    private int combustible;
    private float costoPorKilometro;
    private int capacidadMAxima;
    private int velocidadMaxima;
    private Propulsion propulsion;

    public Avion() {
    }

    public Avion(int combustible, int capacidadMAxima, Propulsion propulsion) {
        this.capacidadMAxima = capacidadMAxima;
        this.combustible = combustible;
        this.propulsion = propulsion;

        this.costoPorKilometro = costoPorKilometro;
        this.velocidadMaxima = propulsion.getVelocidadMaxima();

    }

    public void setCombustible(int combustible) {
        this.combustible = combustible;
    }

    public void setCostoPorKilometro(float costoPorKilometro) {
        this.costoPorKilometro = costoPorKilometro;
    }

    public void setCapacidadMAxima(int capacidadMAxima) {
        this.capacidadMAxima = capacidadMAxima;
    }

    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public void setPropulsion(Propulsion propulsion) {
        this.propulsion = propulsion;
    }

    public int getCombustible() {
        return combustible;
    }

    public float getCostoPorKilometro() {
        return costoPorKilometro;
    }

    public int getCapacidadMAxima() {
        return capacidadMAxima;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public Propulsion getPropulsion() {
        return propulsion;
    }


    @Override
    public String toString() {
        return "Avion{" +
                "combustible=" + combustible +
                ", costoPorKilometro=" + costoPorKilometro +
                ", capacidadMAxima=" + capacidadMAxima +
                ", velocidadMaxima=" + velocidadMaxima +
                ", propulsion=" + propulsion +
                '}';
    }
}
