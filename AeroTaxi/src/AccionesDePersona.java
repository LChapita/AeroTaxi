import java.util.List;

public interface AccionesDePersona {
    void mostrarUsuarios(List<User> usuarios);
    List<User> removerUsuario(List<User> usuarios, int eliminar);
    List<User> modificarUsuario(List<User> usuarios, int dni);
    void ordenarUsuario_Por_Nombre(List<User> usuarios);
    void ordenarUsuario_Por_Dni(List<User> usuarios); // ver funcionamiento de DNI


}
