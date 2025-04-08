package br.eygon.entity;

import br.eygon.enums.CargoEnum;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "USUARIO")
public class Usuario extends PanacheEntityBase {

    @Id
    @Column(name = "ID_USUARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String nome;

    public String email;

    public String cpf;

    @Column(name = "CARGO", nullable = false)
    @Enumerated(EnumType.STRING)
    public CargoEnum cargo;

    public Boolean isAtivo;
}
