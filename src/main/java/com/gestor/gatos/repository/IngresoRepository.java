package com.gestor.gatos.repository;

import com.gestor.gatos.model.DTO.NombreMontoDTO;
import com.gestor.gatos.model.Ingreso;
import com.gestor.gatos.repository.genericRepository.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public interface IngresoRepository extends GenericRepository<Ingreso, Long> {
    @Query(value = "SELECT i.* " +
            "FROM ingreso i " +
            "JOIN usuario u ON i.id_usuario = u.id_usuario " +
            "WHERE u.username =:username " +
            "AND DATE_TRUNC('day', i.fecha) BETWEEN DATE_TRUNC('day', CAST(:fechadesde AS TIMESTAMP)) AND DATE_TRUNC('day', CAST(:fechahasta AS TIMESTAMP))",
            nativeQuery = true)
    List<Ingreso> ingresosXusuario(@Param("username") String username,
                                   @Param("fechadesde") Timestamp fechadesde,
                                   @Param("fechahasta") Timestamp fechahasta);

    @Query(value = "SELECT p.nombre, sum(i.monto) " +
            "FROM ingreso i " +
            "JOIN usuario u ON i.id_usuario = u.id_usuario " +
            "JOIN metodo_pago p ON p.id_metodo_pago = i.id_metodo_pago " +
            "WHERE u.username =:username " +
            "AND DATE_TRUNC('day', i.fecha) BETWEEN DATE_TRUNC('day', CAST(:fechadesde AS TIMESTAMP)) AND DATE_TRUNC('day', CAST(:fechahasta AS TIMESTAMP)) " +
            "AND (p.id_metodo_pago =:metodopago OR :metodopago is null) " +
            "group by p.id_metodo_pago",
            nativeQuery = true)
    List<NombreMontoDTO> ingresosXMetodoPago(@Param("username") String username,
                                                 @Param("metodopago") String metodopago,
                                                 @Param("fechadesde") Timestamp fechadesde,
                                                 @Param("fechahasta") Timestamp fechahasta);

    @Query(value = "SELECT c.nombre, sum(i.monto) " +
            "FROM ingreso i " +
            "JOIN usuario u ON i.id_usuario = u.id_usuario " +
            "JOIN categoria c ON c.id_categoria = i.id_categoria " +
            "WHERE u.username =:username " +
            "AND DATE_TRUNC('day', i.fecha) BETWEEN DATE_TRUNC('day', CAST(:fechadesde AS TIMESTAMP)) AND DATE_TRUNC('day', CAST(:fechahasta AS TIMESTAMP)) " +
            "AND (c.id_categoria =:categoria OR :categoria is null) " +
            "group by c.id_categoria",
            nativeQuery = true)
    List<NombreMontoDTO> ingresosXcategoria(@Param("username") String username,
                                                @Param("categoria") String categoria,
                                                @Param("fechadesde") Timestamp fechadesde,
                                                @Param("fechahasta") Timestamp fechahasta);

    @Query(value = "SELECT sum(i.monto) " +
            "FROM ingreso i " +
            "JOIN usuario u ON i.id_usuario = u.id_usuario " +
            "WHERE u.username =:username " +
            "AND DATE_TRUNC('day', i.fecha) BETWEEN DATE_TRUNC('day', CAST(:fechadesde AS TIMESTAMP)) AND DATE_TRUNC('day', CAST(:fechahasta AS TIMESTAMP)) ",
            nativeQuery = true)
    Double totalIngresos(@Param("username") String username,
                         @Param("fechadesde") Timestamp fechadesde,
                         @Param("fechahasta") Timestamp fechahasta);

}
