package org.acme.model.dto;

import org.acme.model.entity.Usuario;

public record AlunoComUsuarioDTO(Long id, String matricula, Usuario usuario) {}