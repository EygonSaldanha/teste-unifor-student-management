package org.acme.model.dto;

import lombok.Data;

@Data
public class AlunoDTO {
    private UsuarioDTO usuario;
    private String matricula;
}
