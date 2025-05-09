package br.eygon.exeption;

public record ExceptionDTO(String dsRetorno, Object data) {
    public ExceptionDTO( String dsRetorno) {
        this(dsRetorno, null);
    }
}