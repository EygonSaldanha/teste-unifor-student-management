package br.eygon.dto;

import br.eygon.entity.Usuario;

public record AlunoComUsuarioDTO(Long id, String matricula, Usuario usuario) {}