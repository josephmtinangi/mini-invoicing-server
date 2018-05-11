package com.josephmtinangi.miniinvoicingserver.controllers;

import com.josephmtinangi.miniinvoicingserver.models.User;
import com.josephmtinangi.miniinvoicingserver.repositories.UserRepository;
import com.josephmtinangi.miniinvoicingserver.utilities.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/register")
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<?> store(@ModelAttribute User user) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        return Helper.createResponse(user, HttpStatus.CREATED);
    }
}
