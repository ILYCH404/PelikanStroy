package com.pelicanstroy.repository;

import com.pelicanstroy.model.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface UserRepository extends BaseRepository<User>{
}
