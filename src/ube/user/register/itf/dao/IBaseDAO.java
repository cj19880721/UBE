package ube.user.register.itf.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public interface IBaseDAO {

    public void saveObject(Object obj) throws HibernateException;

    public Session getSession();

    public void setSession(Session s);

}
