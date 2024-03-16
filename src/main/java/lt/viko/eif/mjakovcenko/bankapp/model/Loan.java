package lt.viko.eif.mjakovcenko.bankapp.model;

import javax.persistence.*;

/**
 * Loan class represents data about loan. It loads data about this class from database.
 *
 */
@Entity
@Table(name="loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    private double loanAmount;
    private double monthlyPayment;
    private String loanStartDate;
    private String loanEndDate;
    private int loanPercent;

    //Constructor

    /**
     * Constructor with parameters
     * @param loanAmount
     * @param monthlyPayment
     * @param loanStartDate
     * @param loanEndDate
     * @param loanPercent
     */
    public Loan(double loanAmount, double monthlyPayment, String loanStartDate, String loanEndDate, int loanPercent) {
        this.loanAmount = loanAmount;
        this.monthlyPayment = monthlyPayment;
        this.loanStartDate = loanStartDate;
        this.loanEndDate = loanEndDate;
        this.loanPercent = loanPercent;
    }

    /**
     * Non-arg constructor
     */
    public Loan() {
    }

    @Override
    public String toString() {
        return String.format("\t\t\t\tLoan: \n" +
                "\t\t\t\t\tLoan amount: %s\n" +
                "\t\t\t\t\tMonthly payment: %s\n" +
                "\t\t\t\t\tLoan start date: %s\n" +
                "\t\t\t\t\tLoan end date: %s\n" +
                "\t\t\t\t\tLoan percent: %s \n", this.loanAmount,this.monthlyPayment,this.loanStartDate,
                this.loanEndDate,this.loanPercent);
    }

    //Getters and Setters
    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public String getLoanStartDate() {
        return loanStartDate;
    }

    public void setLoanStartDate(String loanStartDate) {
        this.loanStartDate = loanStartDate;
    }

    public String getLoanEndDate() {
        return loanEndDate;
    }

    public void setLoanEndDate(String loanEndDate) {
        this.loanEndDate = loanEndDate;
    }

    public int getLoanPercent() {
        return loanPercent;
    }

    public void setLoanPercent(int loanPercent) {
        this.loanPercent = loanPercent;
    }

}
