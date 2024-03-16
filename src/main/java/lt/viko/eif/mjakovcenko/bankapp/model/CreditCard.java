package lt.viko.eif.mjakovcenko.bankapp.model;

import javax.persistence.*;
/**
 * CreditCard class represents clients CreditCard data. It loads data about this class from database.
 *
 */
@Entity
@Table(name="creditcard")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    private double cardLimit;
    private String expireDate;
    private String CVC;
    private String cardNumber;

    //Constructor

    public CreditCard(double cardLimit, String expireDate, String CVC, String cardNumber) {
        this.cardLimit = cardLimit;
        this.expireDate = expireDate;
        this.CVC = CVC;
        this.cardNumber = cardNumber;
    }

    public CreditCard() {
    }

    @Override
    public String toString() {
        return String.format("\t\t\t\t\t\t\tCredit card:\n " +
                        "\t\t\t\t\t\t\t\t\tCard limit: %s\n" +
                        "\t\t\t\t\t\t\t\t\tCard expire date: %s\n" +
                        "\t\t\t\t\t\t\t\t\tCard CVC code: %s\n" +
                        "\t\t\t\t\t\t\t\t\tCard number: %s\n",this.cardLimit,this.expireDate,this.CVC,this.cardNumber);
    }

    //Getters and setters

    public double getCardLimit() {
        return cardLimit;
    }

    public void setCardLimit(double cardLimit) {
        this.cardLimit = cardLimit;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getCVC() {
        return CVC;
    }

    public void setCVC(String CVC) {
        this.CVC = CVC;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
