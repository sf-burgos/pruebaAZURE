package co.edu.eci.LaReserva.services;

import java.util.List;

import co.edu.eci.LaReserva.entities.Reserva;

public interface IReservaServices {

    void crearReserva(Reserva reserva) throws LaReservaException;

    List<Reserva> consultarReservas() throws LaReservaException;

    void eliminarReserva(Integer id) throws LaReservaException;

    void actualizarReserva(Reserva reserva) throws LaReservaException;
}
