package com.luv2code.WalletServiceDemo1.Utils;

import com.luv2code.WalletServiceDemo1.exception.WalletException;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

@Component
public class Securityutils {

    public static byte[] encrypt(byte[] rawPrivateKey, byte[] message, byte []  seed){
         try{

             SecretKey secretKey = new SecretKeySpec(rawPrivateKey, "AES");
             Cipher ecipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
             IvParameterSpec iv = new IvParameterSpec(seed);
              ecipher.init(Cipher.ENCRYPT_MODE,secretKey,iv);
               return  ecipher.doFinal(message);
         }catch ( Exception e){
            throw  new WalletException("Unable to encrypt your pin at this time, please try again later");
         }
    }
}
