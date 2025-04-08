package br.eygon.enums;

public enum CargoEnum {
    ALUNO(0, "Aluno"),
    COORDENADOR(2, "Coordenador");

    final int codigo;
    final String descricao;

    CargoEnum(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
}
