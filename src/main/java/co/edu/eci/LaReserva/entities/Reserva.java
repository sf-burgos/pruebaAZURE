package co.edu.eci.LaReserva.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reservas")
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "usuario")
    private int usuario;

    @Column(name = "cancha")
    private int cancha;

    @Column(name = "dia")
    private String dia;

    @Column(name = "hora")
    private String hora;

    public Reserva(int id, int usuario, int cancha, String dia, String hora) {
        this.id = id;
        this.usuario = usuario;
        this.cancha = cancha;
        this.dia = dia;
        this.hora = hora;
    }
    
    public Reserva() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getUsuario() {
        return usuario;
    }
    
    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getCancha() {
        return cancha;
    }
    
    public void setCancha(int cancha) {
        this.cancha = cancha;
    }

    public String getDia() {
        return dia;
    }
    
    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", usuario=" + usuario + ", cancha=" + cancha + ", dia=" + dia + ", hora=" + hora + '}';
    }
}
