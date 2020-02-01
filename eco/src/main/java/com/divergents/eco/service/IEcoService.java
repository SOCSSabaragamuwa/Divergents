package com.divergents.eco.service;

import com.divergents.eco.model.User;
import org.springframework.stereotype.Service;

@Service
public interface IEcoService  {

    User AddNewUser(User user);
}
