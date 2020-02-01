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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class EcoValidator {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Error> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Error erroObj = new Error();
        List<ObjectError> errorList=ex.getBindingResult().getAllErrors();

        for(ObjectError error:errorList)
        {
            String fieldName = ((FieldError) error).getField();
            erroObj.setMessage(error.getDefaultMessage());
            if(fieldName.equalsIgnoreCase("nic")){
                erroObj.setDeveloperMessage(CustomMessage.nicDeveMessage);
            }else{
                erroObj.setDeveloperMessage(CustomMessage.mobileDevMessage);
            }
        }

        return new ResponseEntity<>(erroObj,
                HttpStatus.BAD_REQUEST) ;
    }
}
