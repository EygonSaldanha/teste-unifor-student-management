package br.eygon.resource;

import br.eygon.dto.LoginDTO;
import br.eygon.dto.TokenResponseDTO;
import br.eygon.service.AuthService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {

    @Inject
    AuthService authService;

    @POST
    @Path("/login")
    public TokenResponseDTO login(LoginDTO dto) {
        return authService.login(dto);
    }
}
