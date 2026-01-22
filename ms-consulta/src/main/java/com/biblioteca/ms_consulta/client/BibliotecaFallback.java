package com.biblioteca.ms_consulta.client;

import com.biblioteca.ms_consulta.exception.BusinessException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class BibliotecaFallback implements BibliotecaClient {

    @Override
    public List<Map<String, Object>> obtenerUsuarios(Boolean myFlag) {
        // FALLBACK SOLO CUANDO MS1 ESTÁ REALMENTE APAGADO
        throw new BusinessException(
                500,
                "El MS 1 se encuentra fuera de linea"
        );
    }
}


