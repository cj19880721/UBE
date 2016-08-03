package ube.user.register.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateSessionFactory {
    private static final String CFG_FILE_LOCATION = "/hibernate.cfg.xml";

    private static final ThreadLocal<Session> threadlocal = new ThreadLocal<Session>();

    private static final Configuration cfg = new Configuration().configure(HibernateSessionFactory.CFG_FILE_LOCATION);

    private static ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(
            HibernateSessionFactory.cfg.getProperties()).build();

    private static SessionFactory sessionFactory;

    public static Session currentSession() throws HibernateException {
        Session session = HibernateSessionFactory.threadlocal.get();
        if (session == null || session.isOpen() == false) {
            if (HibernateSessionFactory.sessionFactory == null) {
                try {
                    HibernateSessionFactory.sessionFactory =
                            HibernateSessionFactory.cfg.buildSessionFactory(HibernateSessionFactory.registry);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            session = HibernateSessionFactory.sessionFactory.openSession();
            HibernateSessionFactory.threadlocal.set(session);
        }
        return session;
    }

    public static void closeSession() throws HibernateException {
        Session session = HibernateSessionFactory.threadlocal.get();
        HibernateSessionFactory.threadlocal.set(null);
        if (session != null) {
            session.close();
        }
    }
}
