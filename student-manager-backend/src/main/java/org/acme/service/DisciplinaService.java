package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.acme.model.dto.AlunoDisciplinaDTO;
import org.acme.model.dto.AlunoResumoDTO;
import org.acme.model.dto.DisciplinaDTO;
import org.acme.model.entity.Aluno;
import org.acme.model.entity.AlunoDisciplina;
import org.acme.model.entity.Disciplina;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class DisciplinaService {

    public List<Disciplina> listarTodas() {
        return Disciplina.listAll();
    }

    public Disciplina buscarPorId(Long id) {
        Disciplina disciplina = Disciplina.findById(id);
        if (disciplina == null) {
            throw new NotFoundException("Disciplina de ID " + id + " não foi encontrada.");
        }
        return disciplina;
    }

    @Transactional
    public Disciplina criar(DisciplinaDTO dto) {
        Disciplina disciplina = new Disciplina();
        disciplina.nome =dto.nome();
        disciplina.codigo= dto.codigo();
        disciplina.persist();
        return disciplina;
    }

    @Transactional
    public Disciplina atualizar(Long id, DisciplinaDTO dto) {
        Disciplina disciplina = Disciplina.findById(id);
        if (disciplina == null) {
            throw new NotFoundException("Disciplina de ID " + id + " não foi encontrada.");
        }

        disciplina.nome = dto.nome();
        disciplina.codigo = dto.codigo();
        return disciplina;
    }

    @Transactional
    public void deletar(Long id) {
        Disciplina disciplina = Disciplina.findById(id);
        if (disciplina == null) {
            throw new NotFoundException("Disciplina não foi encontrada.");
        }
        disciplina.delete();
    }

    @Transactional
    public AlunoDisciplina matricularAluno(AlunoDisciplinaDTO dto) {
        Aluno aluno = Aluno.findById(dto.alunoId());
        if (aluno == null) {
            throw new NotFoundException("Aluno não encontrado");
        }

        Disciplina disciplina = Disciplina.findById(dto.disciplinaId());
        if (disciplina == null) {
            throw new NotFoundException("Disciplina não encontrada");
        }

        AlunoDisciplina matricula = new AlunoDisciplina();
                matricula.aluno = aluno;
                matricula.disciplina = disciplina;
                matricula.dataInscricao = LocalDateTime.now();
                matricula.isAtivo = true;

        matricula.persist();
        return matricula;
    }

//    public List<AlunoResumoDTO> listarAlunosPorCurso(Long cursoId){
//        List<Aluno> alunos = Aluno.list("")
//    }

}