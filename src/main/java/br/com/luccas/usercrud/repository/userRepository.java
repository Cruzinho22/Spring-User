package br.com.luccas.usercrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.luccas.usercrud.entities.User;
public interface userRepository extends JpaRepository<User, Long>{

}
