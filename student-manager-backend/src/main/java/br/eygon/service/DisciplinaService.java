package br.eygon.service;

import br.eygon.dto.AlunoDisciplinaDTO;
import br.eygon.dto.AlunoResumoDTO;
import br.eygon.dto.DisciplinaDTO;
import br.eygon.entity.Aluno;
import br.eygon.entity.AlunoDisciplina;
import br.eygon.entity.Disciplina;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
                matricula.dtInscricao = LocalDateTime.now();
                matricula.isAtivo = true;

        matricula.persist();
        return matricula;
    }

    public List<AlunoResumoDTO> listarAlunosPorDisciplina(Long disciplinaId) {
        Disciplina disciplina = Disciplina.findById(disciplinaId);
        if (disciplina == null) {
            throw new NotFoundException("Disciplina não encontrada.");
        }

        // Buscar as matrículas (AlunoDisciplina) dessa disciplina
        List<AlunoDisciplina> matriculas = AlunoDisciplina.list("disciplina", disciplina);

        // Transformar para uma lista de AlunoResumoDTO
        return matriculas.stream()
                .map(matricula -> new AlunoResumoDTO(matricula.aluno.id, matricula.aluno.usuario.nome, matricula.aluno.matricula))
                .collect(Collectors.toList());
    }
}