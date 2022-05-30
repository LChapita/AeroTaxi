import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
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

    }

    public static void nuevoUsuario(File clientesFile,ArrayList usuarios) {

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
}
