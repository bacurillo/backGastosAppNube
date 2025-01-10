package com.gestor.gatos.controller;

import com.gestor.gatos.model.Categoria;
import com.gestor.gatos.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService service;
    
    // Crear o actualizar
    @PostMapping("/saveCategoria")
    public ResponseEntity<Categoria> saveCategoria(@RequestBody Categoria clasificacion) {
        Categoria nuevaCategoria = service.saveCategoria(clasificacion);
        return ResponseEntity.ok(nuevaCategoria);
    }

    // Obtener por ID
    @GetMapping("/obtCategoria/{id}")
    public ResponseEntity<Categoria> obtCategoriaPorId(@PathVariable String id) {
        Optional<Categoria> clasificacion = service.obtCategoriaId(id);
        return clasificacion.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Listar
    @GetMapping("/listCategoriaes")
    public ResponseEntity<List<Categoria>> listCategoriaes() {
        List<Categoria> clasificaciones = service.listCategorias();
        return ResponseEntity.ok(clasificaciones);
    }

    // Eliminar una Categoria por su ID
    @DeleteMapping("/deleteCategoria/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable String id) {
        service.deleteCategoria(id);
        return ResponseEntity.noContent().build();
    }
}
