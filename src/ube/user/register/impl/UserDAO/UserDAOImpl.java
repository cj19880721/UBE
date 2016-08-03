package ube.user.register.impl.UserDAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import ube.user.register.itf.dao.IBaseDAO;

public class UserDAOImpl implements IBaseDAO {

    private Session session;

    @Override
    public void saveObject(Object obj) throws HibernateException {
        this.getSession().save(obj);
    }

    @Override
    public Session getSession() {
        return this.session;
    }

    @Override
    public void setSession(Session s) {
        this.session = s;
    }

}
