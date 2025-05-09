package br.eygon.resource;

import br.eygon.dto.AlunoComUsuarioDTO;
import br.eygon.dto.UsuarioDTO;
import br.eygon.entity.Aluno;
import br.eygon.service.AlunoService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/alunos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AlunoResource {

    private final AlunoService alunoService;

    public AlunoResource(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("ADMIN")
    public List<Aluno> list() {
        return alunoService.listarTodos();
    }
    
    @GET
    @Path("/usuario")
    @RolesAllowed("ADMIN")
    public Response buscarAlunoComUsuario(@PathParam("id") Long id) {
        List<AlunoComUsuarioDTO> aluno = alunoService.buscarAlunoComUsuario();
        return Response.ok(aluno).build();
    }

    @GET
    @Path("/usuario/{id}")
    @RolesAllowed("ADMIN")
    public Response buscarAlunoComUsuarioPorId(@PathParam("id") Long id) {
        AlunoComUsuarioDTO aluno = alunoService.buscarAlunoComUsuarioPorId(id);
        return Response.ok(aluno).build();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed("ADMIN")
    public Response buscarPorId(@PathParam("id") Long id) {
        Aluno aluno = alunoService.buscarPorId(id);
        return Response.ok(aluno).build();
    }

    @POST
    @Transactional
    @RolesAllowed("ADMIN")
    public Response criarAluno(UsuarioDTO dto){
        Aluno aluno = alunoService.salvarUsuario(dto);
        return Response.status(Response.Status.CREATED).entity(aluno).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @RolesAllowed("ADMIN")
    public Response atualizarAluno(@PathParam("id") Long id, UsuarioDTO dto) {
        Aluno atualizado = alunoService.atualizarAluno(id, dto);
        return Response.ok(atualizado).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @RolesAllowed("ADMIN")
    public Response deletarAluno(@PathParam("id") Long id) {
        alunoService.deletarAluno(id);
        return Response.noContent().build();
    }
}
