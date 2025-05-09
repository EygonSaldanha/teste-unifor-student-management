package br.eygon.enums;

public enum CargoEnum {
    ALUNO(0, "Aluno"),
    ADMIN(1, "Administrador");

    final int codigo;
    final String descricao;

    CargoEnum(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
}
