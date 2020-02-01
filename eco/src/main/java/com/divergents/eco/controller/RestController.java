package com.divergents.eco.controller;

import com.divergents.eco.model.Error;
import com.divergents.eco.model.Officer;
import com.divergents.eco.model.User;
import com.divergents.eco.service.IEcoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import javax.validation.Valid;
import java.util.List;


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
        User user1=iEcoService.AddNewUser(user);
        if(user1 == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(iEcoService.AddNewUser(user), HttpStatus.CREATED);
        }

    }



    @RequestMapping(value = "/officers", method = RequestMethod.POST)
    public ResponseEntity<Officer> AddNewOfficer(@Valid @RequestBody Officer officer) {
        return new ResponseEntity<>(iEcoService.AddNewOfficer(officer), HttpStatus.CREATED);
    }
}

