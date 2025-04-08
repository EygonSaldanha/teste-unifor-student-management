package org.acme.model.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.*;
import org.acme.model.enums.CargoEnum;

@Entity
@Table(name = "usuario")
public class Usuario  extends PanacheEntityBase {

    @Id
    @Column(name = "ID_USUARIO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(name = "NOME", nullable = false, columnDefinition = "VARCHAR(255)")
    public String nome;

    @Column(name = "EMAIL", nullable = true, length = 100, columnDefinition = "VARCHAR(50)")
    public String email;

    @Column(name = "CPF", nullable = false, length = 11, columnDefinition = "VARCHAR(11)")
    public String cpf;

    @Column(name = "CARGO", nullable = false)
    @Enumerated(EnumType.STRING)
    public CargoEnum cargo;

    @Column(name = "IS_ATIVO")
    public Boolean isAtivo;

}
