package br.eygon.exeption;

import br.eygon.model.ErrorField;
import io.quarkus.hibernate.validator.runtime.jaxrs.ResteasyReactiveViolationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

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
