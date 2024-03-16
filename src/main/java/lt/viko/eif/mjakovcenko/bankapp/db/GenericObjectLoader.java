package lt.viko.eif.mjakovcenko.bankapp.db;

import lt.viko.eif.mjakovcenko.bankapp.util.HibernateUtil;
import org.hibernate.Session;

/**
 * GenericObjectLoader class represents loading data from database using generic method loadById.
 */
public class GenericObjectLoader {
    /**
     * loadById takes object from database by its ID
     * @param entityType
     * @param entityId
     * @return it returns entity of chosen type filled with data from database.
     * @param <T>
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
