package com.gestor.gatos.controller;

import com.gestor.gatos.model.DTO.NombreMontoDTO;
import com.gestor.gatos.model.Ingreso;
import com.gestor.gatos.service.IngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ingreso")
public class IngresoController {
    @Autowired
    private IngresoService service;
    SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy"); // Define el formato

    // Crear o actualizar
    @PostMapping("/saveIngreso")
    public ResponseEntity<Ingreso> saveIngreso(@RequestBody Ingreso clasificacion) {
        Ingreso nuevaIngreso = service.saveIngreso(clasificacion);
        return ResponseEntity.ok(nuevaIngreso);
    }

    // Obtener por ID
    @GetMapping("/obtIngreso/{id}")
    public ResponseEntity<Ingreso> obtIngresoPorId(@PathVariable Long id) {
        Optional<Ingreso> ingresos = service.obtIngresoId(id);
        return ingresos.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Listar
    @GetMapping("/ingresosXusuario")
    public ResponseEntity<List<Ingreso>> ingresosXusuario(@RequestParam String username,
                                                          @RequestParam String fechadesde,
                                                          @RequestParam String fechahasta) {
        List<Ingreso> ingresos = service.ingresosXusuario(username, fechadesde, fechahasta);
        return ResponseEntity.ok(ingresos);
    }

    @GetMapping("/ingresosXMetodoPago")
    public ResponseEntity<List<NombreMontoDTO>> ingresosXMetodoPago(@RequestParam String username,
                                                                        @RequestParam(value = "metodoPago", required = false) String metodopago,
                                                                        @RequestParam String fechadesde,
                                                                        @RequestParam String fechahasta) {
        List<NombreMontoDTO> ingresos = service.ingresosXMetodoPago(username, metodopago, fechadesde, fechahasta);
        return ResponseEntity.ok(ingresos);
    }

    @GetMapping("/ingresosXcategoria")
    public ResponseEntity<List<NombreMontoDTO>> ingresosXcategoria(@RequestParam String username,
                                                                       @RequestParam(value = "categoria", required = false) String categoria,
                                                                       @RequestParam String fechadesde,
                                                                       @RequestParam String fechahasta) {
        List<NombreMontoDTO> ingresos = service.ingresosXcategoria(username, categoria, fechadesde, fechahasta);
        return ResponseEntity.ok(ingresos);
    }

    @GetMapping("/totalIngresos")
    public ResponseEntity<Double> totalIngresos(@RequestParam String username,
                                                          @RequestParam String fechadesde,
                                                          @RequestParam String fechahasta) {
        Double ingresos = service.totalIngresos(username, fechadesde, fechahasta);
        return ResponseEntity.ok(ingresos);
    }

    // Listar
    @GetMapping("/listIngresoes")
    public ResponseEntity<List<Ingreso>> listIngresoes() {
        List<Ingreso> clasificaciones = service.listIngresos();
        return ResponseEntity.ok(clasificaciones);
    }

    // Eliminar una Ingreso por su ID
    @DeleteMapping("/deleteIngreso/{id}")
    public ResponseEntity<Void> deleteIngreso(@PathVariable Long id) {
        service.deleteIngreso(id);
        return ResponseEntity.noContent().build();
    }
}
