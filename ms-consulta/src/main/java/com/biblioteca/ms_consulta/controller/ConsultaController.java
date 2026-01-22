package com.biblioteca.ms_consulta.controller;

import com.biblioteca.ms_consulta.service.ConsultaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsultaController {

    private final ConsultaService service;

    public ConsultaController(ConsultaService service) {
        this.service = service;
    }

    @GetMapping("/consulta/usuarios")
    public ResponseEntity<?> consultar(
            @RequestHeader(value = "MyFlag", required = false) Boolean myFlag
    ) {
        return ResponseEntity.ok(service.consultarUsuarios(myFlag));
    }
}












