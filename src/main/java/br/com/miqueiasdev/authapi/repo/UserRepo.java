package br.com.miqueiasdev.authapi.repo;


import br.com.miqueiasdev.authapi.model.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UserRepo extends ListCrudRepository<User, Integer> {

    public Optional<User> findByUsername(String username);
    public boolean existsUserByUsername(String username);
}
