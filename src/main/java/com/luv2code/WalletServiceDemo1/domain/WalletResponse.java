package com.luv2code.WalletServiceDemo1.domain;

public class WalletResponse {

    private boolean Success;

    private String ecryptedPin;

    public WalletResponse() {
    }

    public WalletResponse(boolean success, String ecryptedPin) {
        Success = success;
        this.ecryptedPin = ecryptedPin;
    }

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean success) {
        Success = success;
    }

    public String getEcryptedPin() {
        return ecryptedPin;
    }

    public void setEcryptedPin(String ecryptedPin) {
        this.ecryptedPin = ecryptedPin;
    }
}
