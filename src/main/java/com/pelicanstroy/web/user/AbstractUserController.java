package com.pelicanstroy.web.user;

import com.pelicanstroy.model.User;
import com.pelicanstroy.repository.UserRepository;
import com.pelicanstroy.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public abstract class AbstractUserController {

    @Autowired
    protected UserRepository repository;

    public ResponseEntity<User> get(int id) {
        return ResponseEntity.of(repository.findById(id));
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    protected User prepareAndSave(User user) {
        return repository.save(UserUtil.prepareToSave(user));
    }

}
