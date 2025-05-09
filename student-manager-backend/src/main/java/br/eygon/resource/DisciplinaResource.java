package br.eygon.resource;

import br.eygon.dto.AlunoDisciplinaDTO;
import br.eygon.dto.AlunoResumoDTO;
import br.eygon.dto.DisciplinaDTO;
import br.eygon.entity.AlunoDisciplina;
import br.eygon.entity.Disciplina;
import br.eygon.service.DisciplinaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/disciplinas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DisciplinaResource {

    private final DisciplinaService disciplinaService;

    public DisciplinaResource(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

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

    @GET
    @Path("/por-aluno")
    public List<AlunoResumoDTO> listarAlunosPorDisciplina(@QueryParam("id") Long id){
        return disciplinaService.listarAlunosPorDisciplina(id);
    }

}
