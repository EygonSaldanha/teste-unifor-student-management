package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.model.dto.AlunoComUsuarioDTO;
import org.acme.model.dto.UsuarioDTO;
import org.acme.model.entity.Aluno;
import org.acme.service.AlunoService;

import java.util.List;

@Path("/alunos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AlunoResource {

    @Inject
    AlunoService alunoService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Aluno> list() {
        return alunoService.listarTodos();
    }
    @GET
    @Path("/usuario")
    public Response buscarAlunoComUsuario(@PathParam("id") Long id) {
        List<AlunoComUsuarioDTO> aluno = alunoService.buscarAlunoComUsuario();
        return Response.ok(aluno).build();
    }

    @GET
    @Path("/usuario/{id}")
    public Response buscarAlunoComUsuarioPorId(@PathParam("id") Long id) {
        AlunoComUsuarioDTO aluno = alunoService.buscarAlunoComUsuarioPorId(id);
        return Response.ok(aluno).build();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        Aluno aluno = alunoService.buscarPorId(id);
        return Response.ok(aluno).build();
    }

    @POST
    @Transactional
    public Response criarAluno(UsuarioDTO dto){
        Aluno aluno = alunoService.salvarUsuario(dto);
        return Response.status(Response.Status.CREATED).entity(aluno).build();

    }
    @PUT
    @Path("/{id}")
    @Transactional
    public Response atualizarAluno(@PathParam("id") Long id, UsuarioDTO dto) {
        Aluno atualizado = alunoService.atualizarAluno(id, dto);
        if (atualizado == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(atualizado).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletarAluno(@PathParam("id") Long id) {
        alunoService.deletarAluno(id);
        return Response.noContent().build();
    }
}
