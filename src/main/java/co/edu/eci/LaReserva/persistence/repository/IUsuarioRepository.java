package co.edu.eci.LaReserva.persistence.repository;

import co.edu.eci.LaReserva.entities.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("SELECT u FROM Usuario u WHERE u.username = ?1 AND u.contrasena = ?2")
    Usuario autenticarUsuario(String username, String password);

    @Query("SELECT u FROM Usuario u WHERE u.email = ?1 OR u.username = ?2")
    List<Usuario> emailOUsuarioEstanEnUso(String email, String username);

    @Query("SELECT u FROM Usuario u WHERE u.username = ?1")
    Usuario encontrarUsuarioPorUsername(String username);

    @Query("UPDATE Usuario SET contrasena = ?1 WHERE username = ?2")
    void actualizarContrasena(String contrasena, String username);
}
