package com.gestor.gatos.service;



import com.gestor.gatos.model.MetodoPago;
import com.gestor.gatos.repository.MetodoPagoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MetodoPagoService {
    @Autowired
    private MetodoPagoRepository repository;

    // Crear o actualizar
    public MetodoPago saveMetodoPago(MetodoPago clasificacion) {
        return repository.save(clasificacion);
    }

    // Obtener por ID
    public Optional<MetodoPago> obtMetodoPagoId(String idMetodoPago) {
        return repository.findById(idMetodoPago);
    }

    // Listar
    public List<MetodoPago> listMetodoPagos() {
        return repository.findAll();
    }

    // Eliminar
    public void deleteMetodoPago(String idMetodoPago) {
        repository.deleteById(idMetodoPago);
    }
}
