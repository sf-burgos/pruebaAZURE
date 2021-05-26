package co.edu.eci.LaReserva.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.eci.LaReserva.entities.Cancha;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface ICanchaRepository extends JpaRepository<Cancha, Integer> {

    @Query("SELECT c FROM Cancha c WHERE c.sede = ?1")
    List<Cancha> canchasPorSede(Integer idSede);

    @Query("SELECT c FROM Cancha c WHERE c.id = ?1")
    Cancha canchaPorId(Integer id);
}
