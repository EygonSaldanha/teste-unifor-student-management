package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.acme.model.dto.AlunoComUsuarioDTO;
import org.acme.model.dto.UsuarioDTO;
import org.acme.model.entity.Aluno;
import org.acme.model.entity.Usuario;
import org.acme.model.enums.CargoEnum;

import java.util.List;

@ApplicationScoped
public class AlunoService {

    public List<Aluno> listarTodos(){
        return Aluno.listAll();
    }

    public Aluno buscarPorId(Long id){
        Aluno aluno = Aluno.findById(id);
        if (aluno == null){
            throw new NotFoundException("Aluno não encontrado");
        }
        return aluno;
    }

    public List<AlunoComUsuarioDTO> buscarAlunoComUsuario() {
        List<Aluno> alunos = Aluno.listAll();
        return alunos.stream()
                .map(aluno -> new AlunoComUsuarioDTO(
                        aluno.id,
                        aluno.matricula,
                        aluno.usuario
                ))
                .toList();
    }

    public AlunoComUsuarioDTO buscarAlunoComUsuarioPorId(Long id) {
        Aluno aluno = Aluno.findById(id);
        if (aluno == null) {
            throw new NotFoundException("Aluno não encontrado");
        }
        return new AlunoComUsuarioDTO(aluno.id, aluno.matricula, aluno.usuario);
    }

    @Transactional
    public Aluno salvarUsuario(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.nome=dto.nome();
        usuario.email=dto.email();
        usuario.cpf=dto.cpf();
        usuario.cargo=CargoEnum.ALUNO;
        usuario.isAtivo = true;
        usuario.persist();

        Aluno aluno = new Aluno();
        aluno.usuario=usuario;
        aluno.matricula=dto.matricula();
        aluno.persist();

        return aluno;
    }

    @Transactional
    public Aluno atualizarAluno(Long id, UsuarioDTO dto) {
        Aluno aluno = Aluno.findById(id);
        if (aluno == null){
            throw new NotFoundException("Aluno não encontrado");
        }

        Usuario usuario = aluno.usuario;
        usuario.nome = dto.nome();
        usuario.email = dto.email();
        usuario.cpf = dto.email();
        usuario.cargo = CargoEnum.valueOf(dto.cargo().toUpperCase());
        usuario.persist();

        aluno.matricula = dto.matricula();
        aluno.usuario = usuario;
        aluno.persist();

        return aluno;
    }

    @Transactional
    public void deletarAluno(Long id) {
        Aluno aluno = Aluno.findById(id);
        if (aluno == null){
            throw new NotFoundException("Aluno não encontrado");
        }
        aluno.delete();
    }
}

