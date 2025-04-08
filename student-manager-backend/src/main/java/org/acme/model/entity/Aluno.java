package org.acme.model.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "aluno")
public class Aluno extends PanacheEntityBase {

    @Id
    @Column(name = "ID_ALUNO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    public Usuario usuario;

    @Column(name = "MATRICULA", nullable = false, unique = true, length = 24, columnDefinition = "VARCHAR(24)")
    public String matricula;

}
