package com.divergents.eco.validation;

import com.divergents.eco.constant.CustomMessage;
import com.divergents.eco.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;


@ControllerAdvice
public class EcoValidator {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Error> handleUserValidationExceptions(
            MethodArgumentNotValidException ex) {
        Error erroObj = new Error();
        List<ObjectError> errorList=ex.getBindingResult().getAllErrors();

        for(ObjectError error:errorList)
        {
            String fieldName = ((FieldError) error).getField();
            erroObj.setMessage(error.getDefaultMessage());
            if(fieldName.equalsIgnoreCase("nic")){
                erroObj.setDeveloperMessage(CustomMessage.nicDeveMessage);
            }else if(fieldName.equalsIgnoreCase("mobile")){
                erroObj.setDeveloperMessage(CustomMessage.mobileDevMessage);
            }
            else if(fieldName.equalsIgnoreCase("password")){
                erroObj.setDeveloperMessage(CustomMessage.pwdDevMessage);
            }
        }

        return new ResponseEntity<>(erroObj,
                HttpStatus.BAD_REQUEST) ;
    }
}
