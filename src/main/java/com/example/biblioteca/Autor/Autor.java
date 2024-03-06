package com.example.biblioteca.Autor;

import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

@Entity
@Table
public class Autor {
    public Autor() {}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String nombre;

    public Autor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
