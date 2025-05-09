package br.eygon.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "DISCIPLINA")
public class Disciplina extends PanacheEntityBase {

    @Id
    @Column(name = "ID_DISCIPLINA",nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String nome;

    public String codigo;
}
