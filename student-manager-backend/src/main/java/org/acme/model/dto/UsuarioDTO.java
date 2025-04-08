package org.acme.model.dto;

public record UsuarioDTO(
        String nome,
        String email,
        String cpf,
        String cargo,
        String matricula
) {}
