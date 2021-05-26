package co.edu.eci.LaReserva.services;

import co.edu.eci.LaReserva.entities.Usuario;
import java.util.List;

public interface IUsuarioServices {

    void registrarUsuario(Usuario user) throws LaReservaException;

    List<Usuario> consultarUsuarios() throws LaReservaException;

    Usuario autenticarUsuario(String username, String password) throws LaReservaException;

    Usuario usuarioPorNombreDeUsuario(String username) throws LaReservaException;

    void actualizarContrasena(String username, String password) throws LaReservaException;
}
