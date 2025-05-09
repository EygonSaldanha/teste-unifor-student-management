package br.eygon.dto;

import br.eygon.enums.CargoEnum;

public record UsuarioDTO(
        String nome,
        String email,
        String cpf,
        String matricula
) {}
