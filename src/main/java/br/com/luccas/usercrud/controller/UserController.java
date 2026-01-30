package br.com.luccas.usercrud.controller;

import br.com.luccas.usercrud.dto.UserRequestDTO;
import br.com.luccas.usercrud.dto.UserResponseDTO;
import br.com.luccas.usercrud.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserResponseDTO> findAll() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> insert(@RequestBody UserRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.insert(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable Long id,
                                                  @RequestBody UserRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }
}
