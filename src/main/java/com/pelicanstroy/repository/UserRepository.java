package com.pelicanstroy.repository;

import com.pelicanstroy.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface UserRepository extends BaseRepository<User>{

    User findByEmail(String email);

    Optional<User> getByEmail(String email);

    User findByFullName(String fullName);
}
