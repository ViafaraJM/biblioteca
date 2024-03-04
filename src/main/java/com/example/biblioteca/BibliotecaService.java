package com.example.biblioteca;
import com.example.biblioteca.Libros.LibroRepository;
import com.example.biblioteca.Libros.Libros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BibliotecaService {
    @Autowired
    private LibroRepository libroRepository;

    public Libros create(Libros libro) {
        return libroRepository.save(libro);
    }
}
