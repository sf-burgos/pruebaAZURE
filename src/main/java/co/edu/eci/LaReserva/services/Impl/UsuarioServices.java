package co.edu.eci.LaReserva.services.Impl;

import co.edu.eci.LaReserva.entities.Usuario;
import co.edu.eci.LaReserva.persistence.LaReservaPersistenceException;
import co.edu.eci.LaReserva.persistence.UsuarioPersistence;
import co.edu.eci.LaReserva.services.IUsuarioServices;
import co.edu.eci.LaReserva.services.LaReservaException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServices implements IUsuarioServices {

    @Autowired
    UsuarioPersistence usuarioPersistence;

    public UsuarioServices() {

    }

    @Override
    public void registrarUsuario(Usuario usuario) throws LaReservaException {
        try {
            usuarioPersistence.emailOUsuarioEstanEnUso(usuario.getEmail(), usuario.getUsername());
            usuarioPersistence.agregarUsuario(usuario);
        } catch (LaReservaPersistenceException ex) {
            throw new LaReservaException(ex.getMessage());
        }
    }

    @Override
    public List<Usuario> consultarUsuarios() throws LaReservaException {
        return usuarioPersistence.consultarUsuarios();
    }

    @Override
    public Usuario autenticarUsuario(String username, String password) throws LaReservaException {
        try {
            return usuarioPersistence.autenticarUsuario(username, password);
        } catch (LaReservaPersistenceException ex) {
            throw new LaReservaException(ex.getMessage());
        }
    }

    @Override
    public Usuario usuarioPorNombreDeUsuario(String username) throws LaReservaException {
        try {
            return usuarioPersistence.encontrarUsuario(username);
        } catch (LaReservaPersistenceException ex) {
            throw new LaReservaException(ex.getMessage());
        }
    }

    @Override
    public void actualizarContrasena(String username, String password) throws LaReservaException {
        try {
            Usuario usuario = usuarioPorNombreDeUsuario(username);
            usuario.setContrasena(password);
            usuarioPersistence.agregarUsuario(usuario);
            //usuarioPersistence.actualizarContrasena(username, password);
        } catch (LaReservaPersistenceException ex) {
            throw new LaReservaException(ex.getMessage());
        }
    }
}
