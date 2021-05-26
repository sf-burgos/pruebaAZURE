package co.edu.eci.LaReserva.controllers;

import co.edu.eci.LaReserva.entities.Usuario;
import co.edu.eci.LaReserva.services.Impl.UsuarioServices;
import co.edu.eci.LaReserva.services.LaReservaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioServices usuarioServices;

    @Autowired
    JavaMailSender javaMailSender;

    @GetMapping(value = "/listar")
    public ResponseEntity<?> consultarUsuarios() {
        try {
            return new ResponseEntity<>(usuarioServices.consultarUsuarios(), HttpStatus.ACCEPTED);
        } catch (LaReservaException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/registrar")
    public ResponseEntity<?> registrarUsuario(@RequestBody Usuario usuario) {
        try {
            usuarioServices.registrarUsuario(usuario);
            return new ResponseEntity<>("Usuario registrado satisfactoriamente.", HttpStatus.CREATED);
        } catch (LaReservaException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping(value = "/login")
    public ResponseEntity<?> autenticarUsuario(@RequestParam String usr, @RequestParam String pwd) {
        try {
            return new ResponseEntity<>(usuarioServices.autenticarUsuario(usr, pwd), HttpStatus.ACCEPTED);
        } catch (LaReservaException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/send-email/{username}")
    public String sendMail(@PathVariable String username) {
        String email;
        try {
            email = usuarioServices.usuarioPorNombreDeUsuario(username).getEmail();
        } catch (LaReservaException ex) {
            return ex.getMessage();
        }
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setFrom("jfpazto@gmail.com");
        mensaje.setTo(email);
        mensaje.setSubject("Recuperacion Contraseña");
        mensaje.setText("Estimado " + username + " para recuperar su contraseña vaya al siguiente enlace https://cherry-surprise-79251.herokuapp.com/recuperarContrase%C3%B1a.html?username=" + username);
        javaMailSender.send(mensaje);
        return username;
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> update(@RequestParam String password, @RequestParam String username) {
        try {
            usuarioServices.actualizarContrasena(username, password);
            return new ResponseEntity<>("Contraseña cambiada con éxito.", HttpStatus.CREATED);
        } catch (LaReservaException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
