package co.edu.eci.LaReserva.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "canchas")
public class Cancha implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "sede")
    private int sede;

    @Column(name = "tamano")
    private int tamano;

    @Column(name = "precio")
    private int precio;

    @Column(name = "titulo")
    private String titulo;

    public Cancha(int id, int sede, int tamano, int precio, String titulo) {
        this.id = id;
        this.sede = sede;
        this.tamano = tamano;
        this.precio = precio;
        this.titulo = titulo;
    }

    public Cancha() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSede() {
        return sede;
    }

    public void setSede(int sede) {
        this.sede = sede;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Cancha{" + "id=" + id + ", sede=" + sede + ", tamano=" + tamano + ", precio=" + precio + ", titulo=" + titulo + '}';
    }
}
