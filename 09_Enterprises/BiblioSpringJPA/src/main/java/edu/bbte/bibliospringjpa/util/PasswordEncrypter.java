package edu.bbte.bibliospringjpa.util;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class PasswordEncrypter {

    public String generateHashedPassword(String password, String salt) {
        try {
            byte[] input = (password + salt).getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.reset();
            messageDigest.update(input);
            byte[] output = messageDigest.digest();
            StringBuilder stringBuilder = new StringBuilder();

            for (byte b : output) {
                stringBuilder.append(String.format("%02x", b));
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
