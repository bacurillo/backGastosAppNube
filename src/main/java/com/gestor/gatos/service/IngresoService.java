package com.gestor.gatos.service;


import com.gestor.gatos.model.DTO.NombreMontoDTO;
import com.gestor.gatos.model.Ingreso;
import com.gestor.gatos.repository.IngresoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IngresoService {
    @Autowired
    private IngresoRepository repository;

    // Crear o actualizar
    public Ingreso saveIngreso(Ingreso clasificacion) {
        return repository.save(clasificacion);
    }

    // Obtener por ID
    public Optional<Ingreso> obtIngresoId(Long idIngreso) {
        return repository.findById(idIngreso);
    }

    // Listar
    public List<Ingreso> listIngresos() {
        return repository.findAll();
    }

    // Listar
    public List<Ingreso> ingresosXusuario(String username, String fechadesde, String fechahasta) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Timestamp fechaDesdeTimestamp = new Timestamp(dateFormat.parse(fechadesde).getTime());
            Timestamp fechaHastaTimestamp = new Timestamp(dateFormat.parse(fechahasta).getTime());

            return repository.ingresosXusuario(username, fechaDesdeTimestamp, fechaHastaTimestamp);
        } catch (Exception e) {
            // Manejo de excepción
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<NombreMontoDTO> ingresosXMetodoPago(String username, String metodopago, String fechadesde, String fechahasta) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Timestamp fechaDesdeTimestamp = new Timestamp(dateFormat.parse(fechadesde).getTime());
            Timestamp fechaHastaTimestamp = new Timestamp(dateFormat.parse(fechahasta).getTime());

            return repository.ingresosXMetodoPago(username, metodopago, fechaDesdeTimestamp, fechaHastaTimestamp);
        } catch (Exception e) {
            // Manejo de excepción
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<NombreMontoDTO> ingresosXcategoria(String username, String categoria, String fechadesde, String fechahasta) {
        try {
            System.out.println("+++++++++++++++++++++++=");
            System.out.println(categoria);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Timestamp fechaDesdeTimestamp = new Timestamp(dateFormat.parse(fechadesde).getTime());
            Timestamp fechaHastaTimestamp = new Timestamp(dateFormat.parse(fechahasta).getTime());

            return repository.ingresosXcategoria(username, categoria, fechaDesdeTimestamp, fechaHastaTimestamp);
        } catch (Exception e) {
            // Manejo de excepción
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


    public Double totalIngresos(String username, String fechadesde, String fechahasta) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Timestamp fechaDesdeTimestamp = new Timestamp(dateFormat.parse(fechadesde).getTime());
            Timestamp fechaHastaTimestamp = new Timestamp(dateFormat.parse(fechahasta).getTime());

            return repository.totalIngresos(username, fechaDesdeTimestamp, fechaHastaTimestamp);
        } catch (Exception e) {
            // Manejo de excepción
            e.printStackTrace();
            return 0.00;
        }
    }
    // Eliminar
    public void deleteIngreso(Long idIngreso) {
        repository.deleteById(idIngreso);
    }
}
