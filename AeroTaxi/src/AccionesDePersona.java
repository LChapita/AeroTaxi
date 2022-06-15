import java.util.List;
import java.util.UUID;

public interface AccionesDePersona {
    void mostrarUsuarios(List<User> usuarios);
    List<User> removerUsuario(List<User> usuarios,int eliminar);
    List<User> modificarUsuario(List<User> usuarios, int dni);
    void ordenarUsuario_Por_Nombre(List<User> usuarios);
    void ordenarUsuario_Por_Dni(List<User> usuarios);


}
