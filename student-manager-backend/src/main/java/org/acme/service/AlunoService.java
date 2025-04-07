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
                        aluno.getMatricula(),
                        aluno.getUsuario()
                ))
                .toList();
    }

    public AlunoComUsuarioDTO buscarAlunoComUsuarioPorId(Long id) {
        Aluno aluno = Aluno.findById(id);
        if (aluno == null) {
            throw new NotFoundException("Aluno não encontrado");
        }
        return new AlunoComUsuarioDTO(aluno.id, aluno.getMatricula(), aluno.getUsuario());
    }

    @Transactional
    public Aluno salvarUsuario(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setCpf(dto.getCpf());
        usuario.setCargo(CargoEnum.ALUNO);
        usuario.setStatus(true);
        usuario.persist();

        Aluno aluno = new Aluno();
        aluno.setUsuario(usuario);
        aluno.setMatricula(dto.getMatricula());
        aluno.persist();

        return aluno;
    }

    @Transactional
    public Aluno atualizarAluno(Long id, UsuarioDTO dto) {
        Aluno aluno = Aluno.findById(id);
        if (aluno == null){
            throw new NotFoundException("Aluno não encontrado");
        }

        Usuario usuario = aluno.getUsuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setCpf(dto.getCpf());
        usuario.setCargo(CargoEnum.valueOf(dto.getCargo().toUpperCase()));
        usuario.persist();

        aluno.setMatricula(dto.getMatricula());
        aluno.setUsuario(usuario);
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

