package lt.viko.eif.mjakovcenko.bankapp.db;

import lt.viko.eif.mjakovcenko.bankapp.util.HibernateUtil;
import org.hibernate.Session;

/**
 * GenericObjectLoader class represents loading data from database using generic method loadById.
 */
public class GenericObjectLoader {
    /**
     * loadById takes object from database by its ID
     * @param entityType The Class object of the entity type to be loaded. This is used to inform Hibernate
     * about the type of the entity being fetched.
     * @param entityId The ID of the entity to be retrieved from the database.
     * @param <T> The type parameter of the entity, making this method applicable to any class.
     * @return The entity fetched from the database if found.
     */
    public static <T> T loadById(Class<T> entityType, int entityId) {
        T entity = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.get(entityType, entityId);
            if (entity != null) {
                System.out.println(entity);
            } else {
                System.out.println(entityType.getSimpleName() + " with ID " + entityId + " not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

}
