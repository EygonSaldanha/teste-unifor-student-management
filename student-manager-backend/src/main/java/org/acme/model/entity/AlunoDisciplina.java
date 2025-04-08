package org.acme.model.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "alunoDisciplina")
public class AlunoDisciplina extends PanacheEntityBase {

    @Id
    @Column(name = "ID_ALUNO_DISCIPLINA")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ALUNO", nullable = false)
    public Aluno aluno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_DISCIPLINA", nullable = false)
    public Disciplina disciplina;

    @Column(name = "IS_ATIVO", nullable = false)
    public Boolean isAtivo;

    @Column(name = "data_inscricao", nullable = false)
    public LocalDateTime dataInscricao;
}
