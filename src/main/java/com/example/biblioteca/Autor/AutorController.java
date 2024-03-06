package com.example.biblioteca.Autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/autores")
public class AutorController {
    private final AutorService autorService;
    @Autowired
    public AutorController(AutorService autorService){
        this.autorService = autorService;
    }
    @GetMapping
    public List<Autor> getAutor(){
        return this.autorService.getAutor();
    }
    @PostMapping
    public ResponseEntity<Object> registroAutor(@RequestBody Autor autor){
        return this.autorService.newAutor(autor);
    }
    @PutMapping
    public ResponseEntity<Object> actAutor(@RequestBody Autor autor){
        return this.autorService.newAutor(autor);
    }

    @DeleteMapping(path = "{autorId}")
    public ResponseEntity<Object> deleteAutor(@PathVariable("autorId") int id){
        return this.autorService.deleteAutor(id);
    }
}
