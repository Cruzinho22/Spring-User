package br.com.luccas.usercrud.dto;

public record UserRequestDTO(
   String name,
   String email,
   String password
) {}
