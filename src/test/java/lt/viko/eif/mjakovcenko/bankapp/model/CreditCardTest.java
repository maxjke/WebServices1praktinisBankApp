package lt.viko.eif.mjakovcenko.bankapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CreditCardTest {

     CreditCard creditCard;

     final double CARD_LIMIT_TEST = 5000.00;
     final String EXPIRE_DATE_TEST = "12/25";
     final String CVC_TEST = "123";
     final String CARD_NUMBER_TEST = "1234567890123456";



    @BeforeEach
    void init() {
        creditCard = new CreditCard(CARD_LIMIT_TEST, EXPIRE_DATE_TEST, CVC_TEST, CARD_NUMBER_TEST);
    }

    @Test
    void creditCardConstructorTest(){
        CreditCard card = new CreditCard(CARD_LIMIT_TEST,EXPIRE_DATE_TEST,CVC_TEST,CARD_NUMBER_TEST);
        assertEquals(CARD_LIMIT_TEST,card.getCardLimit());
        assertEquals(EXPIRE_DATE_TEST,card.getExpireDate());
        assertEquals(CVC_TEST,card.getCVC());
        assertEquals(CARD_NUMBER_TEST,card.getCardNumber());
    }
    @Test
    void getCardLimit() {
        assertEquals(CARD_LIMIT_TEST, creditCard.getCardLimit());
    }

    @Test
    void setCardLimit() {
        creditCard.setCardLimit(CARD_LIMIT_TEST);
        assertEquals(CARD_LIMIT_TEST, creditCard.getCardLimit());
    }

    @Test
    void getExpireDate() {
        creditCard.setExpireDate(EXPIRE_DATE_TEST);
        assertEquals(EXPIRE_DATE_TEST, creditCard.getExpireDate());
    }

    @Test
    void setExpireDate() {
        creditCard.setExpireDate(EXPIRE_DATE_TEST);
        assertEquals(EXPIRE_DATE_TEST, creditCard.getExpireDate());
    }

    @Test
    void getCVC() {
        creditCard.setCVC(CVC_TEST);
        assertEquals(CVC_TEST, creditCard.getCVC());
    }

    @Test
    void setCVC() {
        creditCard.setCVC(CVC_TEST);
        assertEquals(CVC_TEST, creditCard.getCVC());
    }

    @Test
    void getCardNumber() {
        creditCard.setCardNumber(CARD_NUMBER_TEST);
        assertEquals(CARD_NUMBER_TEST, creditCard.getCardNumber());
    }

    @Test
    void setCardNumber() {
        creditCard.setCardNumber(CARD_NUMBER_TEST);
        assertEquals(CARD_NUMBER_TEST, creditCard.getCardNumber());
    }
}
