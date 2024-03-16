package lt.viko.eif.mjakovcenko.bankapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    final double BALANCE_TEST=100.0;
    final String CURRENCY_TEST="EURO";

    BankAccount bankAccount;
    @BeforeEach
    void init(){
        bankAccount = new BankAccount();
    }
    @Test
    void bankAccountConstructorSetsCorrectValue(){
        BankAccount bank = new BankAccount(BALANCE_TEST,CURRENCY_TEST);
        assertEquals(BALANCE_TEST,bank.getBalance());
        assertEquals(CURRENCY_TEST,bank.getCurrency());
    }

    @Test
    void getBalanceReturnsCorrectValue() {
        bankAccount.setBalance(BALANCE_TEST);
        assertEquals(BALANCE_TEST,bankAccount.getBalance());
    }

    @Test
    void setBalanceSetsCorrectValue() {
        bankAccount.setBalance(BALANCE_TEST);
        assertEquals(BALANCE_TEST,bankAccount.getBalance());
    }

    @Test
    void getCurrencyReturnsCorrectValue() {
        bankAccount.setCurrency(CURRENCY_TEST);
        assertEquals(CURRENCY_TEST,bankAccount.getCurrency());
    }

    @Test
    void setCurrencySetsCorrectValue() {
        bankAccount.setCurrency(CURRENCY_TEST);
        assertEquals(CURRENCY_TEST,bankAccount.getCurrency());
    }
}