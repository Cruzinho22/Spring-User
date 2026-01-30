package br.com.luccas.usercrud.dto;

public record UserResponseDTO(
        Long id,
        String name,
        String email
) {
}
