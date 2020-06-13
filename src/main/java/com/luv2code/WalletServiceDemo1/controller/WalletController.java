package com.luv2code.WalletServiceDemo1.controller;

import com.luv2code.WalletServiceDemo1.domain.Wallet;
import com.luv2code.WalletServiceDemo1.domain.WalletResponse;
import com.luv2code.WalletServiceDemo1.service.MapValidation;
import com.luv2code.WalletServiceDemo1.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@CrossOrigin
@RequestMapping("/api/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @Autowired
    private MapValidation mapValidation;

    @PostMapping("/generatePin")
    public ResponseEntity<?> generatePin(@Valid @RequestBody Wallet wallet, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidation.mapErrors(result);
        if(errorMap !=null) return errorMap;

        WalletResponse walletResponse = walletService.getEncryptedData(wallet);
        System.out.println( "WalletEnc " + walletResponse.getEcryptedPin());
        System.out.println("Boolean Success " + walletResponse.isSuccess());

        return new ResponseEntity<WalletResponse>(walletResponse, HttpStatus.OK);

    }
}
