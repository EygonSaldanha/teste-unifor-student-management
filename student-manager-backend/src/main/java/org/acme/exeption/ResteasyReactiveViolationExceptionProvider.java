package org.acme.exeption;

import io.quarkus.hibernate.validator.runtime.jaxrs.ResteasyReactiveViolationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.acme.model.ErrorField;

import java.util.ArrayList;
import java.util.List;

@Provider
public class ResteasyReactiveViolationExceptionProvider implements ExceptionMapper<ResteasyReactiveViolationException> {

    @Override
    public Response toResponse(ResteasyReactiveViolationException e) {
        List<ErrorField> errs = new ArrayList<>();
        e.getConstraintViolations().forEach(err -> errs.add(new ErrorField(err.getPropertyPath().iterator(), err.getMessage())));
        return Response.status(400).entity(new ExceptionDTO("Erro no formulário enviado!", errs))
                .type(MediaType.APPLICATION_JSON).build();
    }
}

@Provider
class FieldExceptionProvider implements ExceptionMapper<FieldException> {
    @Override
    public Response toResponse(FieldException e) {
        return Response.status(400).entity(new ErrorField(e.getField(), e.getMessage()))
                .type(MediaType.APPLICATION_JSON).build();
    }
}