import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;



public class RequestFlightMenu {
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
                System.out.println("Formato de fecha incorrecto. Vuelva a ingresar:");
                confirmar = false;
            }
        } while (!confirmar);
        return fecha;
    }


    public static Vuelo sacarVuelo(Usuario usuario, ArrayList<Vuelo> vuelosContratados, ArrayList<Avion> aviones) {
        Scanner teclado = new Scanner(System.in);
        Vuelo vuelo = new Vuelo();


        System.out.println("Ingrese fecha de partida (hora-dia-mes-año)");

        LocalDateTime fechaIngresada = solicitarFecha();

        while (fechaIngresada.isBefore(LocalDateTime.now().plusDays(1))) {///reservar vuelo a partir de la fecha ingresada
            System.out.println("Los vuelos se reservarse con un día de anticipación. Ingrese nueva fecha:");
            fechaIngresada = solicitarFecha();
        }
        ArrayList<Ciudad> trayectos = new ArrayList<Ciudad>();


        trayectos.add(Ciudad.BUE);
        trayectos.add(Ciudad.COR);
        trayectos.add(Ciudad.MVD);
        trayectos.add(Ciudad.SCL);

        Ciudad origen = null;
        Ciudad destino = null;

        System.out.println("Seleccione la ciudad de origen");

        for (int e = 0; e < 2; e++) {
            int i = 0;
            for (Ciudad aux : trayectos) {
                System.out.println(i + "- " + aux.getNombreCiudad() + " (" + aux + ")");
                i++;
            }
            int opcion;
            do {
                System.out.println("Elija una opcion: ");
                opcion = new Scanner(System.in).nextInt();
            } while ((opcion < 0) || (opcion >= trayectos.size()));
            System.out.println(" - " + trayectos.get(opcion).getNombreCiudad() + " - \n");

            if(e==0){
                origen=trayectos.get(opcion);
                System.out.println("Seleccione ciudad de destino: ");
            }else {
                destino=trayectos.get(opcion);
            }
            trayectos.remove(opcion);
        }
        System.out.println("Ingrese cantidad de acompañantes o 0(cero) si viaja solo: ");
        int cantidadPasajeros=new Scanner(System.in).nextInt();

        ///seleccionar Avion




        return reservado;
    }


}

