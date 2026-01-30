package br.com.luccas.usercrud.service;

import br.com.luccas.usercrud.dto.UserRequestDTO;
import br.com.luccas.usercrud.dto.UserResponseDTO;
import br.com.luccas.usercrud.entities.User;
import br.com.luccas.usercrud.repository.userRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {


    private final userRepository repository;

    public UserService(userRepository repository) {
        this.repository = repository;
    }

    public List<UserResponseDTO> getAllUsers(){
        return repository.findAll().stream().map(this::convertToDTO).toList();
    }

    public UserResponseDTO findById(Long id){
        User user = repository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        return convertToDTO(user);
    }

    public UserResponseDTO insert(UserRequestDTO dto){

        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPassword(dto.password());

        User savedUser = repository.save(user);

        return convertToDTO(savedUser);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    @Transactional
    public UserResponseDTO update(Long id, UserRequestDTO dto) {

        User entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        entity.setName(dto.name());
        entity.setEmail(dto.email());

        // Only update password if sent (optional)
        if (dto.password() != null && !dto.password().isBlank()) {
            entity.setPassword(dto.password()); // later → encode
        }

        return convertToDTO(repository.save(entity));
    }

    private UserResponseDTO convertToDTO(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
