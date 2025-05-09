package br.eygon.resource;

import br.eygon.dto.LoginDTO;
import br.eygon.dto.TokenResponseDTO;
import br.eygon.service.AuthService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {

    private final AuthService authService;

    public AuthResource(AuthService authService) {
        this.authService = authService;
    }
    @POST
    @Path("/login")
    public TokenResponseDTO login(LoginDTO dto) {
        return authService.login(dto);
    }
}
