package com.gestor.gatos.repository;

import com.gestor.gatos.model.Categoria;
import com.gestor.gatos.model.MetodoPago;
import com.gestor.gatos.repository.genericRepository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends GenericRepository<Categoria, String> {
}
