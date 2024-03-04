package com.example.biblioteca.Autor;

import com.example.biblioteca.Libros.Libros;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/autores")
public class AutorController {
    @GetMapping
    public List<Autor> getAutores(){
        return List.of(
                new Autor(
                        1,
                        "Gabriel Garcia Marquez"
                ));
    }
}
