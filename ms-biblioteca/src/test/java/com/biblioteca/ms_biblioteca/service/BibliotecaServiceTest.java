package com.biblioteca.ms_biblioteca.service;

import com.biblioteca.ms_biblioteca.constants.AppConstants;
import com.biblioteca.ms_biblioteca.entity.UsuarioEntity;
import com.biblioteca.ms_biblioteca.exception.BusinessException;
import com.biblioteca.ms_biblioteca.exception.NotFoundException;
import com.biblioteca.ms_biblioteca.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaServiceTest {

    private final UsuarioRepository repository = Mockito.mock(UsuarioRepository.class);
    private final BibliotecaService service = new BibliotecaService(repository);

    @Test
    void ingresarUsuario_ok() {
        Mockito.when(repository.count()).thenReturn(0L);
        Mockito.when(repository.existsByCodigo("ABC12345")).thenReturn(false);

        assertDoesNotThrow(() -> service.ingresarUsuario("ABC12345"));
        Mockito.verify(repository, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    void ingresarUsuario_codigoInvalido() {
        BusinessException ex = assertThrows(BusinessException.class, () ->
                service.ingresarUsuario("INVALID")
        );

        assertEquals(422, ex.getCode());
    }

    @Test
    void ingresarUsuario_aforoLleno() {
        Mockito.when(repository.count()).thenReturn((long) AppConstants.AFORO_MAXIMO);

        BusinessException ex = assertThrows(BusinessException.class, () ->
                service.ingresarUsuario("ABC12345")
        );

        assertEquals(401, ex.getCode());
    }

    @Test
    void ingresarUsuario_yaExiste() {
        Mockito.when(repository.count()).thenReturn(0L);
        Mockito.when(repository.existsByCodigo("ABC12345")).thenReturn(true);

        BusinessException ex = assertThrows(BusinessException.class, () ->
                service.ingresarUsuario("ABC12345")
        );

        assertEquals(401, ex.getCode());
    }

    @Test
    void salidaUsuario_ok() {
        Mockito.when(repository.findByCodigo("ABC12345"))
                .thenReturn(Optional.of(new UsuarioEntity("ABC12345")));

        assertDoesNotThrow(() -> service.salidaUsuario("ABC12345"));
        Mockito.verify(repository, Mockito.times(1)).delete(Mockito.any());
    }

    @Test
    void salidaUsuario_noExiste() {
        Mockito.when(repository.findByCodigo("ABC12345"))
                .thenReturn(Optional.empty());

        NotFoundException ex = assertThrows(NotFoundException.class, () -> service.salidaUsuario("ABC12345"));

        assertEquals("El usuario no existe", ex.getMessage());
    }
}

