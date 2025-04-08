package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.acme.model.dto.UsuarioDTO;
import org.acme.model.entity.Usuario;
import org.acme.model.enums.CargoEnum;

import java.util.List;

@ApplicationScoped
public class UsuarioService {

    public List<Usuario> listarTodos() {
        return Usuario.listAll();
    }

    public Usuario buscarPorId(Long id) {
        Usuario usuario = Usuario.findById(id);
        if (usuario == null) {
            throw new NotFoundException("Usuário não encontrado");
        }
        return usuario;
    }

    @Transactional
    public Usuario criarUsuario(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setCpf(dto.cpf());
        usuario.setCargo(CargoEnum.valueOf(dto.cargo().toUpperCase()));
        usuario.setStatus(true);
        usuario.persist();
        return usuario;
    }

    @Transactional
    public Usuario atualizarUsuario(Long id, UsuarioDTO dto) {
        Usuario usuario = Usuario.findById(id);
        if (usuario == null) {
            throw new NotFoundException("Usuário não encontrado");
        }
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setCpf(dto.cpf());
        usuario.setCargo(CargoEnum.valueOf(dto.cargo().toUpperCase()));
        usuario.persist();
        return usuario;
    }

    @Transactional
    public void deletarUsuario(Long id) {
        Usuario usuario = Usuario.findById(id);
        if (usuario == null) {
            throw new NotFoundException("Usuário não encontrado");
        }
        usuario.delete();
    }
}
