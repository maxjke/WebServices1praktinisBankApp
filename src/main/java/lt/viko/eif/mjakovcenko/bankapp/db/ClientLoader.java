package lt.viko.eif.mjakovcenko.bankapp.db;

import lt.viko.eif.mjakovcenko.bankapp.model.Client;
import lt.viko.eif.mjakovcenko.bankapp.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

/**
 * Client loader class loads all possible data about client from database.
 * @see DBLoader
 */
public class ClientLoader {
    /**
     * loadClients method that opens session loads all data from database into clientList and then prints it into console.
     */
    public static void loadClients(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            List<Client> clientList = session.createQuery("from Client",Client.class).list();
            clientList.forEach(client -> System.out.println(client));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }



}
