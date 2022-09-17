package com.pelicanstroy.web.user;

import com.pelicanstroy.model.User;
import com.pelicanstroy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public abstract class AbstractUserController {

    @Autowired
    protected UserRepository userRepository;

    public ResponseEntity<User> get(int id) {
        return ResponseEntity.of(userRepository.findById(id));
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }


}
