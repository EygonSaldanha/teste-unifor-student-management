package org.acme.model.enums;

import lombok.Getter;

@Getter
public enum CargoEnum {
    ALUNO(0),
    COORDENADOR(2);

    private final int codigo;

    CargoEnum(int codigo) {
        this.codigo = codigo;
    }

}