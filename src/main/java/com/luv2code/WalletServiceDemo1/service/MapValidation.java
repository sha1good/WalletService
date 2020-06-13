package com.luv2code.WalletServiceDemo1.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.*;

@Service
public class MapValidation {

  public ResponseEntity<?> mapErrors(BindingResult result){

       if(result.hasErrors()){
          Map<String,String> errorMap = new HashMap<>();

          for(FieldError error : result.getFieldErrors()){
              errorMap.put(error.getField(), error.getDefaultMessage());
          }
          return new ResponseEntity<Map<String,String>>(errorMap, HttpStatus.BAD_REQUEST);
      }
      return  null;

    }
}
