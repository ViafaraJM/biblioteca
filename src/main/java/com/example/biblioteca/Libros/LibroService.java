package com.example.biblioteca.Libros;

import com.example.biblioteca.Autor.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
    HashMap<String, Object> datos;
    private final LibrosRepository librosRepository;

    @Autowired
    public LibroService(LibrosRepository librosRepository){
        this.librosRepository = librosRepository;
    }

    public List<Libros> getLibros(){
        return this.librosRepository.findAll();
    }

    public ResponseEntity<Object> newLibro(Libros libros) {
        Optional<Libros> res = librosRepository.findLibroByTitulo(libros.getTitulo());
        datos = new HashMap<>();
        if (res.isPresent() && libros.getId()==0){
            datos.put("error", true);
            datos.put("message", "Ya existe ese libro");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        datos.put("message", "Libro Registrado");
        if (libros.getId()>0){
            datos.put("message", "Libro Actualizado");
        }
        librosRepository.save(libros);
        datos.put("data", libros);
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }
    public ResponseEntity<Object> deleteLibro(int id){
        datos = new HashMap<>();
        boolean existe = this.librosRepository.existsById(id);
        if (!existe){
            datos.put("error", true);
            datos.put("message", "No existe ese libro");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        librosRepository.deleteById(id);
        datos.put("message", "Libro Eliminado");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }
}
