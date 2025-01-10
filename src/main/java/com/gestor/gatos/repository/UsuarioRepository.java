package com.gestor.gatos.repository;

import com.gestor.gatos.model.Usuario;
import com.gestor.gatos.repository.genericRepository.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends GenericRepository<Usuario, Long> {


    @Query(value = "SELECT id_usuario, email, fecha_creacion, null password, username " +
            "FROM usuario " +
            "WHERE username =:username " +
            "  AND password =:password ",
            nativeQuery = true)
    Optional<Usuario> login(@Param("username") String username,
                            @Param("password") String password);
}
