package co.edu.eci.LaReserva.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.edu.eci.LaReserva.entities.Reserva;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva, Integer> {

    @Query("SELECT r FROM Reserva r WHERE r.cancha = ?1 AND r.dia = ?2 AND r.hora = ?3")
    Reserva validarReserva(Integer cancha, String dia, String hora);
}
