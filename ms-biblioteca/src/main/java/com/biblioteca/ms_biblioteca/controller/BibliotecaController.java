package com.biblioteca.ms_biblioteca.controller;

import com.biblioteca.ms_biblioteca.entity.UsuarioEntity;
import com.biblioteca.ms_biblioteca.service.BibliotecaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class BibliotecaController {

    private final BibliotecaService bibliotecaService;

    public BibliotecaController(BibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }

    @GetMapping
    public List<UsuarioEntity> consultarUsuarios(
            @RequestHeader(value = "MyFlag", required = false) String myFlag
    ) {
        return bibliotecaService.consultarUsuarios(myFlag);
    }
}





