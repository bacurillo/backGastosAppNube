package com.gestor.gatos.controller;

import com.gestor.gatos.model.Usuario;
import com.gestor.gatos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    // Crear o actualizar
    @PostMapping("/saveUsuario")
    public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario) {
        Usuario nuevaUsuario = service.saveUsuario(usuario);
        return ResponseEntity.ok(nuevaUsuario);
    }

    // Obtener por ID
    @GetMapping("/obtUsuario/{id}")
    public ResponseEntity<Usuario> obtUsuarioPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = service.obtUsuarioId(id);
        return usuario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Listar
    @GetMapping("/listUsuarioes")
    public ResponseEntity<List<Usuario>> listUsuarioes() {
        List<Usuario> clasificaciones = service.listUsuarios();
        return ResponseEntity.ok(clasificaciones);
    }

    // Eliminar una Usuario por su ID
    @DeleteMapping("/deleteUsuario/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        service.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/login")
    public ResponseEntity<Usuario> login(@RequestParam String username,
                                             @RequestParam String password) {
        Optional<Usuario> usuario = service.login(username, password);
        return usuario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }


}
