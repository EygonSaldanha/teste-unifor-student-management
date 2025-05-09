package br.eygon.exeption;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GenericExceptionHandler implements ExceptionMapper<RuntimeException> {
    @Override
    public Response toResponse(RuntimeException ex) {
        return Response.status(Response.Status.UNAUTHORIZED)
                .entity(new ErrorDTO("Erro", ex.getMessage()))
                .build();
    }

    public record ErrorDTO(String titulo, String mensagem) {}
}
