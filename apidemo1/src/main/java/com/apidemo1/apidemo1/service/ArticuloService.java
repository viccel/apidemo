package com.apidemo1.apidemo1.service;

import com.apidemo1.apidemo1.entity.Articulo;

import java.util.List;
import java.util.Optional;

public interface ArticuloService {
    /**
     * Obtiene todos los articulos.
     * @return Lista de articulos
     */
    List<Articulo> getAll();

    Optional<Articulo> getArticuloById(Long id);
    Articulo createArticulo(Articulo articulo);
    Articulo updateArticulo(long id, Articulo articulo);
    Articulo deleteArticuloById(long id);
}
