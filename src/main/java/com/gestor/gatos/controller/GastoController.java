package com.gestor.gatos.controller;

import com.gestor.gatos.model.DTO.NombreMontoDTO;
import com.gestor.gatos.model.Gasto;

import com.gestor.gatos.service.GastoService;
import com.gestor.gatos.service.IngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gasto")
public class GastoController {

    @Autowired
    private GastoService service;

    @Autowired
    private IngresoService serviceIngresos;

    // Crear o actualizar
    @PostMapping("/saveGasto")
    public ResponseEntity<Gasto> saveGasto(@RequestBody Gasto clasificacion) {
        Gasto nuevaGasto = service.saveGasto(clasificacion);
        return ResponseEntity.ok(nuevaGasto);
    }

    // Obtener por ID
    @GetMapping("/obtGasto/{id}")
    public ResponseEntity<Gasto> obtGastoPorId(@PathVariable Long id) {
        Optional<Gasto> clasificacion = service.obtGastoId(id);
        return clasificacion.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Listar
    @GetMapping("/listGastoes")
    public ResponseEntity<List<Gasto>> listGastoes() {
        List<Gasto> clasificaciones = service.listGastos();
        return ResponseEntity.ok(clasificaciones);
    }

    // Eliminar una Gasto por su ID
    @DeleteMapping("/deleteGasto/{id}")
    public ResponseEntity<Void> deleteGasto(@PathVariable Long id) {
        service.deleteGasto(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/gastosXusuario")
    public ResponseEntity<List<Gasto>> gastosXusuario(@RequestParam String username,
                                                      @RequestParam String fechadesde,
                                                      @RequestParam String fechahasta) {
        List<Gasto> gastos = service.gastoXusuario(username, fechadesde, fechahasta);
        return ResponseEntity.ok(gastos);
    }

    @GetMapping("/gastosXMetodoPago")
    public ResponseEntity<List<NombreMontoDTO>> gastosXMetodoPago(@RequestParam String username,
                                                                  @RequestParam(value = "metodoPago", required = false) String metodopago,
                                                                  @RequestParam String fechadesde,
                                                                  @RequestParam String fechahasta) {
        List<NombreMontoDTO> gastos = service.gastoXMetodoPago(username, metodopago, fechadesde, fechahasta);
        return ResponseEntity.ok(gastos);
    }

    @GetMapping("/gastosXcategoria")
    public ResponseEntity<List<NombreMontoDTO>> gastosXcategoria(@RequestParam String username,
                                                                 @RequestParam(value = "categoria", required = false) String categoria,
                                                                 @RequestParam String fechadesde,
                                                                 @RequestParam String fechahasta) {
        List<NombreMontoDTO> gastos = service.gastoXcategoria(username, categoria, fechadesde, fechahasta);
        return ResponseEntity.ok(gastos);
    }

    @GetMapping("/totalGastos")
    public ResponseEntity<Double> totalGastos(@RequestParam String username,
                                              @RequestParam String fechadesde,
                                              @RequestParam String fechahasta) {
        Double gastos = service.totalGastos(username, fechadesde, fechahasta);
        return ResponseEntity.ok(gastos);
    }

    @GetMapping("/saldo")
    public ResponseEntity<Double> saldo(@RequestParam String username,
                                        @RequestParam String fechadesde,
                                        @RequestParam String fechahasta) {
        Double gastos = service.totalGastos(username, fechadesde, fechahasta);
        Double ingresos = serviceIngresos.totalIngresos(username, fechadesde, fechahasta);
        return ResponseEntity.ok(ingresos - gastos);
    }
}
