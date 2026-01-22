package com.biblioteca.ms_consulta.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.Map;

@FeignClient(
        name = "ms1",
        url = "${ms1.url}"
)
public interface BibliotecaClient {

    @GetMapping("/usuarios")
    List<Map<String, Object>> obtenerUsuarios(
            @RequestHeader(value = "MyFlag", required = false) Boolean myFlag
    );
}















