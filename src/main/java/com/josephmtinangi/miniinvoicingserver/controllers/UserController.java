package com.josephmtinangi.miniinvoicingserver.controllers;


import com.josephmtinangi.miniinvoicingserver.models.User;
import com.josephmtinangi.miniinvoicingserver.repositories.UserRepository;
import com.josephmtinangi.miniinvoicingserver.utilities.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<?> index() {

        List<User> users = userRepository.findAll();

        return Helper.createResponse(users, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> show(@PathVariable Long id) {

        User user = userRepository.findOne(id);

        if (user == null) {
            Helper.createResponse(null, HttpStatus.BAD_REQUEST);
        }

        return Helper.createResponse(user, HttpStatus.OK);
    }
}
