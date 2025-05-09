package br.eygon.entity;

import br.eygon.enums.CargoEnum;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "USUARIO")
public class Usuario extends PanacheEntityBase {

    @Id
    @Column(name = "ID_USUARIO",nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    public String nome;

    @Column(unique = true, nullable = false)
    public String email;

    @Column(nullable = false)
    public String senha;

    @Column(nullable = false)
    public String cpf;

    @Column(name = "CARGO", nullable = false)
    @Enumerated(EnumType.STRING)
    public CargoEnum cargo;

    @Column(nullable = false)
    public Boolean ativo;
}
