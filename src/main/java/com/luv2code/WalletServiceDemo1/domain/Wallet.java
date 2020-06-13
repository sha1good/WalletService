package com.luv2code.WalletServiceDemo1.domain;




import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class Wallet {

    @NotBlank(message = "Secret Key Cannot be blank")
    private String securityKey;

    @NotBlank(message="Pin cannot be blank")
    @Size(min=4,max =4,message="Please use 4 digits length")
    private String pin;

    @NotBlank(message ="DataSeed can be not blank")
    private String dataSeed;

    public Wallet() {

    }

    public String getSecurityKey() {
        return securityKey;
    }

    public void setSecurityKey(String securityKey) {
        this.securityKey = securityKey;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getDataSeed() {
        return dataSeed;
    }

    public void setDataSeed(String dataSeed) {
        this.dataSeed = dataSeed;
    }
}
