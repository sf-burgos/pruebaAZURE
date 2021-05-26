package co.edu.eci.LaReserva.services.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.eci.LaReserva.entities.Reserva;
import co.edu.eci.LaReserva.persistence.LaReservaPersistenceException;
import co.edu.eci.LaReserva.persistence.ReservaPersintence;
import co.edu.eci.LaReserva.services.IReservaServices;
import co.edu.eci.LaReserva.services.LaReservaException;

@Service
public class ReservaServices implements IReservaServices {

    @Autowired
    ReservaPersintence reservaPersistence;

    @Override
    public void crearReserva(Reserva reserva) throws LaReservaException {
        try {
            reservaPersistence.reservaRepetida(reserva.getCancha(), reserva.getDia(), reserva.getHora());
            reservaPersistence.agregarReserva(reserva);
        } catch (LaReservaPersistenceException ex) {
            throw new LaReservaException(ex.getMessage());
        }
    }

    @Override
    public List<Reserva> consultarReservas() throws LaReservaException {
        return reservaPersistence.consultarReserva();
    }

    @Override
    public void eliminarReserva(Integer id) throws LaReservaException {
        try {
            reservaPersistence.eliminarReserva(id);
        } catch (LaReservaPersistenceException ex) {
            throw new LaReservaException(ex.getMessage());
        }
    }

    @Override
    public void actualizarReserva(Reserva reserva) throws LaReservaException {
        try {
            reservaPersistence.agregarReserva(reserva);
        } catch (LaReservaPersistenceException ex) {
            throw new LaReservaException(ex.getMessage());
        }
    }
}
