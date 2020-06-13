package com.luv2code.WalletServiceDemo1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomException  extends ResponseEntityExceptionHandler {

  public ResponseEntity<Object> handleWalletException(WalletException ex){
       WalletExceptionResponse response = new WalletExceptionResponse(ex.getMessage());

       return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
  }
}
