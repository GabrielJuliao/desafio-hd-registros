package com.gabrieljuliao.desafiohdregistros.repository;

import com.gabrieljuliao.desafiohdregistros.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
