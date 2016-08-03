package ube.user.register.bp;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ube.user.register.bean.User;
import ube.user.register.impl.HibernateSessionFactory;
import ube.user.register.itf.dao.IBaseDAO;

public class RegisterBP {
    public boolean register(User user, IBaseDAO dao) {
        if (user == null) {
            return false;
        }
        Session session = HibernateSessionFactory.currentSession();
        dao.setSession(session);
        Transaction transaction = session.beginTransaction();
        User usert = this.genderTransferToBinary(user);
        dao.saveObject(usert);
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return true;
    }

    private User genderTransferToBinary(User user) {
        User rtn = user;
        if ("ÄÐ".equals(rtn.getGender())) {
            rtn.setGender("1");
        }
        else {
            rtn.setGender("2");
        }
        return rtn;
    }
}
