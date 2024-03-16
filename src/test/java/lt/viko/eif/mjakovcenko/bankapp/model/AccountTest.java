package lt.viko.eif.mjakovcenko.bankapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    Account account;
    final String USERNAME_TEST="Username";
    final String PASSWORD_TEST="Password";
    @BeforeEach
    void init(){
        account = new Account();
    }

    @Test
    void accountConstructorSetsCorrectValue(){
        Account account1 = new Account(USERNAME_TEST,PASSWORD_TEST);
        assertEquals(USERNAME_TEST,account1.getUsername());
        assertEquals(PASSWORD_TEST,account1.getPassword());
    }
    @Test
    void getUsernameReturnsCorrectValue() {
        account.setUsername(USERNAME_TEST);
        assertEquals(USERNAME_TEST,account.getUsername());
    }

    @Test
    void setUsernameSetsCorrectValue() {
        account.setUsername(USERNAME_TEST);
        assertEquals(USERNAME_TEST,account.getUsername());
    }

    @Test
    void getPasswordReturnsCorrectValue() {
        account.setPassword(PASSWORD_TEST);
        assertEquals(PASSWORD_TEST,account.getPassword());
    }

    @Test
    void setPasswordSetsCorrectValue() {
        account.setPassword(PASSWORD_TEST);
        assertEquals(PASSWORD_TEST,account.getPassword());
    }
}