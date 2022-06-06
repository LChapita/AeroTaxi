import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Archivo<T> {
    private String pricipalArchivo;
    private ArrayList<T> baseArchivo;

    public Archivo(String trayectoArchivo) {///creo una lista para archivos
        this.pricipalArchivo = trayectoArchivo;
        baseArchivo = new ArrayList<>();
    }


    public void guardar(ArrayList<T> arrayList) {
        File archivo = new File(pricipalArchivo);

        try {

            if (!archivo.exists()) {///como crear un nuevo archivo?

                archivo.createNewFile();
                BufferedWriter salida = new BufferedWriter(new FileWriter(archivo));

                for (T aux : arrayList) {//obligado
                    Gson gson = new Gson();
                    gson.toJson(aux, salida);

                }
                salida.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ArrayList<T> rescatar() {
        File archivo = new File(pricipalArchivo);

        ArrayList<T> rescatado = new ArrayList<>();
        if (!archivo.exists()) {
            return null;
        }
        BufferedReader entrada=null;
        try {
            entrada = new BufferedReader(new FileReader(archivo));
            String leo=null;
            while ((leo = entrada.readLine()) != null) {
                rescatado.add((T) leo);
            }
            entrada.close();
        } catch (IOException e) {
            System.out.println("error base de datos");
        }
        return rescatado;
    }
    //System.out.println("macaco");

}


