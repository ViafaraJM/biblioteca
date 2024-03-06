package com.example.biblioteca.Libros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/libros")
public class LibroController {
    private final LibroService libroService;
    @Autowired
    public LibroController(LibroService libroService){
        this.libroService = libroService;
    }
    @GetMapping
   public List<Libros> getLibros(){
      return this.libroService.getLibros();
    }
    @PostMapping
    public ResponseEntity<Object> registroLibro(@RequestBody Libros libros){
        return this.libroService.newLibro(libros);
    }
    @PutMapping
    public ResponseEntity<Object> actLibro(@RequestBody Libros libros){
        return this.libroService.newLibro(libros);
    }

    @DeleteMapping(path = "{libroId}")
    public ResponseEntity<Object> deleteLibro(@PathVariable("libroId") int id){
        return this.libroService.deleteLibro(id);
    }
}
