import com.google.gson.Gson;

import java.io.*;
import java.nio.Buffer;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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


        Usuario usuario1 = new Usuario("Lucas", "Chapa", 12345678, 25, 123);
        Usuario usuario2 = new Usuario("Bruno", "Gregorio", 98765432, 26, 456);

        ArrayList<Usuario> usuarioArrayList = new ArrayList<>();
        usuarioArrayList.add(usuario1);
        usuarioArrayList.add(usuario2);

        Avion gold = new Gold(1000, 10, Propulsion.REACCION, true, true);
        Avion silver = new Silver(1000, 10, Propulsion.REACCION, true);
        Avion bronze = new Bronze(1000, 10, Propulsion.REACCION);

        Vuelo vuelo = new Vuelo(Ciudad.BUE, Ciudad.COR, bronze, LocalDate.now(), 6, usuario1);

        Archivo<Usuario> archivoUsuarios = new Archivo<>("baseUsuarios.txt");

        ArrayList<Usuario> clientes = archivoUsuarios.rescatar();//pasar a un arreglo el archivo

        archivoUsuarios.guardar(usuarioArrayList);//guardar el archivo

        /*for (Object user : clientes) {
            System.out.println(user.toString());

        }*/
        Usuario usuario3 = new Usuario("Matias", "Kinder", 98765432, 24, 789);

        clientes.add(usuario3);

        archivoUsuarios.guardar(clientes);

        ArrayList<Usuario> nueva = archivoUsuarios.rescatar();

        for (Object user : nueva) {
            System.out.println(user.toString());

        }

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
