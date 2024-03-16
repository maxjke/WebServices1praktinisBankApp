package lt.viko.eif.mjakovcenko.bankapp.db;

import lt.viko.eif.mjakovcenko.bankapp.model.*;
import lt.viko.eif.mjakovcenko.bankapp.util.HibernateUtil;
import lt.viko.eif.mjakovcenko.bankapp.util.JaxbUtil;
import org.h2.tools.Server;
import org.hibernate.Session;
import org.hibernate.Transaction;


import javax.xml.bind.JAXBException;
import java.sql.SQLException;
import java.util.List;

/**
 * DBLoader class represents creating objects with constructors and loading them into database using Hibernate framework.
 *
 * @see ClientLoader
 *
 */
public class DBLoader {

    static Server server;
    static{
        try{
        server = Server.createTcpServer("-tcpPort","9893").start();
        Client client1 = new Client("Name1","LastName1");

        Account account1 = new Account("Username1","Password1");
        CreditCard creditCard = new CreditCard(10000.00,"2026-03-13", "123","1234 1234 1234 1234");
        CreditCard creditCard2 = new CreditCard(1000000.00,"2028-03-15", "456","9876 5432 0000 0000");
            CreditCard creditCard3 = new CreditCard(25000.00,"2030-03-15", "001","0000 0000 0000 0000");

            Loan loan1 = new Loan(100.00,10.00,"2024-03-12","2025-01-12",3);
            Loan loan2 = new Loan(10000.00,100.00,"2024-03-15","2030-03-15",2);
            Loan loan3 = new Loan(1000.00,20.00,"2024-03-10","2025-03-10",1);

            BankAccount bankAccount1 = new BankAccount(1000.25, "euro");
            BankAccount bankAccount2 = new BankAccount(10.00, "dollar");
            BankAccount bankAccount3 = new BankAccount(500.00, "pound");

            client1.getBankAccountList().add(bankAccount1);
            client1.getBankAccountList().add(bankAccount2);
            client1.getBankAccountList().add(bankAccount3);
            client1.getLoanList().add(loan1);
            client1.getLoanList().add(loan2);
            client1.getLoanList().add(loan3);
            client1.getCreditCardList().add(creditCard);
            client1.getCreditCardList().add(creditCard2);
            client1.getCreditCardList().add(creditCard3);

            client1.setAccount(account1);
            System.out.println(client1);


            Transaction transaction = null;

            try(Session session = HibernateUtil.getSessionFactory().openSession()){
                transaction = session.beginTransaction();
                session.save(client1);
                transaction.commit();
            } catch (Exception e){
                if(transaction!=null){
                    transaction.rollback();
                }
                e.printStackTrace();
            }
            finally {
                server.shutdown();
            }
            }catch (SQLException e){
            throw new RuntimeException(e);
        }


    }



}
