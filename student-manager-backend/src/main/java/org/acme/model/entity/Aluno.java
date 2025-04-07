package org.acme.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "aluno")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Aluno extends PanacheEntity {

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario",referencedColumnName = "id", nullable = false, unique = true, foreignKey = @ForeignKey(name = "fk_aluno_usuario"))
    @JsonBackReference
    private Usuario usuario;

    @Column(name = "matricula", nullable = false, unique = true, length = 24, columnDefinition = "VARCHAR(24)")
    private String matricula;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
