import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RequestFlyMenu {
    public static LocalDateTime solicitarFecha() {
        Scanner teclado = new Scanner(System.in);
        LocalDateTime fecha = null;
        boolean confirmar;

        do {
            try {
                DateTimeFormatter forma = DateTimeFormatter.ofPattern("HH-dd-MM-yyyy");
                fecha = LocalDateTime.parse(teclado.nextLine(), forma);
                confirmar = true;
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha incorrecto. Vuelva a ingresar: ");
                confirmar = false;
            }
        } while (!confirmar);

        return fecha;
    }

    public static Vuelo sacarVuelo(User user, List<Vuelo> vuelosContratados, List<Avion> aviones) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese fecha de partida (hora-dia-mes-año)");

        LocalDateTime fechaIngresada = solicitarFecha();

        while (fechaIngresada.isBefore(LocalDateTime.now().plusDays(1))) { // reservar vuelo a partir de la fecha ingresada
            System.out.println("Los vuelos se reservan con un día de anticipación. Ingrese nueva fecha:");
            fechaIngresada = solicitarFecha();
        }

        ArrayList<Ciudad> trayectos = new ArrayList<>();

        trayectos.add(Ciudad.BUE);
        trayectos.add(Ciudad.COR);
        trayectos.add(Ciudad.MVD);
        trayectos.add(Ciudad.SCL);

        Ciudad origen = null;
        Ciudad destino = null;


        int confirmacion = 0;
        do{
            System.out.println("Seleccione la ciudad de origen: ");
            origen = OriginCity(trayectos);

            System.out.println("Seleccione la ciudad de destino: ");
            destino = DestinyCity(trayectos, origen);

            if(( origen.getNombreCiudad().compareTo(destino.getNombreCiudad()) ) == 0){
                System.out.println("Si desea confirmar, presione 1\n");
                System.out.println("Si desea volver a modificar las ciudades, presione 0\n");
                try{
                    confirmacion = teclado.nextInt();
                } catch (InputMismatchException e){
                    System.out.println(e.getMessage());
                }
            }

        } while(confirmacion == 0);

        System.out.println("Ingrese cantidad de acompañantes o 0(cero) si viaja solo: ");
        int cantidadPasajeros = new Scanner(System.in).nextInt();

        Avion avionReservado = seleccionarAvion(vuelosContratados, aviones, fechaIngresada, cantidadPasajeros);

        Vuelo reservado = null;
        int respuesta = 0;
        if (avionReservado != null) {
            Vuelo nuevoVuelo = new Vuelo(origen, destino, avionReservado, fechaIngresada, cantidadPasajeros, user);
            System.out.println("Costo del vuelo: $" + nuevoVuelo.calcularCosto());
            System.out.println("Confirmar= 1 " + "/ Cancelar= 0 ");
            do {
                respuesta = new Scanner(System.in).nextInt();
            } while (respuesta != 1 && respuesta != 0);
            if (respuesta == 1) {
                reservado = nuevoVuelo;
            }

        }
        if (respuesta == 0) {
            System.out.println("Se cancelo la reserva.");
        }

        return reservado;
    }


    private static Ciudad OriginCity(List<Ciudad> trayectos){
        int i = 0;
        for(Ciudad inArgentina : trayectos){
            System.out.println(i++ + "- " + inArgentina.getNombreCiudad() + "(" + inArgentina + ")");
        }

        int option = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            try{
                System.out.println("Seleccione una opción: ");
                option = scanner.nextInt();

            } catch (InputMismatchException e){
                System.out.println(e.getMessage());
                //scanner.nextInt();
            }
        } while(option < 0 || option >= trayectos.size());

        return trayectos.get(option); // retorno la ciudad elegida por el usuario
    }

    private static Ciudad DestinyCity(List<Ciudad> trayectos, Ciudad origin){
        int i = 0;
        int trayectoEnUso = 0;
        for(Ciudad inArgentina : trayectos){
            if( (trayectos.get(i++).getNombreCiudad().compareTo(origin.getNombreCiudad()) ) != 0) // si el vuelo ya fue seleccionado previamente en origen, entonces no lo va a mostrar como opción
                System.out.println(i + "- " + inArgentina.getNombreCiudad() + "(" + inArgentina + ")");

            else
                trayectoEnUso = trayectos.indexOf(--i); // ver implementación
        }

        int option = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            try{
                System.out.println("Seleccione una opción: ");
                option = scanner.nextInt();

            } catch (InputMismatchException e){
                System.out.println(e.getMessage());
                //scanner.nextInt();
            }
        } while(option < 0 || option >= trayectos.size() || option == trayectoEnUso); // mientras la opción no sea valida, no se realizará la modificación

        return trayectos.get(option); // retorno la ciudad elegida por el usuario
    }


    public static Avion seleccionarAvion(List<Vuelo> recuperarVuelos, List<Avion> recuperarAviones, LocalDateTime fechaPartida, int cantidadPasajeros) {
        int i = 0;
        boolean reservar = false;
        boolean disponible = false;

        System.out.println("estos son los aviones disponibles: ");
        for (Avion avion : recuperarAviones) {///busco los aviones 1 por 1
            for (Vuelo vuelo : recuperarVuelos) {// busco en el registro los vuelos pactados 1 por 1
                if (vuelo.getPartida().equals(fechaPartida) && vuelo.getTipoAvion().equals(avion)) {
                    //encuentro el registro de vuelo y si se encuentra la fecha y el avion elegidos
                    //entonces el avion esta reservado y no se puede usar
                    reservar = true;

                }
            }
            if (!reservar && avion.getCapacidadMAxima() >= cantidadPasajeros) {
                System.out.println("Avion ID: " + i + "---" + avion);
                disponible = true;
            }
            i++;
        }
        Avion avionSeleccionado = null;
        if (disponible) {
            System.out.println("Ingrese el Id del avion: ");
            int opcion = new Scanner(System.in).nextInt();
            avionSeleccionado = recuperarAviones.get(opcion);
        } else {
            System.out.println("No hay aviones disponibles");
        }

        return avionSeleccionado;
    }


    public static void verVuelo(ArrayList<Vuelo> recuperarVuelos) {
        if (!recuperarVuelos.isEmpty()) {
            for (Vuelo aux : recuperarVuelos) {
                System.out.println(aux);
            }
        } else {
            System.out.println("No hay vuelos. ");
        }
    }


    public static Vuelo cancelarUnVuelo(User usuario, LocalDateTime fechaVuelo, ArrayList<Vuelo> recuperarVuelos) {
        boolean hallado = false;
        Vuelo vuelo = null;
        for (Vuelo aux : recuperarVuelos) {
            if (aux.getPartida().compareTo(fechaVuelo) == 0 && aux.getCliente().getDni() == usuario.getDni()) {
                if (aux.getPartida().isAfter(LocalDateTime.now())) {
                    vuelo = aux;
                } else {
                    System.out.println("El vuelo debe cancelarse con al menos un dia de anticipacion.");
                }
                hallado = true;
            }
            if (hallado) {
                break;
            }
        }
        if (!hallado) {
            System.out.println("No tiene un vuelo reservado en la fecha indicada. ");
        }
        return vuelo;

    }

    public static String verTipoAvionContratado(List<Vuelo> recuperarVuelos, User usuario) {///puede usarse para ver que tipo de avion contrato cada cliente
        //se debe de utilizar en una lista de clientes
        String mejor = "No se han pedido vuelos aun";
        boolean correcta = false;
        for (Vuelo vuelo : recuperarVuelos) {
            if (vuelo.getCliente().getDni() == usuario.getDni()) {
                Avion avion = vuelo.getTipoAvion();
                if (avion instanceof Gold) {
                    mejor = "El cliente saco la categoria Gold";
                    break;
                } else {
                    if (avion instanceof Silver) {
                        mejor = "El cliente saco hasta la categoria Silver";
                        correcta = true;
                    } else {
                        if (avion instanceof Bronze && !correcta) {
                            mejor = "El cliente saco hasta la categoria Bronze";
                        }
                    }
                }
            }
        }
        return mejor;
    }


    public static boolean verificarUsuario(List<User> recuperarUsuarios, int dni) {
        boolean verificar = false;
        for (User usuario : recuperarUsuarios) {
            if (usuario.getDni() == dni) {
                verificar = true;
                System.out.println("macaco9");
            }

        }
        return verificar;
    }
    public static User retornarUnUsuario(List<User> recuperarUsuarios, int dni) {
        User aux=null;
        for (User usuario : recuperarUsuarios) {
            if (usuario.getDni() == dni) {
                aux=usuario;
                break;
            }

        }
        return aux;
    }

    public static boolean SolicitarVuelo(List<User> recuperarUsuarios, List<Avion> recuperarAviones, List<Vuelo> recuperarVuelos, int dni) {

        boolean correcto =false;
        User nuevo=null;
        boolean existe=verificarUsuario(recuperarUsuarios, dni);
        if(existe) {
            nuevo=retornarUnUsuario(recuperarUsuarios,dni);
            recuperarVuelos.add(sacarVuelo(nuevo,recuperarVuelos,recuperarAviones));
            correcto=true;
        }
        return correcto;

    }


}





