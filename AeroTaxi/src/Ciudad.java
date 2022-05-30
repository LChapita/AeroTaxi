public enum Ciudad {
    BUE("Buenos Aires"),
    COR("Cordoba"),
    MVD("Montevideo"),
    SCL("Santiago de Chile");

    private String nombreCiudad;

    Ciudad(String nombreCiudad){this.nombreCiudad=nombreCiudad;}

    public String getNombreCiudad() {
        return nombreCiudad;
    }
}
