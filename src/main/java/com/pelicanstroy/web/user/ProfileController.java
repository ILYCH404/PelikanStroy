package com.pelicanstroy.web.user;

import com.pelicanstroy.model.User;
import com.pelicanstroy.to.UserTo;
import com.pelicanstroy.util.UserUtil;
import com.pelicanstroy.web.AuthUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

import java.net.URI;

import static com.pelicanstroy.util.validation.ValidationUtil.assureIdConsistent;
import static com.pelicanstroy.util.validation.ValidationUtil.checkNew;

@Controller
@RequestMapping(value = ProfileController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileController extends AbstractUserController{
    static final String REST_URL = "/api/profile";






}
