package lt.viko.eif.mjakovcenko.bankapp.model;

import javax.persistence.*;

/**
 * Bank account class represents data of a bank account of a client. It loads data about this class from database.
 */
@Entity
@Table(name="bankaccount")
public class BankAccount {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    private double balance;
    private String currency;


    //Constructor

    /**
     * Constructor with parameters
     * @param balance
     * @param currency
     */
    public BankAccount(double balance, String currency) {
        this.balance = balance;
        this.currency = currency;
    }

    /**
     * Non-arg constructor
     */
    public BankAccount() {
    }

    /**
     * toString method override to print information about possible bank accounts.
     * @return returns data of balance and currency.
     */
    @Override
    public String toString() {
        return String.format("\t\tBank Account: \n" +
                "\t\t\t Balance: %s\n" +
                "\t\t\t Currency: %s\n", this.balance,this.currency);
    }

    //Getters and Setters
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
