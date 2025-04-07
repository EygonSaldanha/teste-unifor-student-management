package org.acme.model.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "disciplina")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Disciplina extends PanacheEntity {

    @Column(nullable = false, unique = true)
    public String nome;

    @Column(name = "descricao",nullable = false)
    public String descricao;

    @Column(name = "matricula", nullable = false, unique = true, length = 12, columnDefinition = "VARCHAR(24)")
    private String matricula;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
