package br.eygon.service;

import br.eygon.dto.UsuarioDTO;
import br.eygon.entity.Usuario;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

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
        usuario.nome = dto.nome();
        usuario.email = dto.email();
        usuario.cpf = dto.cpf();
        usuario.cargo = dto.cargo();
        usuario.isAtivo = true;
        usuario.persist();
        return usuario;
    }

    @Transactional
    public Usuario atualizarUsuario(Long id, UsuarioDTO dto) {
        Usuario usuario = Usuario.findById(id);
        if (usuario == null) {
            throw new NotFoundException("Usuário não encontrado");
        }
        usuario.nome = dto.nome();
        usuario.email = dto.email();
        usuario.cpf = dto.cpf();
        usuario.cargo = dto.cargo();
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
