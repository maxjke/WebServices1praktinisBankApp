package lt.viko.eif.mjakovcenko.bankapp.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Client class represents client data. It loads data about this class from database.
 * It has one-to-one connection with account and one-to-many connection with bank account.
 * @see Account
 * @see BankAccount
 * @see Loan
 * @see CreditCard
 */
@XmlRootElement
@Entity
@Table(name="client")
@XmlType(propOrder ={"firstName","lastName","account","bankAccountList","loanList","creditCardList"})
public class Client {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    /**
     * The first name of the client.
     */
    private String firstName;

    /**
     * The last name of the client.
     */
    private String lastName;

    /**
     * The client's account details. It has a one-to-one relationship with the Account entity.
     */
    @OneToOne(targetEntity = Account.class, cascade = CascadeType.ALL)
    private Account account;

    /**
     * The list of bank accounts associated with the client.
     * This is a one-to-many relationship.
     */
    @OneToMany(targetEntity = BankAccount.class, cascade = CascadeType.ALL)
    private List<BankAccount> bankAccountList = new ArrayList<>();

    /**
     * The list of loans taken out by the client.
     * This is a one-to-many relationship.
     */
    @OneToMany(targetEntity = Loan.class, cascade = CascadeType.ALL)
    private List<Loan> loanList = new ArrayList<>();

    /**
     * The list of credit cards owned by the client.
     * This is a one-to-many relationship.
     */
    @OneToMany(targetEntity = CreditCard.class, cascade = CascadeType.ALL)
    private List<CreditCard> creditCardList = new ArrayList<>();

    //Constructor

    /**
     * Constructor with parameters
     * @param firstName The first name of the client.
     * @param lastName The last name of the client.
     */
    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Non-arg constructor
     */
    public Client() {
    }
    /**
     * toString method override to print information client.
     * @return returns data of client, account, his bank accounts, credit cards and loans.
     */
    @Override
    public String toString(){
        return String.format("Client: \n"+
                "\tFirst name: %s\n"+
                "\t Last name: %s\n" +
                "Account: \n"+
                "%s " +
                "\n\tBank Accounts: \n%s" +
                "\t\t\tLoans: \n%s" +
                "\t\t\t\t\t\tCredit cards: \n%s",this.firstName,this.lastName,account,constructBankAccountList(),constructLoanList(),constructCreditCardList());

    }

    private String constructBankAccountList(){
        String result = "";
        for(BankAccount bankAccount : bankAccountList){
            result += bankAccount;
        }
        return result;

    }
    private String constructLoanList(){
        String result = "";
        for(Loan loan : loanList){
            result += loan;
        }
        return result;

    }
    private String constructCreditCardList(){
        String result = "";
        for(CreditCard card : creditCardList){
            result += card;
        }
        return result;

    }

    //Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<BankAccount> getBankAccountList() {
        return bankAccountList;
    }

    @XmlElementWrapper(name="BankAccountList")
    @XmlElement(name="BankAcoount")
    public void setBankAccountList(List<BankAccount> bankAccountList) {
        this.bankAccountList = bankAccountList;
    }

    public List<Loan> getLoanList() {
        return loanList;
    }
    @XmlElementWrapper(name="LoanList")
    @XmlElement(name="Loan")

    public void setLoanList(List<Loan> loanList) {
        this.loanList = loanList;
    }

    public List<CreditCard> getCreditCardList() {
        return creditCardList;
    }
    @XmlElementWrapper(name="CreditCardList")
    @XmlElement(name="CreditCard")
    public void setCreditCardList(List<CreditCard> creditCardList) {
        this.creditCardList = creditCardList;
    }
}
