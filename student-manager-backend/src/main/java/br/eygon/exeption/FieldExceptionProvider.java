package br.eygon.exeption;

import br.eygon.model.ErrorField;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class FieldExceptionProvider implements ExceptionMapper<FieldException> {
    @Override
    public Response toResponse(FieldException e) {
        return Response.status(400).entity(new ErrorField(e.getField(), e.getMessage()))
                .type(MediaType.APPLICATION_JSON).build();
    }
}