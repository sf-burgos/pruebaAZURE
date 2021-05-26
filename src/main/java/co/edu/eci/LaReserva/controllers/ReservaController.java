package co.edu.eci.LaReserva.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.edu.eci.LaReserva.entities.Reserva;
import co.edu.eci.LaReserva.services.LaReservaException;
import co.edu.eci.LaReserva.services.Impl.ReservaServices;

@RestController
@RequestMapping(value = "/reservas")
@CrossOrigin(origins = "*")
public class ReservaController {

    @Autowired
    private ReservaServices reservaServices;

    @GetMapping(value = "/listar")
    public ResponseEntity<?> consultarReservas() {
        try {
            return new ResponseEntity<>(reservaServices.consultarReservas(), HttpStatus.ACCEPTED);
        } catch (LaReservaException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/crear")
    public synchronized ResponseEntity<?> registrarReservas(@RequestBody Reserva reserva) {
        try {
            reservaServices.crearReserva(reserva);
            return new ResponseEntity<>("Reserva creada satisfactoriamente.", HttpStatus.CREATED);
        } catch (LaReservaException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<?> elimina(@RequestParam Integer id) {
        try {
            reservaServices.eliminarReserva(id);
            return new ResponseEntity<>("Reserva eliminada satisfactoriamente.", HttpStatus.CREATED);
        } catch (LaReservaException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody @Validated Reserva reserva) {
        reserva.setId(id);
        try {
            reservaServices.actualizarReserva(reserva);
            return new ResponseEntity<>("La reserva se actualizo", HttpStatus.CREATED);
        } catch (LaReservaException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
