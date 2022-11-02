package com.pelicanstroy.web;


import com.pelicanstroy.model.User;
import com.pelicanstroy.repository.UserRepository;
import com.pelicanstroy.to.UserTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

import static com.pelicanstroy.util.UserUtil.createNewFromTo;
import static com.pelicanstroy.util.UserUtil.prepareToSave;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(UserTo userTo, Map<String, Object> model) {
        User userFromDb = userRepository.findByFullName(userTo.getFullName());

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }

        userRepository.save(prepareToSave(createNewFromTo(userTo)));

        return "redirect:/login";
    }
}