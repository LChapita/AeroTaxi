import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Archivo<T> {
    private final String pricipalArchivo;
    private final ArrayList<T> baseArchivo;

    public Archivo(String trayectoArchivo) {///creo una lista para archivos
        this.pricipalArchivo = trayectoArchivo;
        baseArchivo = new ArrayList<>();
    }


    public void guardar(ArrayList<T> arrayList,Class<T> tipoClase) {///objetos por separado
        File archivo = new File(pricipalArchivo);
        Gson gson = new Gson();

        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        BufferedWriter salida=null;

        ///verificar repetidos antes de guardar
        try {
            ///como crear un nuevo archivo?
            salida = new BufferedWriter(new FileWriter(archivo));

            for (T aux : arrayList) {//obligado
                baseArchivo.add(aux);
            }
            gson.toJson(baseArchivo,salida);

            //System.out.println("macaco");
            salida.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<T> rescatar(Class<T> tipoClase) {
        File archivo = new File(pricipalArchivo);

        List<T> rescatado=new ArrayList<>();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        /*
        if (!archivo.exists()) {
            return null;
        }*/

        Type colecctionType=TypeToken.getParameterized(List.class,tipoClase).getType();

        BufferedReader entrada = null;

        try {
            entrada = new BufferedReader(new FileReader(archivo));

            rescatado = gson.fromJson(entrada, colecctionType);

            /*String leo = null;
            while ((leo = entrada.readLine()) != null) {
                rescatado.add((T) leo);
            }*/

        } catch (IOException e) {
            System.out.println("error base de datos");///verificar bien que problema tiene al rescatar
        } finally {
            if(entrada!=null){
                try{
                    entrada.close();
                }
                 catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return rescatado;
    }



    //System.out.println("macaco");


}


