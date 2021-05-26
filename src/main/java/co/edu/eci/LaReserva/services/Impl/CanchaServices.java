package co.edu.eci.LaReserva.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.eci.LaReserva.entities.Cancha;
import co.edu.eci.LaReserva.persistence.CanchaPersistence;
import co.edu.eci.LaReserva.persistence.LaReservaPersistenceException;
import co.edu.eci.LaReserva.services.ICanchaServices;
import co.edu.eci.LaReserva.services.LaReservaException;

@Service
public class CanchaServices implements ICanchaServices {

    @Autowired
    CanchaPersistence canchaPersistence;

    @Override
    public void crearCancha(Cancha cancha) throws LaReservaException {
        try {
            canchaPersistence.agregarCancha(cancha);
        } catch (LaReservaPersistenceException ex) {
            throw new LaReservaException(ex.getMessage());
        }
    }

    @Override
    public List<Cancha> consultarCancha() throws LaReservaException {
        return canchaPersistence.consultarCancha();
    }

    @Override
    public void eliminarCancha(Integer id) throws LaReservaException {
        try {
            canchaPersistence.eliminarCancha(id);
        } catch (LaReservaPersistenceException ex) {
            throw new LaReservaException(ex.getMessage());
        }
    }

    @Override
    public void actualizarCancha(Cancha cancha) throws LaReservaException {
        try {
            canchaPersistence.agregarCancha(cancha);
        } catch (LaReservaPersistenceException ex) {
            throw new LaReservaException(ex.getMessage());
        }
    }

    @Override
    public List<Cancha> consultarCanchasPorSede(Integer idSede) throws LaReservaException {
        try {
            return canchaPersistence.canchasPorSede(idSede);
        } catch (LaReservaPersistenceException ex) {
            throw new LaReservaException(ex.getMessage());
        }
    }

    @Override
    public Cancha consultarCanchaPorId(Integer id) throws LaReservaException {
        try {
            return canchaPersistence.canchaPorId(id);
        } catch (LaReservaPersistenceException ex) {
            throw new LaReservaException(ex.getMessage());
        }
    }
}
