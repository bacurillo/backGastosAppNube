package com.gestor.gatos.service;

import com.gestor.gatos.model.Usuario;
import com.gestor.gatos.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    // Crear o actualizar
    public Usuario saveUsuario(Usuario clasificacion) {
        return repository.save(clasificacion);
    }

    // Obtener por ID
    public Optional<Usuario> obtUsuarioId(Long idUsuario) {
        return repository.findById(idUsuario);
    }

    // Listar
    public List<Usuario> listUsuarios() {
        return repository.findAll();
    }

    // Eliminar
    public void deleteUsuario(Long idUsuario) {
        repository.deleteById(idUsuario);
    }

    public Optional<Usuario> login(String username, String password) {
        return repository.login(username, password);
    }
}
