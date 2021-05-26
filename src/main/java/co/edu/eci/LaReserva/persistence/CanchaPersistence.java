package co.edu.eci.LaReserva.persistence;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.edu.eci.LaReserva.entities.Cancha;
import co.edu.eci.LaReserva.persistence.cache.LaReservaCache;
import co.edu.eci.LaReserva.persistence.repository.ICanchaRepository;

@Repository
public class CanchaPersistence {

    @Autowired
    private ICanchaRepository canchaRepository;

    @Autowired
    private LaReservaCache cache;

    public void agregarCancha(Cancha cancha) throws LaReservaPersistenceException {
        canchaRepository.save(cancha);
    }

    public List<Cancha> consultarCancha() {
        return canchaRepository.findAll();
    }

    public void eliminarCancha(Integer id) throws LaReservaPersistenceException {
        canchaRepository.deleteById(id);
    }

    public List<Cancha> canchasPorSede(Integer idSede) throws LaReservaPersistenceException {
        return canchaRepository.canchasPorSede(idSede);
    }

    public Cancha canchaPorId(Integer id) throws LaReservaPersistenceException {
        if (cache.canchaEnCache(id)) {
            System.out.println("Desde la caché");
            return cache.getCancha(id);
        } else {
            Cancha cancha = canchaRepository.canchaPorId(id);
            if (cancha == null) {
                throw new LaReservaPersistenceException("La cancha no existe.");
            }
            cache.putCancha(cancha);
            return canchaRepository.canchaPorId(id);
        }
    }
}
