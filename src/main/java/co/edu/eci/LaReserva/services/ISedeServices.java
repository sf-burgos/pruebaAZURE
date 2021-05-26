package co.edu.eci.LaReserva.services;

import co.edu.eci.LaReserva.entities.Sede;
import java.util.List;

public interface ISedeServices {

    void crearSede(Sede sede) throws LaReservaException;

    List<Sede> consultarSedes() throws LaReservaException;

    void eliminarSede(Integer id) throws LaReservaException;

    void actualizarSede(Sede sede) throws LaReservaException;
    
    Sede consultarSedePorId(Integer id) throws LaReservaException;
    
    List<Sede> consultarSedePorUsuario(Integer idUsuario) throws LaReservaException;
}
