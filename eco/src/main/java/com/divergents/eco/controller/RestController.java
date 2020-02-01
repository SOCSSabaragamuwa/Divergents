package com.divergents.eco.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String GetApi(){
        return "Ok";
    }

}

