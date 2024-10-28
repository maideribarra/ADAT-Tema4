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
public class Olimpiada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long olimpiada_id;
    @Column(name = "Nombre", unique = true, nullable = false)
    private String Nombre;    
    private int Anio;
    private String Temporada;
    private String Ciudad;
    @OneToMany(mappedBy = "evento_id")
    private Set<Evento> Eventos = new HashSet<>();

    public Olimpiada() {
    }

    public Olimpiada(String nombre, int anio, String temporada, String ciudad) {
        this.Nombre = nombre;
        this.Anio = anio;
        this.Temporada = temporada;
        this.Ciudad = ciudad;
    }

    // Getters y Setters
    public Long getId() {
        return olimpiada_id;
    }

    public void setId(Long id) {
        this.olimpiada_id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public int getAnio() {
        return Anio;
    }

    public void setAnio(int anio) {
        this.Anio = anio;
    }

    public String getTemporada() {
        return Temporada;
    }

    public void setTemporada(String temporada) {
        this.Temporada = temporada;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        this.Ciudad = ciudad;
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
