package com.poga.radio.service.impl;

import com.goterl.lazycode.lazysodium.LazySodiumJava;
import com.goterl.lazycode.lazysodium.SodiumJava;
import com.goterl.lazycode.lazysodium.exceptions.SodiumException;
import com.goterl.lazycode.lazysodium.interfaces.SecretBox;
import com.goterl.lazycode.lazysodium.utils.Key;
import org.springframework.stereotype.Service;

@Service
public class EncryptionImpl {

    // Let's initialise LazySodium
    LazySodiumJava lazySodium = new LazySodiumJava(new SodiumJava());

    public String encryptFile(String uriToEncrypt) throws SodiumException {

        Key key = lazySodium.cryptoSecretBoxKeygen();

        byte[] nonce = lazySodium.nonce(SecretBox.NONCEBYTES);
        String encrypted  = lazySodium.cryptoSecretBoxEasy(uriToEncrypt, nonce, key);

        System.out.println("before encryption uri is : "+ uriToEncrypt);
        System.out.println("The encrypted uri is " + encrypted + ".");
        System.out.println("Your  nonce " + lazySodium.toHexStr(nonce) + ".");

    //    decryptFile(key, nonce, encrypted);

        return encrypted ;
    }

    private void decryptFile(Key key, byte[] nonce, String encrypted) throws SodiumException {
        String decrypted = lazySodium.cryptoSecretBoxOpenEasy(encrypted, nonce, key);
        System.out.println("The decrypted file is " + decrypted + ".");
    }

}
