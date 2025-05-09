package br.eygon.service;

import br.eygon.dto.LoginDTO;
import br.eygon.dto.TokenResponseDTO;
import br.eygon.entity.Usuario;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import org.mindrot.jbcrypt.BCrypt;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

@ApplicationScoped
public class AuthService {

    public TokenResponseDTO login(LoginDTO dto) {
        Usuario usuario = Usuario.find("email", dto.email()).firstResult();

        if (usuario == null || !usuario.ativo || !BCrypt.checkpw(dto.senha(), usuario.senha)) {
            throw new RuntimeException("Credenciais inválidas ou usuário inativo");
        }

        String token = Jwt.issuer("auth")
                .upn(usuario.email)
                .groups(getGroups(usuario))
                .claim("id", usuario.id)
                .claim("nome", usuario.nome)
                .expiresIn(Duration.ofHours(3))
                .sign();

        return new TokenResponseDTO(token, usuario.id, usuario.nome, usuario.email);
    }

    private Set<String> getGroups(Usuario usuario) {
        Set<String> groups = new HashSet<>();
        groups.add(usuario.cargo.name());
        return groups;
    }
}
