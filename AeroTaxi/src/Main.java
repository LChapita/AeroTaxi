import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

        leerUsuarios(clientesFile);*/
/*
        Usuario usuario1 = new Usuario("Lucas", "Chapa", 12345678, 25,123);
        Avion gold=new Gold(1000,10,Propulsion.REACCION,true,true);
        Avion silver=new Silver(1000,10,Propulsion.REACCION,true);
        Avion bronze=new Bronze(1000,10,Propulsion.REACCION);
        Vuelo vuelo=new Vuelo(Ciudad.BUE,Ciudad.COR,bronze, LocalDate.now(),6,usuario1);
        ///el archivo pasarlo a lista
        ///cargar usuario poner de la lista y despues guardar esa lista en un archivo
        ///

        //File file = new File("baseClientes.json");
        Gson gson=new Gson();

        String jsonUsuario=gson.toJson(usuario1);

        System.out.println("json: " + jsonUsuario);

        Usuario nuevo=gson.fromJson(jsonUsuario,Usuario.class);

        System.out.println("usuario: " + nuevo);

        */
        /*
        try{
            ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(file));
            objectOutput.writeObject(usuario1);
            objectOutput.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        Usuario tipoUsuario=new Usuario();
        Usuario usuario1 = new Usuario("Lucas", "Chapa", 12345678, 25, 123);
        Usuario usuario2 = new Usuario("Bruno", "Gregorio", 98765432, 26, 456);

        ArrayList<Usuario> usuarioArrayList = new ArrayList<>();
        usuarioArrayList.add(usuario1);
        usuarioArrayList.add(usuario2);

        Usuario usuario3 = new Usuario("Matias", "Kinder", 99999999, 24, 789);//cargo nuevo usuario

        //usuarioArrayList.add(usuario3);
        /*
        Avion gold = new Gold(1000, 10, Propulsion.REACCION, true, true);
        Avion silver = new Silver(1000, 10, Propulsion.REACCION, true);
        Avion bronze = new Bronze(1000, 10, Propulsion.REACCION);

        Vuelo vuelo = new Vuelo(Ciudad.BUE, Ciudad.COR, bronze, LocalDate.now(), 6, usuario1);
        */
        Archivo<Usuario> archivoUsuarios = new Archivo<>("baseUsuarios.json");

        List<Usuario> clientes = archivoUsuarios.rescatar(Usuario.class);//pasar a un arreglo el archivo

        //archivoUsuarios.guardar(usuarioArrayList,Usuario.class);//guardar el archivo


        /*
        /*for (Object user : clientes) {
            System.out.println(user.toString());

        }*/
        ///metodo copia lista usuarios****
        /*
        for (Object user : clientes) {
            System.out.println(user.toString());

        }*/
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
    /*
        clientes.add(usuario4);
        archivoUsuarios.guardar(clientes);

        Usuario usuario5 = new Usuario("Carlos", "Peña", 15478966, 40, 897);//cargo nuevo usuario

        clientes.add(usuario5);
        archivoUsuarios.guardar(clientes);

        for (Object aux : clientes ) {
            System.out.println(aux);

        }*/


        //System.out.println(vuelo.calcularCosto());
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
}
