package com.gestor.gatos.repository.genericRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface GenericRepository <T, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
}