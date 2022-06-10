import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Avion avion= new Gold();

        System.out.println("AeroTaxi");
        System.out.println("verificar 1");
        File clientesFile = new File("baseClientes.txt");
        Usuario usuario1 = new Usuario("Lucas", "Chapa", 12345678, 25);
        Usuario usuario2 = new Usuario("Bruno", "Gregorio", 98765432, 26);

        ArrayList<Usuario> usuarioArrayList=new ArrayList<>();
        usuarioArrayList.add(usuario1);
        usuarioArrayList.add(usuario2);

        nuevoUsuario(clientesFile,usuarioArrayList);

        leerUsuarios(clientesFile);

        Usuario usuario1 = new Usuario("Lucas", "Chapa", 12345678, 25,123);
        Avion gold=new Gold(1000,10,Propulsion.REACCION,true,true);
        Avion silver=new Silver(1000,10,Propulsion.REACCION,true);
        Avion bronze=new Bronze(1000,10,Propulsion.REACCION);
        Vuelo vuelo=new Vuelo(Ciudad.BUE,Ciudad.COR,bronze, LocalDate.now(),6,usuario1);
        el archivo pasarlo a lista
        ///cargar usuario poner de la lista y despues guardar esa lista en un archivo
        ///

        File file = new File("baseClientes.json");
        Gson gson=new Gson();

        String jsonUsuario=gson.toJson(usuario1);

        System.out.println("json: " + jsonUsuario);

        Usuario nuevo=gson.fromJson(jsonUsuario,Usuario.class);

        System.out.println("usuario: " + nuevo);



        try{
            ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(file));
            objectOutput.writeObject(usuario1);
            objectOutput.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Usuario tipoUsuario=new Usuario();
        Usuario usuario1 = new Usuario("Lucas", "Chapa", 12345678, 25, 123);
        Usuario usuario2 = new Usuario("Bruno", "Gregorio", 98765432, 26, 456);

        ArrayList<Usuario> usuarioArrayList = new ArrayList<>();
        usuarioArrayList.add(usuario1);
        usuarioArrayList.add(usuario2);

        Usuario usuario3 = new Usuario("Matias", "Kinder", 99999999, 24, 789);//cargo nuevo usuario

        //usuarioArrayList.add(usuario3);

        Avion gold = new Gold(1000, 10, Propulsion.REACCION, true, true);
        Avion silver = new Silver(1000, 10, Propulsion.REACCION, true);
        Avion bronze = new Bronze(1000, 10, Propulsion.REACCION);

        Vuelo vuelo = new Vuelo(Ciudad.BUE, Ciudad.COR, bronze, LocalDate.now(), 6, usuario1);

        Archivo<Usuario> archivoUsuarios = new Archivo<>("baseUsuarios.json");

        List<Usuario> clientes = archivoUsuarios.rescatar(Usuario.class);//pasar a un arreglo el archivo

        //archivoUsuarios.guardar(usuarioArrayList,Usuario.class);//guardar el archivo



        for (Object user : clientes) {
            System.out.println(user.toString());

        }
        ///metodo copia lista usuarios****

        for (Object user : clientes) {
            System.out.println(user.toString());

        }
        //Usuario usuario4 = new Usuario("Roberto", "Lucero", 99777888, 80, 967);//cargo nuevo usuario

        //clientes.add(usuario4);

        //archivoUsuarios.guardar(clientes);

        clientes.add(usuario3);
        archivoUsuarios.guardar((ArrayList<Usuario>) clientes,Usuario.class);

        for (Usuario user : clientes) {
            System.out.println(user.toString());

        }

        //List<Usuario> nuevo=archivoUsuarios.rescatar(Usuario.class);

        //System.out.println(clientes);


        //Usuario usuario4 = new Usuario("Roberto", "Lucero", 99777888, 80, 967);//cargo nuevo usuario

        clientes.add(usuario4);
        archivoUsuarios.guardar(clientes);

        Usuario usuario5 = new Usuario("Carlos", "Peña", 15478966, 40, 897);//cargo nuevo usuario

        clientes.add(usuario5);
        archivoUsuarios.guardar(clientes);

        for (Object aux : clientes ) {
            System.out.println(aux);

        }


        //System.out.println(vuelo.calcularCosto());
        */

        /*
        LocalDateTime fecha=solicitarFecha();
        DateTimeFormatter forma= DateTimeFormatter.ofPattern("HH-dd-MM-yyyy");
        System.out.println(fecha.format(forma));
        */
    }


    /*
        public static void nuevoUsuario(File clientesFile, ArrayList usuarios) {

            try {
                BufferedWriter salida = new BufferedWriter(new FileWriter(clientesFile));
                salida.write(String.valueOf(usuarios));
                salida.close();
            } catch (IOException e) {
                System.out.println("error");
            }///poner finally
        }

        public static void leerUsuarios(File clientesFile) {

            if (!clientesFile.exists()) {
                return;
            }
            BufferedReader entrada = null;
            try {
                entrada = new BufferedReader(new FileReader(clientesFile));

                String linea = null;

                while ((linea = entrada.readLine()) != null) {
                    System.out.println(linea);
                }
                entrada.close();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (entrada != null) {
                    try {
                        entrada.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

     */
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

        System.out.println("Ingrese fecha de partida (hora-dia-mes-año)");

        LocalDateTime fechaIngresada = solicitarFecha();

        while (fechaIngresada.isBefore(LocalDateTime.now().plusDays(1))) {///reservar vuelo a partir de la fecha ingresada
            System.out.println("Los vuelos se reservarse con un día de anticipación. Ingrese nueva fecha:");
            fechaIngresada = solicitarFecha();
        }
        ArrayList<Ciudad> trayectos = new ArrayList<>();

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
        Avion avionReservado=seleccionarAvion(vuelosContratados,aviones,fechaIngresada,cantidadPasajeros);

        Vuelo reservado=null;
        int respuesta=0;
        if(avionReservado!=null){
            Vuelo nuevoVuelo= new Vuelo(origen,destino,avionReservado,fechaIngresada,cantidadPasajeros,usuario);
            System.out.println("Costo del vuelo: $"+nuevoVuelo.calcularCosto());
            System.out.println("Confirmar= 1 "+"/ Cancelar= 0 ");
            do {
                respuesta=new Scanner(System.in).nextInt();
            }while (respuesta!=1 && respuesta!=0);
            if (respuesta==1){
                reservado=nuevoVuelo;
            }

        }
        if (respuesta==0){
            System.out.println("Se cancelo la reserva.");
        }

        return reservado;
    }

    public static Avion seleccionarAvion(ArrayList<Vuelo> recuperarVuelos,ArrayList<Avion> recuperarAviones,LocalDateTime fechaPartida,int cantidadPasajeros){
        int i=0;
        boolean reservar=false;
        boolean disponible=false;

        System.out.println("estos son los aviones disponibles: ");
        for (Avion avion:recuperarAviones){///busco los aviones 1 por 1
            for(Vuelo vuelo:recuperarVuelos){// busco en el registro los vuelos pactados 1 por 1
                if (vuelo.getPartida().equals(fechaPartida) && vuelo.getTipoAvion().equals(avion)){
                    //encuentro el registro de vuelo y si se encuentra la fecha y el avion elegidos
                    //entonces el avion esta reservado y no se puede usar
                    reservar=true;

                }
            }
            if (!reservar && avion.getCapacidadMAxima() >=cantidadPasajeros){
                System.out.println("Avion ID: "+i+"---"+avion);
                disponible=true;
            }
            i++;
        }
        Avion avionSeleccionado=null;
        if (disponible){
            System.out.println("Ingrese el Id del avion: ");
            int opcion=new Scanner(System.in).nextInt();
            avionSeleccionado = recuperarAviones.get(opcion);
        }else {
            System.out.println("No hay aviones disponibles");
        }

        return avionSeleccionado;
    }
    public static void verVuelo(ArrayList<Vuelo> recuperarVuelos){
        if(!recuperarVuelos.isEmpty()){
            for (Vuelo aux:recuperarVuelos){
                System.out.println(aux);
            }
        }
        else {
            System.out.println("No hay vuelos. ");
        }
    }
}
