package co.edu.eci.LaReserva.persistence;

import co.edu.eci.LaReserva.entities.Usuario;
import co.edu.eci.LaReserva.persistence.repository.IUsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioPersistence {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    public UsuarioPersistence() {

    }

    public void agregarUsuario(Usuario usuario) throws LaReservaPersistenceException {
        usuarioRepository.save(usuario);
    }

    public List<Usuario> consultarUsuarios() {
        return usuarioRepository.findAll();
    }

    public void emailOUsuarioEstanEnUso(String email, String username) throws LaReservaPersistenceException {
        if (!usuarioRepository.emailOUsuarioEstanEnUso(email, username).isEmpty()) {
            throw new LaReservaPersistenceException("Nombre de usuario o correo elctrónico en uso.");
        }
    }

    public Usuario autenticarUsuario(String username, String password) throws LaReservaPersistenceException {
        Usuario usuario = usuarioRepository.autenticarUsuario(username, password);
        if (usuario != null) {
            return usuario;
        } else {
            throw new LaReservaPersistenceException("El usuario no existe.");
        }
    }

    public Usuario encontrarUsuario(String username) throws LaReservaPersistenceException {
        Usuario usuario = usuarioRepository.encontrarUsuarioPorUsername(username);
        if (usuario != null) {
            return usuario;
        } else {
            throw new LaReservaPersistenceException("El usuario no existe.");
        }
    }

    public void actualizarContrasena(String username, String password) throws LaReservaPersistenceException {
        if (password.equals(encontrarUsuario(username).getContrasena())) {
            throw new LaReservaPersistenceException("La contraseña debe ser diferente.");
        }
        usuarioRepository.actualizarContrasena(password, username);
    }
}
