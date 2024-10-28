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

@Entity
public class Deportista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deportista_id;
    @Column(name = "Nombre", unique = true, nullable = false)
    private String Nombre;
    private String Sexo;
    private Double Peso;
    private Double Altura;
    private int Age;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_id")
    Equipo Equipo;
    
    public Deportista() {
    }

    public Deportista(String nombre, String sexo, int age, Double peso, Double altura) {
        this.Age=age;
        this.Nombre = nombre;
        this.Sexo = sexo;
        this.Peso = peso;
        this.Altura = altura;
       
    }

    // Getters y Setters
    public Long getId() {
        return deportista_id;
    }

    public void setId(Long id) {
        this.deportista_id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        this.Sexo = sexo;
    }

    public Double getPeso() {
        return Peso;
    }

    public void setPeso(Double peso) {
        this.Peso = peso;
    }

    public Double getAltura() {
        return Altura;
    }

    public void setAltura(Double altura) {
        this.Altura = altura;
    }

    public Equipo getEquipos() {
        return Equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.Equipo = equipo;
    }

    
   

}
