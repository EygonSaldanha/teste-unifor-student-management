package br.eygon.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "ALUNO")
public class Aluno extends PanacheEntityBase {

    @Id
    @Column(name = "ID_ALUNO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    public Usuario usuario;

    public String matricula;
}
