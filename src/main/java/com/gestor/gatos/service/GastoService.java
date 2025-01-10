package com.gestor.gatos.service;



import com.gestor.gatos.model.DTO.NombreMontoDTO;
import com.gestor.gatos.model.Gasto;
import com.gestor.gatos.model.Gasto;
import com.gestor.gatos.repository.GastoRepository;
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
public class GastoService {
    @Autowired
    private GastoRepository repository;

    // Crear o actualizar
    public Gasto saveGasto(Gasto clasificacion) {
        return repository.save(clasificacion);
    }

    // Obtener por ID
    public Optional<Gasto> obtGastoId(Long idGasto) {
        return repository.findById(idGasto);
    }

    // Listar
    public List<Gasto> listGastos() {
        return repository.findAll();
    }

    // Eliminar
    public void deleteGasto(Long idGasto) {
        repository.deleteById(idGasto);
    }

    public List<Gasto> gastoXusuario(String username, String fechadesde, String fechahasta) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Timestamp fechaDesdeTimestamp = new Timestamp(dateFormat.parse(fechadesde).getTime());
            Timestamp fechaHastaTimestamp = new Timestamp(dateFormat.parse(fechahasta).getTime());

            return repository.gastosXusuario(username, fechaDesdeTimestamp, fechaHastaTimestamp);
        } catch (Exception e) {
            // Manejo de excepción
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<NombreMontoDTO> gastoXMetodoPago(String username, String metodopago, String fechadesde, String fechahasta) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Timestamp fechaDesdeTimestamp = new Timestamp(dateFormat.parse(fechadesde).getTime());
            Timestamp fechaHastaTimestamp = new Timestamp(dateFormat.parse(fechahasta).getTime());

            return repository.gastosXMetodoPago(username, metodopago, fechaDesdeTimestamp, fechaHastaTimestamp);
        } catch (Exception e) {
            // Manejo de excepción
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<NombreMontoDTO> gastoXcategoria(String username, String categoria, String fechadesde, String fechahasta) {
        try {
            System.out.println("+++++++++++++++++++++++=");
            System.out.println(categoria);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Timestamp fechaDesdeTimestamp = new Timestamp(dateFormat.parse(fechadesde).getTime());
            Timestamp fechaHastaTimestamp = new Timestamp(dateFormat.parse(fechahasta).getTime());

            return repository.gastosXcategoria(username, categoria, fechaDesdeTimestamp, fechaHastaTimestamp);
        } catch (Exception e) {
            // Manejo de excepción
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


    public Double totalGastos(String username, String fechadesde, String fechahasta) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Timestamp fechaDesdeTimestamp = new Timestamp(dateFormat.parse(fechadesde).getTime());
            Timestamp fechaHastaTimestamp = new Timestamp(dateFormat.parse(fechahasta).getTime());

            return repository.totalGastos(username, fechaDesdeTimestamp, fechaHastaTimestamp);
        } catch (Exception e) {
            // Manejo de excepción
            e.printStackTrace();
            return 0.00;
        }
    }
}
