package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.model.dto.AlunoDisciplinaDTO;
import org.acme.model.dto.DisciplinaDTO;
import org.acme.model.entity.AlunoDisciplina;
import org.acme.model.entity.Disciplina;
import org.acme.service.DisciplinaService;

import java.util.List;

@Path("/disciplinas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DisciplinaResource {

    @Inject
    DisciplinaService disciplinaService;

    @GET
    public List<Disciplina> listar() {
        return disciplinaService.listarTodas();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        Disciplina disciplina = disciplinaService.buscarPorId(id);
        return Response.ok(disciplina).build();
    }

    @POST
    public Response criar(DisciplinaDTO dto) {
        Disciplina criada = disciplinaService.criar(dto);
        return Response.status(Response.Status.CREATED).entity(criada).build();
    }

    @POST()
    @Path("/matricular")
    public Response matricularAluno(AlunoDisciplinaDTO dto){
        AlunoDisciplina matricula = disciplinaService.matricularAluno(dto);
        return Response.status(Response.Status.CREATED).entity(matricula).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, DisciplinaDTO dto) {
        Disciplina disciplina = disciplinaService.atualizar(id, dto);
        return Response.ok(disciplina).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        disciplinaService.deletar(id);
        return Response.noContent().build();
    }


}
