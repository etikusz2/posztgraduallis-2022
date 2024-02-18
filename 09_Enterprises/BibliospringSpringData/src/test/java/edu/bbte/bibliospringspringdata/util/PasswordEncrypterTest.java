package edu.bbte.bibliospringspringdata.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PasswordEncrypterTest {

    @Mock
    private Logger logger;

    private PasswordEncrypter passwordEncrypter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        passwordEncrypter = new PasswordEncrypter(logger);
    }

    @Test
    void testPasswordHashing() {
        String password = "password";
        String salt = "alma";
        String expected = "f4ac810b9e26403e54c6bc9dd45e9749d318a6ed1870e6b89b28338c7d35ee5b";

        String result = passwordEncrypter.generateHashedPassword(password, salt);

        assertEquals(expected, result, "The hashed password did not match the expected output.");
    }
}
