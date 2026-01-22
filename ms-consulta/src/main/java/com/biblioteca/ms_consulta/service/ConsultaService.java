package com.biblioteca.ms_consulta.service;

import com.biblioteca.ms_consulta.client.BibliotecaClient;
import com.biblioteca.ms_consulta.exception.BusinessException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ConsultaService {

    private final BibliotecaClient client;

    public ConsultaService(BibliotecaClient client) {
        this.client = client;
    }

    @CircuitBreaker(
            name = "ms1CircuitBreaker",
            fallbackMethod = "fallbackConsultarUsuarios"
    )
    public List<Map<String, Object>> consultarUsuarios(Boolean myFlag) {
        // llamada NORMAL a MS1
        return client.obtenerUsuarios(myFlag);
    }

    /**
     * ESTE fallback SOLO SE EJECUTA CUANDO:
     * - MS1 tarda más del timeout
     * - CircuitBreaker se abre
     */
    public List<Map<String, Object>> fallbackConsultarUsuarios(Boolean myFlag, Throwable ex) {
        throw new BusinessException(400, "El MS 1 tardo mas de lo esperado");
    }
}


















