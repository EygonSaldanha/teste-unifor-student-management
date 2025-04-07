package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.model.dto.UsuarioDTO;
import org.acme.model.entity.Usuario;
import org.acme.service.UsuarioService;

import java.util.List;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    UsuarioService usuarioService;

    @GET
    public List<Usuario> listarTodos() {
        return usuarioService.listarTodos();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        Usuario usuario = usuarioService.buscarPorId(id);
        return Response.ok(usuario).build();
    }

    @POST
    @Transactional
    public Response criarUsuario(UsuarioDTO dto) {
        Usuario usuario = usuarioService.criarUsuario(dto);
        return Response.status(Response.Status.CREATED).entity(usuario).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response atualizarUsuario(@PathParam("id") Long id, UsuarioDTO dto) {
        Usuario usuario = usuarioService.atualizarUsuario(id, dto);
        return Response.ok(usuario).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletarUsuario(@PathParam("id") Long id) {
        usuarioService.deletarUsuario(id);
        return Response.noContent().build();
    }
}
