package com.gestor.gatos.service;


import com.gestor.gatos.model.Categoria;
import com.gestor.gatos.repository.CategoriaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;

    // Crear o actualizar
    public Categoria saveCategoria(Categoria clasificacion) {
        return repository.save(clasificacion);
    }

    // Obtener por ID
    public Optional<Categoria> obtCategoriaId(String idCategoria) {
        return repository.findById(idCategoria);
    }

    // Listar
    public List<Categoria> listCategorias() {
        return repository.findAll();
    }

    // Eliminar
    public void deleteCategoria(String idCategoria) {
        repository.deleteById(idCategoria);
    }

}
