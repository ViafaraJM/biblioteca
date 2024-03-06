package com.example.biblioteca.Autor;

import com.example.biblioteca.Libros.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {
    Optional<Autor> findAutorByNombre(String string);
}
