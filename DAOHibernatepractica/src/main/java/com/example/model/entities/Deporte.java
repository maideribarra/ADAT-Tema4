package com.example.model.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Deporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deporte_id;
    @Column(name = "Nombre", unique = true, nullable = false)
    private String Nombre;
    @OneToMany(mappedBy = "evento_id")
    private Set<Evento> Eventos = new HashSet<>();
    
    public Deporte() {
    }

    public Deporte(String nombre) {
        this.Nombre = nombre;
    }

    // Getters y Setters
    public Long getId() {
        return deporte_id;
    }

    public void setId(Long id) {
        this.deporte_id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
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

    
}
