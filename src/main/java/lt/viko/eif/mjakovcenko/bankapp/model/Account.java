package lt.viko.eif.mjakovcenko.bankapp.model;
import javax.persistence.*;

/**
 * Account class represents account data. It loads data data about this class from database.
 *
 * @see BankAccount
 * @see Client
 */
@Entity
@Table(name="account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    private String username;
    private String password;


    //Constructor

    /**
     * Constructor with parameters.
     * @param username
     * @param password
     */
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     *  None-arg constructor
     */
    public Account() {
    }

    @Override
    public String toString() {
        return String.format("\t\tUsername: %s\n" +
                "\t\tPassword: %s",
                this.username,this.password);
    }

    //Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
