import java.util.List;

public interface AccionesDePersona {
    void mostrarUsuarios(List<User.User> usuarios);
    List<User.User> removerUsuario(List<User.User> usuarios, int eliminar);
    User.User modificarUsuario(List<User.User> usuarios, int dni);


}
