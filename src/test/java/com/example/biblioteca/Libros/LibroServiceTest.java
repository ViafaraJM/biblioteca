package com.example.biblioteca.Libros;

import com.example.biblioteca.Autor.Autor;
import com.example.biblioteca.Autor.AutorRepository;
import com.example.biblioteca.Autor.AutorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class LibroServiceTest {
    @Mock
    private LibrosRepository librosRepository;
    @InjectMocks
    private LibroService libroService;
    private Libros libros;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        libros = new Libros();
        libros.setTitulo("Un mundo feliz");
        libros.setAutor(3);
        libros.setGenero("Novela");
        libros.setAnioPublicacion(1932);
        libros.setId(4);
    }

    @Test
    void getLibros() {
        when(librosRepository.findAll()).thenReturn(Arrays.asList(libros));
        assertNotNull(libroService.getLibros());
    }
}