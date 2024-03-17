package lt.viko.eif.mjakovcenko.bankapp.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * HibernateUtil is utility class for Hibernate framework that connects with database.
 */
public class HibernateUtil {

    /**
     * The registry that holds the services required by Hibernate.
     */
    public static StandardServiceRegistry registry;

    /**
     * The session factory that creates sessions for interacting with the database.
     */
    public static SessionFactory sessionFactory;

    /**
     * Method of Hibernate framework to get session factory to open database connection.
     * @return session factory. Can be called to open session.
     */
    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            try {
                registry = new StandardServiceRegistryBuilder().configure().build();

                MetadataSources sources = new MetadataSources(registry);
                Metadata metadata = sources.getMetadataBuilder().build();

                sessionFactory = metadata.getSessionFactoryBuilder().build();
            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return  sessionFactory;
    }

    /**
     * Shuts down registry
     */
    public static void shutdown(){
        if(registry!=null){
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}