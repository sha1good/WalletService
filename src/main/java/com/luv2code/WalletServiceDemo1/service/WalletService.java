package com.luv2code.WalletServiceDemo1.service;

import com.luv2code.WalletServiceDemo1.Utils.Securityutils;
import com.luv2code.WalletServiceDemo1.domain.Wallet;
import com.luv2code.WalletServiceDemo1.domain.WalletResponse;
import com.luv2code.WalletServiceDemo1.exception.WalletException;
import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class WalletService {

    public WalletResponse getEncryptedData(Wallet wallet){

        // String  encrytedPin;
        //try {
            String  securityKey = wallet.getSecurityKey();
            String pin = wallet.getPin();
            String dataSeed = wallet.getDataSeed();

            byte[] dataSeedByte = dataSeed.getBytes();
          String encrytedPin =getEncryptedData(securityKey,pin,dataSeedByte);

       // }catch (Exception e){
          //  throw new Exception("Unable to Encrypt your pin, Please check the data you passed");
       // }

     return new WalletResponse(true, encrytedPin);
    }

    private static String getEncryptedData(String securityKeyHex, String data, byte[] seed)  {
        try{
            byte [] securityKeysBuffer = Hex.decodeHex(securityKeyHex.toCharArray());
            System.out.println("Chars " + Arrays.toString(securityKeysBuffer));
            byte [] encryptedData = Securityutils.encrypt(securityKeysBuffer, data.getBytes(), seed);
            System.out.println( encryptedData.toString());
            return new String( Hex.encodeHex(encryptedData));
        }catch (Exception ex){
            throw new WalletException("Pin Encryption Failed");
        }
    }
}
