package com.example.model.entities;
import java.util.HashSet;
import java.util.Locale.Category;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long equipo_id;
    @Column(name = "Nombre", unique = true, nullable = false)
    private String Nombre;    
    private String Iniciales;
    @OneToMany(mappedBy = "deportista_id", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Deportista> Deportistas= new HashSet<>();
    @ManyToMany(mappedBy = "equipos", cascade = {CascadeType.PERSIST, CascadeType.MERGE})    
    private Set<Evento> Eventos= new HashSet<>();

    public Equipo() {
    }

    public Equipo(String nombre, String iniciales) {
        this.Nombre = nombre;
        this.Iniciales = iniciales;
    }

    // Getters y Setters
    public Long getId() {
        return equipo_id;
    }

    public void setId(Long id) {
        this.equipo_id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getIniciales() {
        return Iniciales;
    }

    public void setIniciales(String iniciales) {
        this.Iniciales = iniciales;
    }

    public Set<Deportista> getDeportistas() {
        return Deportistas;
    }

    public void setDeportistas(Set<Deportista> deportistas) {
        this.Deportistas = Deportistas;
    }

    public Set<Evento> getEventos() {
        return Eventos;
    }

    public void setEventos(Set<Evento> eventos) {
        this.Eventos = eventos;
    }
    public void setEvento(Evento evento) {
        this.Eventos.add(evento);
    }
    public void setDeportista(Deportista deportista) {
        this.Deportistas.add(deportista);
    }

}
