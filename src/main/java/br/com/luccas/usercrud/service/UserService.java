package br.com.luccas.usercrud.service;

import br.com.luccas.usercrud.Repository.UserRepository;
import br.com.luccas.usercrud.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User insert(User user){
        return repository.save(user);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public User update(Long id, User user){
        User entity = findById(id);
        entity.setName(user.getName());
        return repository.save(entity);
    }
}
