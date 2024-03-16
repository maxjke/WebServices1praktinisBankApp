package lt.viko.eif.mjakovcenko.bankapp.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoanTest {


    Loan loan ;


        final double LOAN_AMOUNT_TEST=100.00;
        final double LOAN_MONTHLY_PAYMENT_TEST=10.00;
        final String LOAN_START_DATE_TEST="2024-12-12";
        final String LOAN_END_DATE_TEST="2025-12-12";
        final int LOAN_PERCENT_TEST=10;

    @BeforeEach
    void init() {
        loan = new Loan();
    }

    @Test
    void loanConstructorSetsCorrectValues(){
        Loan loan1 = new Loan(LOAN_AMOUNT_TEST,LOAN_MONTHLY_PAYMENT_TEST,LOAN_START_DATE_TEST,LOAN_END_DATE_TEST,LOAN_PERCENT_TEST);
        assertEquals(LOAN_AMOUNT_TEST,loan1.getLoanAmount());
        assertEquals(LOAN_MONTHLY_PAYMENT_TEST,loan1.getMonthlyPayment());
        assertEquals(LOAN_START_DATE_TEST,loan1.getLoanStartDate());
        assertEquals(LOAN_END_DATE_TEST,loan1.getLoanEndDate());
        assertEquals(LOAN_PERCENT_TEST,loan1.getLoanPercent());
    }
    @Test
    void getLoanAmountReturnsCorrectValue() {
        loan.setLoanAmount(LOAN_AMOUNT_TEST);
        assertEquals(LOAN_AMOUNT_TEST, loan.getLoanAmount());
    }

    @Test
    void setLoanAmountSetsCorrectly() {
        loan.setLoanAmount(LOAN_AMOUNT_TEST);
        assertEquals(LOAN_AMOUNT_TEST, loan.getLoanAmount());
    }

    @Test
    void getMonthlyPaymentReturnsCorrectValue() {
        loan.setMonthlyPayment(LOAN_MONTHLY_PAYMENT_TEST);
        assertEquals(LOAN_MONTHLY_PAYMENT_TEST, loan.getMonthlyPayment());
    }

    @Test
    void setMonthlyPaymentSetsCorrectly() {
        loan.setMonthlyPayment(LOAN_MONTHLY_PAYMENT_TEST);
        assertEquals(LOAN_MONTHLY_PAYMENT_TEST, loan.getMonthlyPayment());
    }

    @Test
    void getLoanStartDateReturnsCorrectValue() {
        loan.setLoanStartDate(LOAN_START_DATE_TEST);
        assertEquals(LOAN_START_DATE_TEST, loan.getLoanStartDate());
    }

    @Test
    void setLoanStartDateSetsCorrectly() {
        loan.setLoanStartDate(LOAN_START_DATE_TEST);
        assertEquals(LOAN_START_DATE_TEST, loan.getLoanStartDate());
    }

    @Test
    void getLoanEndDateReturnsCorrectValue() {
        loan.setLoanEndDate(LOAN_END_DATE_TEST);
        assertEquals(LOAN_END_DATE_TEST, loan.getLoanEndDate());
    }

    @Test
    void setLoanEndDateSetsCorrectly() {
        loan.setLoanEndDate(LOAN_END_DATE_TEST);
        assertEquals(LOAN_END_DATE_TEST, loan.getLoanEndDate());
    }

    @Test
    void getLoanPercentReturnsCorrectValue() {
        loan.setLoanPercent(LOAN_PERCENT_TEST);
        assertEquals(LOAN_PERCENT_TEST, loan.getLoanPercent());
    }

    @Test
    void setLoanPercentSetsCorrectly() {
        loan.setLoanPercent(LOAN_PERCENT_TEST);
        assertEquals(LOAN_PERCENT_TEST, loan.getLoanPercent());
    }
}