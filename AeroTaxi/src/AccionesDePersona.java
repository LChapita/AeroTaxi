import java.util.List;
import java.util.UUID;

public interface AccionesDePersona {
    void mostrarUsuarios(List<Usuario> usuarios);
    List<Usuario> removerUsuario(List<Usuario> usuarios,int eliminar);
    List<Usuario> modificarUsuario(List<Usuario> usuarios, int dni) throws InterruptedException;
    void ordenarUsuario_Por_Nombre(List<Usuario> usuarios);
    void ordenarUsuario_Por_Dni(List<Usuario> usuarios);


}
