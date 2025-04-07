package org.acme.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "coordenador")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Gerente extends PanacheEntity {
    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false, unique = true, foreignKey = @ForeignKey(name = "fk_aluno_usuario"))
    @JsonBackReference
    private Usuario usuario;

    @Column(name = "matricula", nullable = false, unique = true, length = 24, columnDefinition = "VARCHAR(24)")
    private String matricula;
}
