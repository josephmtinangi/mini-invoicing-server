package com.josephmtinangi.miniinvoicingserver.utilities;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public class Helper {

    public static ResponseEntity<?> createResponse(Object data, HttpStatus code) {


        return new ResponseEntity<>(data, code);
    }

    public static HashMap<String, Object> createMessage(String message) {

        HashMap<String, Object> output = new HashMap<>();
        output.put("message", message);
        output.put("documentation_url", "url");

        return output;
    }
}
