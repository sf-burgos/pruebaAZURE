package co.edu.eci.LaReserva.persistence;

import co.edu.eci.LaReserva.entities.Sede;
import co.edu.eci.LaReserva.persistence.cache.LaReservaCache;
import co.edu.eci.LaReserva.persistence.repository.ISedeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SedePersistence {

    @Autowired
    private ISedeRepository sedeRepository;

    @Autowired
    private LaReservaCache cache;

    public void agregarSede(Sede sede) throws LaReservaPersistenceException {
        sedeRepository.save(sede);
    }

    public List<Sede> consultarSedes() {
        return sedeRepository.findAll();
    }

    public void eliminarSede(Integer id) throws LaReservaPersistenceException {
        sedeRepository.deleteById(id);
    }

    public Sede sedePorId(Integer id) throws LaReservaPersistenceException {
        if (cache.sedeEnCache(id)) {
            return cache.getSede(id);
        } else {
            Sede sede = sedeRepository.sedePorId(id);
            if (sede == null) {
                throw new LaReservaPersistenceException("La sede no existe.");
            }
            cache.putSede(sede);
            return sedeRepository.sedePorId(id);
        }
    }

    public List<Sede> sedesPorUsuario(Integer idUsuario) throws LaReservaPersistenceException {
        List<Sede> sedes = sedeRepository.sedesPorUsuario(idUsuario);
        if (sedes.isEmpty()) {
            throw new LaReservaPersistenceException("El usuario no tiene sedes.");
        }
        return sedes;
    }
}
