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
import co.edu.eci.LaReserva.entities.Cancha;
import co.edu.eci.LaReserva.services.LaReservaException;
import co.edu.eci.LaReserva.services.Impl.CanchaServices;

@RestController
@RequestMapping(value = "/canchas")
@CrossOrigin(origins = "*")
public class CanchaController {

    @Autowired
    private CanchaServices canchaServices;

    @GetMapping(value = "/listar")
    public ResponseEntity<?> consultarCanchas() {
        try {
            return new ResponseEntity<>(canchaServices.consultarCancha(), HttpStatus.ACCEPTED);
        } catch (LaReservaException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<?> consultarCanchaPorId(@RequestParam Integer id) {
        try {
            return new ResponseEntity<>(canchaServices.consultarCanchaPorId(id), HttpStatus.ACCEPTED);
        } catch (LaReservaException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/crear")
    public ResponseEntity<?> registrarCancha(@RequestBody Cancha cancha) {
        try {
            canchaServices.crearCancha(cancha);;
            return new ResponseEntity<>("Cancha creada satisfactoriamente.", HttpStatus.CREATED);
        } catch (LaReservaException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<?> elimina(@RequestParam Integer id) {
        try {
            canchaServices.eliminarCancha(id);
            return new ResponseEntity<>("Cancha eliminada satisfactoriamente.", HttpStatus.CREATED);
        } catch (LaReservaException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody @Validated Cancha cancha) {
        cancha.setId(id);
        try {
            canchaServices.actualizarCancha(cancha);
            return new ResponseEntity<>("Sede se actualizo", HttpStatus.CREATED);
        } catch (LaReservaException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping(value = "/sede")
    public ResponseEntity<?> consultarCanchasPorSede(@RequestParam Integer id) {
        try {
            return new ResponseEntity<>(canchaServices.consultarCanchasPorSede(id), HttpStatus.ACCEPTED);
        } catch (LaReservaException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
