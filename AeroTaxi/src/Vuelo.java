


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;


public class Vuelo implements Serializable, Implementacion{

    private Ciudad origen;
    private Ciudad destino;

    private Avion tipoAvion;

    private String partida;
    private String llegada;

    private int cantidadPasajeros;
    private User cliente;

    public Vuelo(Ciudad origen, Ciudad destino, Avion tipoAvion, String partida, int cantidadPasajeros, User cliente) {//en principio es lo que se carga
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

    public String getPartida() {
        return partida;
    }

    public String getLlegada() {
        return llegada;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public User getCliente() {
        return cliente;
    }

    public void setCliente(User cliente) {
        this.cliente=cliente;
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

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
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
    public float calcularCosto(Vuelo vuelo) {
        float precio=0;
        //quiero comparar 2 clase para retornar el precio
        //System.out.println(vuelo.tipoAvion.getPrecio());
        /*
        if(vuelo.tipoAvion.getTipoAvion().compareTo("avionGold")==0){
            System.out.println("macaco");
        }else{
            if(vuelo.tipoAvion instanceof Silver){
                precio= ((Silver) tipoAvion).getPrecio();
            }else{
                if (vuelo.tipoAvion instanceof Bronze){
                    precio= ((Bronze) tipoAvion).getPrecio();
                }
            }
        }*/
        //(Cantidad de kms * Costo del km) + (cantidad de pasajeros * 3500) + (Tarifa del tipo de avi??n)
        precio=vuelo.tipoAvion.getPrecio();
        float costoPorkm=0;
        costoPorkm=vuelo.tipoAvion.getCostoPorKilometro();
        //System.out.println(this.obtenerDistancia());
        //System.out.println(vuelo.tipoAvion.getCostoPorKilometro()+"macaco");
        return ((this.obtenerDistancia() * costoPorkm) + (cantidadPasajeros * 3500) + precio);//16-25-07-2022
    }


    @Override
    public String toString() {
        return "Vuelo{" +
                "origen=" + origen +
                ", destino=" + destino +
                ", tipoAvion=" + tipoAvion +
                ", partida=" + partida +
                ", cantidadPasajeros=" + cantidadPasajeros +
                ", cliente=" + cliente +
                '}';
    }

}
