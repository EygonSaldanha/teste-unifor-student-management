package org.acme.model.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.*;
import org.acme.model.enums.CargoEnum;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario  extends PanacheEntity {

    @Column(name = "nome", nullable = false, columnDefinition = "VARCHAR(255)")
    private String nome;

    @Column(name = "email", nullable = true, length = 100, columnDefinition = "VARCHAR(50)")
    private String email;

    @Column(name = "cpf", nullable = false, length = 11, columnDefinition = "VARCHAR(11)")
    private String cpf;

    @Column(name = "cargo", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private CargoEnum cargo;

    @Column(name = "status")
    private Boolean status;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public CargoEnum getCargo() {
        return cargo;
    }

    public void setCargo(CargoEnum cargo) {
        this.cargo = cargo;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
