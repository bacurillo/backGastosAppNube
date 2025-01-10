package com.gestor.gatos.controller;

import com.gestor.gatos.model.MetodoPago;
import com.gestor.gatos.service.MetodoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/metodoPago")
public class MetodoPagoController {

    @Autowired
    private MetodoPagoService service;

    // Crear o actualizar
    @PostMapping("/saveMetodoPago")
    public ResponseEntity<MetodoPago> saveMetodoPago(@RequestBody MetodoPago clasificacion) {
        MetodoPago nuevaMetodoPago = service.saveMetodoPago(clasificacion);
        return ResponseEntity.ok(nuevaMetodoPago);
    }

    // Obtener por ID
    @GetMapping("/obtMetodoPago/{id}")
    public ResponseEntity<MetodoPago> obtMetodoPagoPorId(@PathVariable String id) {
        Optional<MetodoPago> clasificacion = service.obtMetodoPagoId(id);
        return clasificacion.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Listar
    @GetMapping("/listMetodoPagoes")
    public ResponseEntity<List<MetodoPago>> listMetodoPagoes() {
        List<MetodoPago> clasificaciones = service.listMetodoPagos();
        return ResponseEntity.ok(clasificaciones);
    }

    // Eliminar una MetodoPago por su ID
    @DeleteMapping("/deleteMetodoPago/{id}")
    public ResponseEntity<Void> deleteMetodoPago(@PathVariable String id) {
        service.deleteMetodoPago(id);
        return ResponseEntity.noContent().build();
    }
}
