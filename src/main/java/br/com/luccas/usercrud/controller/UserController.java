package br.com.luccas.usercrud.controller;

import br.com.luccas.usercrud.entities.User;
import br.com.luccas.usercrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<User> findAll(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = service.findById(id);
        return ResponseEntity.ok(user);
    }
    @PostMapping
    public User insert(@RequestBody User user) {
        return service.insert(user);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
        User user = service.update(id, obj);
        return ResponseEntity.ok(user);
    }
}
