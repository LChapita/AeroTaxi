import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("AeroTaxi");
        System.out.println("verificar 1");
        File clientesFile = new File("baseClientes.txt");
        nuevoUsuario(clientesFile);
        leerUsuarios(clientesFile);

    }

    public static void nuevoUsuario(File clientesFile) {

        try {
            BufferedWriter salida = new BufferedWriter(new FileWriter(clientesFile));
            Usuario usuario1 = new Usuario("Lucas", "Chapa", 12345678, 25);
            salida.write(String.valueOf(usuario1));
            salida.close();
        } catch (IOException e) {
            System.out.println("error");
        }
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
