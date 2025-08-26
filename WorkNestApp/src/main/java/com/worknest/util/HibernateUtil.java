package com.worknest.util;



import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hibernate Utility class to manage SessionFactory.
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            // Load configuration from hibernate.cfg.xml
            Configuration configuration = new Configuration().configure();

            // Add annotated entity classes (optional if using <mapping> in cfg.xml)
            configuration.addAnnotatedClass(com.worknest.model.User.class);
            configuration.addAnnotatedClass(com.worknest.model.Task.class);
            configuration.addAnnotatedClass(com.worknest.model.Comment.class);

            ServiceRegistry serviceRegistry =
                    new StandardServiceRegistryBuilder()
                            .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("Hibernate initialization failed: " + e);
        }
    }

    /**
     * Get the global SessionFactory
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Shutdown Hibernate and release resources
     */
    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
