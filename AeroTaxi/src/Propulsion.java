public enum Propulsion {
    REACCION("Motor a Reaccion",1000),
    HELICE("Motor Turbohelice",500),
    PISTONES("Motor a Pistones",250);

    private String tipoMotor;
    private int velocidadMaxima;
    Propulsion(String tipoMotor,int velocidadMaxima){
        this.tipoMotor=tipoMotor;
        this.velocidadMaxima=velocidadMaxima;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }
}
