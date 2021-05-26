package co.edu.eci.LaReserva.services;

import java.util.List;

import co.edu.eci.LaReserva.entities.Cancha;

public interface ICanchaServices {

    void crearCancha(Cancha cancha) throws LaReservaException;

    List<Cancha> consultarCancha() throws LaReservaException;

    void eliminarCancha(Integer id) throws LaReservaException;

    void actualizarCancha(Cancha cancha) throws LaReservaException;

    List<Cancha> consultarCanchasPorSede(Integer idSede) throws LaReservaException;

    Cancha consultarCanchaPorId(Integer id) throws LaReservaException;
}
