package com.apidemo1.apidemo1.controller;

import com.apidemo1.apidemo1.entity.Articulo;
import com.apidemo1.apidemo1.service.ArticuloService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-demo/articulos")
public class ArticuloController {

    @Autowired
    private ArticuloService service;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Articulo>> getAll() {
        List<Articulo> articulos = service.getAll();

        if (articulos == null || articulos.size() == 0) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(articulos);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Articulo> getById(@PathVariable(name = "id") final long id) {
        Optional<Articulo> optionalArticulo = service.getArticuloById(id);

        if (!optionalArticulo.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(optionalArticulo.get());
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Articulo> create(@RequestBody Articulo articulo) {
        Articulo newArticulo = service.createArticulo(articulo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newArticulo);
    }

    @ApiOperation(value = "Actualiza un articulo por su id")
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Articulo> update(@PathVariable(name = "id") final long id,
                                           @RequestBody Articulo articulo) {
        Articulo articuloActualizado = service.updateArticulo(id, articulo);

        if (articuloActualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(articuloActualizado);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Articulo> deleteById(@PathVariable(name = "id") final long id) {

        Optional<Articulo> optionalArticulo = service.getArticuloById(id);

        if (optionalArticulo.isPresent()) {
            Articulo articulo = service.deleteArticuloById(id);

            if (articulo == null) {
                return ResponseEntity.ok(optionalArticulo.get());
            }

        }

        return ResponseEntity.notFound().build();
    }


}
