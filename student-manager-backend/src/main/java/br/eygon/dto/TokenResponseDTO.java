package br.eygon.dto;

public record TokenResponseDTO(String token, Long idUsuario, String nome, String email) {}
