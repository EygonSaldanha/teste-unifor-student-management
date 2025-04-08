package br.eygon.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ALUNO_DICIPLINA")
public class AlunoDisciplina extends PanacheEntityBase {

    @Id
    @Column(name = "ID_ALUNO_DISCIPLINA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ALUNO", nullable = false)
    public Aluno aluno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_DISCIPLINA", nullable = false)
    public Disciplina disciplina;

    @JoinColumn(name = "IS_ATIVO", nullable = false)
    public Boolean isAtivo;

    public LocalDateTime dtInscricao;
}
