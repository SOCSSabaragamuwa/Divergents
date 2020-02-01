package com.divergents.eco.service;

import com.divergents.eco.model.Officer;

import com.divergents.eco.generator.PwdGenerator;

import com.divergents.eco.model.User;
import com.divergents.eco.model.repository.UserJdbcRepository;
import com.divergents.eco.sms.SmsSender;
import org.springframework.beans.factory.SmartFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class EcoService implements IEcoService{

    @Autowired
    UserJdbcRepository userRepo;

    @Autowired
    SmsSender smsSender;

    @Autowired
    PwdGenerator pwdGenerator;
    @Override
    public User AddNewUser(User user) {

        if(isExistUser(user.getNic())) {
            return null;
        }else{
            if (!isValidMobile(user.getMobile())) {
                return null;
            }else{
                if (isValidOldNic(user.getNic()) || isValidNewNic(user.getNic())) {
                    String password;
                    if (user.getPassword() == null) {
                        password = pwdGenerator.generatePassayPassword();
                        user.setPassword(password);
                        smsSender.sendSms(user.getMobile(),password);
                    }
                    userRepo.addUser(user);
                    return user;
                } else {
                    return null;
                }
            }
        }


    }

    public boolean isValidOldNic(String nic){
        Pattern oldNic= Pattern.compile("^[0-9]{9}[V]$");
        Matcher m = oldNic.matcher(nic);
        return (m.find() && m.group().equals(nic));
    }

    public boolean isValidMobile(String mobile){
        Pattern mob= Pattern.compile("^(\\+94)[0-9]{9}$");
        Matcher m = mob.matcher(mobile);
        return (m.find() && m.group().equals(mobile));
    }

    public boolean isValidNewNic(String nic){
        Pattern newNic=Pattern.compile("[0-9]{12}");
        Matcher m = newNic.matcher(nic);
        return (m.find() && m.group().equals(nic));
    }

    public boolean isExistUser(String nic){
        for(User user: userRepo.findAll()){
            if(user.getNic().equalsIgnoreCase(nic)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Officer AddNewOfficer(Officer officer) { return null; }

}
