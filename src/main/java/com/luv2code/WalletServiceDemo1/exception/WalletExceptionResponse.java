package com.luv2code.WalletServiceDemo1.exception;

public class WalletExceptionResponse {

    private String  message;
    private String details;

    public WalletExceptionResponse() {
    }

    public WalletExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
