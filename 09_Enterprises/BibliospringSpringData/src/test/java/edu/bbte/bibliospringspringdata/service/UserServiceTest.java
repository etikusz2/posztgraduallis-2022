//package edu.bbte.bibliospringspringdata.service;
//
//import edu.bbte.bibliospringspringdata.model.User;
//import edu.bbte.bibliospringspringdata.repository.UserRepository;
//import edu.bbte.bibliospringspringdata.util.PasswordEncrypter;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.when;
//
//class UserServiceTest {
//
//    @Mock
//    private UserRepository userRepository;
//
//    @Mock
//    private PasswordEncrypter passwordEncrypter;
//
//    @InjectMocks
//    private UserService userService; // A UserService példány, amit tesztelünk.
//
//    private User testRealUser;
//    private User testWrongPasswordUser;
//    private User testWrongUser;
//
//    @BeforeEach
//    void setup() {
//        MockitoAnnotations.openMocks(this); // Inicializálja a mockokat és az injectMockst
//
//        testRealUser = new User();
//        testRealUser.setUsername("Ubulka");
//        testRealUser.setPassword("alma");
//
//        testWrongPasswordUser = new User();
//        testWrongPasswordUser.setUsername("Ubulka");
//        testWrongPasswordUser.setPassword("ubul");
//
//        testWrongUser = new User();
//        testWrongUser.setUsername("jozsi");
//        testWrongUser.setPassword("jozsi");
//    }
//
//    @Test
//    void testUserWithRightPasswordLogin() {
//        // Előfeltétel konfigurálása
//        when(userRepository.findByUsername("Ubulka")).thenReturn(testRealUser);
//        when(passwordEncrypter.generateHashedPassword(eq("alma"), anyString())).thenReturn("hashed-alma");
//
//        // Művelet végrehajtása
//        boolean existingUserWithRightPassword = userService.login(testRealUser.getUsername(), "alma");
//
//        // Ellenőrzés
//        assertTrue(existingUserWithRightPassword,
//                "Existing user with right password should be able to log in");
//    }
//
//    @Test
//    void testUserWithWrongPasswordLogin() {
//        // Előfeltétel konfigurálása
//        when(userRepository.findByUsername("Ubulka")).thenReturn(testRealUser);
//        when(passwordEncrypter.generateHashedPassword(eq("ubul"), anyString())).thenReturn("hashed-ubul");
//
//        // Művelet végrehajtása
//        boolean existingUserWithWrongPassword =
//                userService.login(testWrongPasswordUser.getUsername(), "ubul");
//
//        // Ellenőrzés
//        assertFalse(existingUserWithWrongPassword,
//                "Existing user with wrong password should not be able to log in");
//    }
//
//    @Test
//    void testWrongUserLogin() {
//        // Előfeltétel konfigurálása
//        when(userRepository.findByUsername("jozsi")).thenReturn(null);
//
//        // Művelet végrehajtása
//        boolean wrongUser = userService.login(testWrongUser.getUsername(), "jozsi");
//
//        // Ellenőrzés
//        assertFalse(wrongUser, "Non-existing user should not be able to log in");
//    }
//}
