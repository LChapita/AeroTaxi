import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

public class Vuelo implements Serializable,Implementacion{

    private Ciudad origen;
    private Ciudad destino;

    private Avion tipoAvion;

    private LocalDateTime partida;
    private LocalDateTime llegada;

    private int cantidadPasajeros;
    private Usuario cliente;

    public Vuelo(Ciudad origen, Ciudad destino, Avion tipoAvion, LocalDateTime partida, int cantidadPasajeros, Usuario cliente) {//en principio es lo que se carga
        this.origen = origen;
        this.destino = destino;
        this.tipoAvion = tipoAvion;
        this.partida = partida;
        this.cantidadPasajeros = cantidadPasajeros;
        this.cliente = cliente;
    }

    public Ciudad getOrigen() {
        return origen;
    }

    public Ciudad getDestino() {
        return destino;
    }

    public Avion getTipoAvion() {
        return tipoAvion;
    }

    public LocalDateTime getPartida() {
        return partida;
    }

    public LocalDateTime getLlegada() {
        return llegada;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setOrigen(Ciudad origen) {
        this.origen = origen;
    }

    public void setDestino(Ciudad destino) {
        this.destino = destino;
    }

    public void setTipoAvion(Avion tipoAvion) {
        this.tipoAvion = tipoAvion;
    }

    public void setPartida(LocalDateTime partida) {
        this.partida = partida;
    }

    public void setLlegada(LocalDateTime llegada) {
        this.llegada = llegada;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    @Override
    public int obtenerDistancia() {
        //necesito guardar en claves las dictancias, para cuando el usuario ingrese origen y destino las distancias ya estan preconfiguradas para calcular
        //la tarifa o precio de lo que seria el calcular costo
        //sumo 2 hashcode y le guardo una clave, si la suma de las 2 ciudades es igual a la clave guardada entonces me arroja la distancia

        HashMap<Integer, Integer> distancias = new HashMap<>();

        distancias.put((Ciudad.BUE).hashCode() + (Ciudad.COR).hashCode(),695);
        distancias.put((Ciudad.BUE).hashCode() + (Ciudad.SCL).hashCode(),1400);
        distancias.put((Ciudad.BUE.hashCode())+(Ciudad.MVD).hashCode(),950);
        distancias.put((Ciudad.COR.hashCode())+(Ciudad.MVD).hashCode(),1190);
        distancias.put((Ciudad.COR.hashCode())+(Ciudad.SCL).hashCode(),1050);
        distancias.put((Ciudad.MVD.hashCode())+(Ciudad.SCL).hashCode(),2100);


        int ruta=origen.hashCode() + destino.hashCode();

        return distancias.get(ruta);
    }
    @Override
    public float calcularCosto() {
        int precio = 0;
        //quiero comparar 2 clase para retornar el precio
        if(this.tipoAvion.getClass().equals(Gold.class)){
            precio= ((Gold) tipoAvion).getPrecio();
            //System.out.println(precio);
        }else{
            if(this.tipoAvion.getClass().equals(Silver.class)){
                precio= ((Silver) tipoAvion).getPrecio();
            }else{
                if (this.tipoAvion.getClass().equals(Bronze.class)){
                    precio= ((Bronze) tipoAvion).getPrecio();
                }
            }
        }
        //(Cantidad de kms * Costo del km) + (cantidad de pasajeros * 3500) + (Tarifa del tipo de avión)
        return ((this.obtenerDistancia() * this.tipoAvion.getCostoPorKilometro()) + (cantidadPasajeros * 3500) + precio);
    }


}
