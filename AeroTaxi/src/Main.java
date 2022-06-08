import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import netscape.javascript.JSObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        List<Usuario> users = new ArrayList<>();
        Usuario newUser = new Usuario("alex", "villca", 22, 22);
        Usuario newUser2 = new Usuario("agustin", "rivadineira", 22, 22);











       /* users.add(0,newUser);
        users.add(1,newUser2);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(users,users.getClass());


        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("archivo_usuarios.json"))) {
            bufferedWriter.write(jsonString);
        }catch (FileNotFoundException e){
            System.out.println("Error en archivo");
        }catch (IOException e){
            System.out.println("super error");
        }
        Type collectionType = TypeToken.getParameterized(List.class,Usuario).getType();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("archivo_usuarios.json"))){
            List<Usuario> usuario;
            usuario = gson.fromJson(bufferedReader,collectionType);
            for (var users : usuario) {
                System.out.println(users.toString());
                }
            }
        }catch (IOException e){
            System.out.println("error maximo");
        }*/

    }
}

