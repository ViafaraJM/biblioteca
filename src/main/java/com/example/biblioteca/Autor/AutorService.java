package com.example.biblioteca.Autor;

import com.example.biblioteca.Libros.Libros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AutorService {
    HashMap<String, Object> datos;
    private final AutorRepository autorRepository;

    @Autowired
    public AutorService(AutorRepository autorRepository){
        this.autorRepository = autorRepository;
    }

    public List<Autor> getAutor(){
        return this.autorRepository.findAll();
    }


    public ResponseEntity<Object> newAutor(Autor autor) {
        Optional<Autor> res = autorRepository.findAutorByNombre(autor.getNombre());
        datos = new HashMap<>();
        if (res.isPresent() && autor.getId()==0){
            datos.put("error", true);
            datos.put("message", "Ya existe ese autor");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        datos.put("message", "Autor Registrado");
        if (autor.getId()>0){
            datos.put("message", "Autor Actualizado");
        }
        autorRepository.save(autor);
        datos.put("data", autor);
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> deleteAutor(int id){
        datos = new HashMap<>();
        boolean existe = this.autorRepository.existsById(id);
        if (!existe){
            datos.put("error", true);
            datos.put("message", "No existe ese autor");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        autorRepository.deleteById(id);
        datos.put("message", "Autor Eliminado");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }
}
