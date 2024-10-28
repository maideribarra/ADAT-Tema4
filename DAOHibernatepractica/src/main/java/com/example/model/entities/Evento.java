package com.example.model.entities;
import java.util.HashSet;
import java.util.Locale.Category;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long evento_id;
    private String Nombre;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deporte_id")
    private Deporte Deporte;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "olimpiada_id")
    private Olimpiada Olimpiada;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "participacion",
    joinColumns = @JoinColumn(name = "evento_id", referencedColumnName = "evento_id"),
    inverseJoinColumns = @JoinColumn(name = "equipo_id", referencedColumnName = "equipo_id"))
    private Set<Equipo> equipos= new HashSet<>();
    


    public Evento(String nombre, Deporte deporte, Olimpiada olimpiada) {
        this.Nombre = nombre;
        this.Deporte = deporte;
        this.Olimpiada = olimpiada;
        
    }
    public Evento() {
    }

    // Getters y Setters
    public Long getId() {
        return evento_id;
    }

    public void setId(Long id) {
        this.evento_id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public Deporte getDeporte() {
        return Deporte;
    }

    public void setDeporte(Deporte deporte) {
        this.Deporte = deporte;
    }

    public Olimpiada getOlimpiada() {
        return Olimpiada;
    }

    public void setOlimpiada(Olimpiada olimpiada) {
        this.Olimpiada = olimpiada;
    }

    public Set<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(Set<Equipo> equipos) {
        this.equipos = equipos;
    }

    
    public void setEquipo(Equipo equipo) {
        this.equipos.add(equipo);
    }
    



}
