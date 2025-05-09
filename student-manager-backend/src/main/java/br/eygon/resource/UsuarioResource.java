package br.eygon.resource;

import br.eygon.dto.UsuarioDTO;
import br.eygon.entity.Usuario;
import br.eygon.service.DisciplinaService;
import br.eygon.service.UsuarioService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/usuarios")
public class UsuarioResource {

    private final UsuarioService usuarioService;

    public UsuarioResource(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GET
    @RolesAllowed("ADMIN")
    public List<Usuario> listarTodos() {
        return usuarioService.listarTodos();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed("ADMIN")
    public Response buscarPorId(@PathParam("id") Long id) {
        Usuario usuario = usuarioService.buscarPorId(id);
        return Response.ok(usuario).build();
    }

    @POST
    @Transactional
    @RolesAllowed("ADMIN")
    public Response criarUsuario(UsuarioDTO dto) {
        Usuario usuario = usuarioService.criarUsuario(dto);
        return Response.status(Response.Status.CREATED).entity(usuario).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @RolesAllowed("ADMIN")
    public Response atualizarUsuario(@PathParam("id") Long id, UsuarioDTO dto) {
        Usuario usuario = usuarioService.atualizarUsuario(id, dto);
        return Response.ok(usuario).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @RolesAllowed("ADMIN")
    public Response deletarUsuario(@PathParam("id") Long id) {
        usuarioService.deletarUsuario(id);
        return Response.noContent().build();
    }
}
