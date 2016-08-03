package ube.user.register.impl.service;

import org.hibernate.Session;

import ube.user.register.bean.User;
import ube.user.register.bp.RegisterBP;
import ube.user.register.impl.UserDAO.UserDAOImpl;
import ube.user.register.itf.dao.IBaseDAO;
import ube.user.register.itf.service.IUserRegister;

public class UserRegisterImpl implements IUserRegister {

    private IBaseDAO dao;

    private Session session;

    public UserRegisterImpl() {
        this.dao = new UserDAOImpl();
    }

    @Override
    public boolean register(User vo) {
        if (vo == null) {
            return false;
        }
        RegisterBP bp = new RegisterBP();
        return bp.register(vo, this.dao);
    }

}
