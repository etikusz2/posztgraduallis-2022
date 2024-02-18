package edu.bbte.bibliospringspringdata.util;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class PasswordEncrypter {

    private final Logger logger;

    public PasswordEncrypter(Logger logger) {
        this.logger = logger;
    }


    public String generateHashedPassword(String plainPassword, String salt) {
        try {
            byte[] input = (plainPassword + salt).getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.reset();
            messageDigest.update(input);
            byte[] output = messageDigest.digest();

            StringBuilder stringBuilder = new StringBuilder();
            for (byte builder : output) {
                stringBuilder.append(String.format("%02x", builder));
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            logger.error("Password hashing failed", e);
            throw new ServiceException("Password hashing failed", e);
        }
    }
}
