package org.acme.model.enums;

import lombok.Getter;

@Getter
public enum CargoEnum {
    ALUNO(0, "Aluno"),
    COORDENADOR(2, "Coordenador");

    private final int codigo;
    private final String descricao;

    CargoEnum(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
}
