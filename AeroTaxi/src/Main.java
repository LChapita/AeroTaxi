import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import netscape.javascript.JSObject;

import java.io.*;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {



        escribir();
        leer();
    }


    private static void escribir() {
        File file = new File("archivo_usuarios.json");
        try{

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        Usuario userOne = new Usuario("alex","Villca",24412122,22);
        Usuario userTwo = new Usuario("Agustin","Rivadineira",223029219,22);
        Gson gson = new Gson();
        gson.toJson(userOne,Usuario.class,bufferedWriter);
        gson.toJson(userTwo,Usuario.class,bufferedWriter);
        }catch (IOException e){
            System.out.println("Error archivo" + e.getMessage());
        }

    }
    private static void leer() {
        File file = new File("archivo_usuarios.json");
        try{
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        Gson gson = new Gson();
        Usuario chargue = gson.fromJson(bufferedReader,Usuario.class);
        System.out.println(chargue);
        }catch (IOException e){
            System.out.println("error en el archivo" + e.getMessage());
        }
    }

}
