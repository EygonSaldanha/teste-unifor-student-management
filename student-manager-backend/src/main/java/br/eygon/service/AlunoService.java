package br.eygon.service;

import br.eygon.dto.AlunoComUsuarioDTO;
import br.eygon.dto.UsuarioDTO;
import br.eygon.entity.Aluno;
import br.eygon.entity.Usuario;
import br.eygon.enums.CargoEnum;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

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
        usuario.cargo= CargoEnum.ALUNO;
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
        usuario.cargo = dto.cargo();
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

