package com.biblioteca.ms_biblioteca.repository;

import com.biblioteca.ms_biblioteca.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    Optional<UsuarioEntity> findByCodigo(String codigo);

    boolean existsByCodigo(String codigo);
}


