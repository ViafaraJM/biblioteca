package com.example.biblioteca.Libros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/libros")
public class LibroController {
    private final LibroService libroService;
    @Autowired
    public LibroController(LibroService libroService){
        this.libroService = libroService;
    }

//    @GetMapping
//   public List<Libros> getLibros(){
//      return this.libroService.getLibros();
//    }
}
