import java.util.List;

public interface AccionesDePersona {
    void mostrarUsuarios(List<Usuario> usuarios);
    List<Usuario> removerUsuario(List<Usuario> usuarios,int eliminar);
    Usuario modificarUsuario(List<Usuario> usuarios,int dni);


}
