package org.acme.model.dto;

import lombok.Data;
import org.acme.model.entity.Usuario;

@Data
public class AlunoComUsuarioDTO {
    private Long id;
    private String matricula;
    private Usuario usuario;

    public AlunoComUsuarioDTO(Long id, String matricula, Usuario usuario) {
        this.id = id;
        this.matricula = matricula;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}