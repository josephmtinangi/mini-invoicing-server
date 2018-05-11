package com.josephmtinangi.miniinvoicingserver.controllers;

import com.josephmtinangi.miniinvoicingserver.utilities.Helper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/")
public class WelcomeController {

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<?> index() {

        return Helper.createResponse(Helper.createMessage("Welcome"), HttpStatus.OK);
    }
}
