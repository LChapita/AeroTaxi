import User.User;

import javax.lang.model.util.Elements;
import javax.security.sasl.SaslClient;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
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

    public static Vuelo sacarVuelo(User user, ArrayList<Vuelo> vuelosContratados, ArrayList<Avion> aviones) {
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

        //Ciudad origen = null;
        //Ciudad destino = null;


        int confirmacion = 0;
        do{
            System.out.println("Seleccione la ciudad de origen: ");
            Ciudad origen = OriginCity(trayectos);

            System.out.println("Seleccione la ciudad de destino: ");
            Ciudad destino = DestinyCity(trayectos, origen);

            if(( origen.getNombreCiudad().compareTo(destino.getNombreCiudad()) ) == 0){
                System.out.println("Si desea confirmar, presione 1, caso contrario, presione 0");
                try{
                    confirmacion = teclado.nextInt();
                } catch (InputMismatchException e){
                    System.out.println(e.getMessage());
                }
            }

        } while(confirmacion == 0);

        // segunda mitad la termino mañana

    }


    private static Ciudad OriginCity(ArrayList<Ciudad> trayectos){
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

    private static Ciudad DestinyCity(ArrayList<Ciudad> trayectos, Ciudad origin){
        int i = 0;
        int trayectoEnUso = 0;
        for(Ciudad inArgentina : trayectos){
            if( (trayectos.get(i++).getNombreCiudad().compareTo(origin.getNombreCiudad()) ) != 0) // si el vuelo ya fue seleccionado previamente en origen, entonces no lo va a mostrar como opción
                System.out.println(i + "- " + inArgentina.getNombreCiudad() + "(" + inArgentina + ")");

            else
                trayectoEnUso = trayectos.indexOf(--i);
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


}


















