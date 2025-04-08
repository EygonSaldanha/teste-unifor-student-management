package org.acme.model.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "disciplina")
public class Disciplina extends PanacheEntityBase {

    @Id
    @Column(name = "ID_DISCIPLINA")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(name = "NOME",nullable = false, unique = true)
    public String nome;

    @Column(name = "CODIGO", nullable = false, unique = true, length = 12, columnDefinition = "VARCHAR(24)")
    public String codigo;

}
