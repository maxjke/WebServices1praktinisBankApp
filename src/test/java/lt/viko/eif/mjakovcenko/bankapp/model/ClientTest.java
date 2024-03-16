package lt.viko.eif.mjakovcenko.bankapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class ClientTest {

     Client client;
     final String FIRST_NAME_TEST = "firstName";
     final String LAST_NAME_TEST = "LastName";
     final Account ACCOUNT_TEST = new Account();
     final List<BankAccount> BANK_ACCOUNT_LIST_TEST = new ArrayList<>();
     final List<Loan> LOAN_LIST_TEST = new ArrayList<>();
     final List<CreditCard> CREDIT_CARD_LIST_TEST = new ArrayList<>();

    @BeforeEach
    void init() {
        client = new Client(FIRST_NAME_TEST, LAST_NAME_TEST);
        client.setAccount(ACCOUNT_TEST);
        client.setBankAccountList(BANK_ACCOUNT_LIST_TEST);
        client.setLoanList(LOAN_LIST_TEST);
        client.setCreditCardList(CREDIT_CARD_LIST_TEST);
    }

    @Test
    void clientConstructorTest(){
        Client client1 = new Client(FIRST_NAME_TEST,LAST_NAME_TEST);
        assertEquals(FIRST_NAME_TEST,client1.getFirstName());
        assertEquals(LAST_NAME_TEST,client1.getLastName());
    }
    @Test
    void getFirstName() {
        client.setFirstName(FIRST_NAME_TEST);
        assertEquals(FIRST_NAME_TEST, client.getFirstName());
    }

    @Test
    void setFirstName() {
        client.setFirstName(FIRST_NAME_TEST);
        assertEquals(FIRST_NAME_TEST, client.getFirstName());
    }

    @Test
    void getLastName() {
        client.setLastName(LAST_NAME_TEST);
        assertEquals(LAST_NAME_TEST, client.getLastName());
    }

    @Test
    void setLastName() {
        client.setLastName(LAST_NAME_TEST);
        assertEquals(LAST_NAME_TEST, client.getLastName());
    }

    @Test
    void getAccount() {
        client.setAccount(ACCOUNT_TEST);
        assertEquals(ACCOUNT_TEST, client.getAccount());
    }

    @Test
    void setAccount() {
        Account account = new Account();
        client.setAccount(account);
        assertEquals(account, client.getAccount());
    }

    @Test
    void getBankAccountList() {
        client.setBankAccountList(BANK_ACCOUNT_LIST_TEST);
        assertEquals(BANK_ACCOUNT_LIST_TEST, client.getBankAccountList());
    }

    @Test
    void setBankAccountList() {
        List<BankAccount> bankAccountList = new ArrayList<>();
        bankAccountList.add(new BankAccount());
        client.setBankAccountList(bankAccountList);
        assertEquals(bankAccountList, client.getBankAccountList());
    }

    @Test
    void getLoanList() {
        client.setLoanList(LOAN_LIST_TEST);
        assertEquals(LOAN_LIST_TEST, client.getLoanList());
    }

    @Test
    void setLoanList() {
        List<Loan> loanList = new ArrayList<>();
        loanList.add(new Loan());
        client.setLoanList(loanList);
        assertEquals(loanList, client.getLoanList());
    }

    @Test
    void getCreditCardList() {
        client.setCreditCardList(CREDIT_CARD_LIST_TEST);
        assertEquals(CREDIT_CARD_LIST_TEST, client.getCreditCardList());
    }

    @Test
    void setCreditCardList() {
        List<CreditCard> creditCardList = new ArrayList<>();
        creditCardList.add(new CreditCard());
        client.setCreditCardList(creditCardList);
        assertEquals(creditCardList, client.getCreditCardList());
    }
}
