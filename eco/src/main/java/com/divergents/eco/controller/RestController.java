package com.divergents.eco.controller;

import com.divergents.eco.model.Error;
import com.divergents.eco.model.User;
import com.divergents.eco.service.IEcoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.validation.Valid;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String GetApi(){
        return "Ok";
    }

    @Autowired
    IEcoService iEcoService;

    @RequestMapping(value = "/users", method = RequestMethod.POST)
        public ResponseEntity<User> AddNewUser(@Valid @RequestBody User user){

        return new ResponseEntity<>(iEcoService.AddNewUser(user), HttpStatus.CREATED);

    }
}

