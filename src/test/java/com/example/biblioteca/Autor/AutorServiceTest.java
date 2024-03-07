package com.example.biblioteca.Autor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class AutorServiceTest {

    @Mock
    private AutorRepository autorRepository;
    @InjectMocks
    private AutorService autorService;
    private Autor autor;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        autor = new Autor();
        autor.setNombre("Aldous Huxley");
        autor.setId(4);
    }

    @Test
    void newAutor() {
        when(autorRepository.findAll()).thenReturn(Arrays.asList(autor));
        assertNotNull(autorService.getAutor());
    }
}