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
    public static void main(String[] args) throws InterruptedException {
        Admin unico = new Admin("vexal","x",22,22);
        List<Usuario> users = new ArrayList<>();
        Usuario newUser = new Usuario("alex", "villca", 5531, 22);
        Usuario newUser2 = new Usuario("rgustin", "rivadineira", 224, 22);
        Usuario newUser3 = new Usuario("hgustin", "rivadineira", 522, 22);
        Usuario newUser4 = new Usuario("agustin", "riv", 22, 922);
        List<Usuario> nueva = new ArrayList<>();
        users.add(newUser);
        users.add(newUser2);
        users.add(newUser3);
        users.add(newUser4);
        unico.mostrarUsuarios(users);
        nueva = unico.modificarUsuario(users,23);
        System.out.println("---------");
        unico.ordenarUsuario_Por_Nombre(nueva);
        unico.mostrarUsuarios(nueva);




       /* System.out.println(".....");
        boolean existe = verificarUsuario(users,25);
        if(existe == true){
            System.out.println("usuario ya existe");
        }else {
            System.out.println("dni valido");
        }

        nueva = unico.removerUsuario(users,22);
        unico.mostrarUsuarios(nueva);*/








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

    public static boolean verificarUsuario(List<Usuario> usuarios, int dni) {
        boolean verificar = false;
        for (Usuario usuario : usuarios) {
            if (usuario.getDni() == dni) {
                verificar = true;
            }

        }
        return verificar;
    }
}

