package com.biblioteca.ms_biblioteca.service;

import com.biblioteca.ms_biblioteca.entity.UsuarioEntity;
import com.biblioteca.ms_biblioteca.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotecaService {

    private final UsuarioRepository usuarioRepository;

    public BibliotecaService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioEntity> consultarUsuarios(String myFlag) {

        if ("true".equalsIgnoreCase(myFlag)) {
            try {
                Thread.sleep(8000); // Delay EXACTO
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        return usuarioRepository.findAll();
    }
}




