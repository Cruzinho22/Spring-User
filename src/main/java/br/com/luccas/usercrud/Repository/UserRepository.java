package br.com.luccas.usercrud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.luccas.usercrud.entities.User;
public interface UserRepository extends JpaRepository<User, Long>{

}
