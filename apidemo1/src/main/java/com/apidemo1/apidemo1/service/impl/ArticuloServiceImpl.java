package com.apidemo1.apidemo1.service.impl;

import com.apidemo1.apidemo1.entity.Articulo;
import com.apidemo1.apidemo1.repository.ArticuloRepository;
import com.apidemo1.apidemo1.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticuloServiceImpl implements ArticuloService {
    @Autowired
    ArticuloRepository repository;

    /**
     * Obtiene todos los articulos.
     *
     * @return Lista de articulos
     */
    @Override
    public List<Articulo> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Articulo> getArticuloById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Articulo createArticulo(Articulo articulo) {
        Articulo savedArticulo = repository.save(articulo);
        return savedArticulo;
    }

    @Override
    public Articulo updateArticulo(final long id, final Articulo articulo) {

        Optional<Articulo> optionalArticulo = repository.findById(id);

        if (optionalArticulo.isPresent()) {
            Articulo updatedArticulo = optionalArticulo.get();
            updatedArticulo.setDescripcion(articulo.getDescripcion());
            updatedArticulo.setModelo(articulo.getModelo());
            Articulo myUpdatedArticulo = repository.save(updatedArticulo);

            return myUpdatedArticulo;
        }

        return null;
    }

    @Override
    public Articulo deleteArticuloById(long id) {

        repository.deleteById(id);
        Optional<Articulo> optArticulo = repository.findById(id);

        if (optArticulo.isPresent()) {
            System.out.println("No se eliminó");
            return optArticulo.get();
        }

        return null;
    }
}
