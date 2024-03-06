package com.example.biblioteca.Libros;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibrosRepository extends JpaRepository<Libros, Integer> {
    Optional<Libros> findLibroByTitulo(String string);
}
