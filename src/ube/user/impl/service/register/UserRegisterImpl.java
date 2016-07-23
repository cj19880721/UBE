package ube.user.impl.service.register;

import ube.user.bean.User;
import ube.user.itf.register.service.IUserRegister;
import ube.user.register.bp.RegisterBP;

public class UserRegisterImpl implements IUserRegister {

    @Override
    public boolean register(User vo) {
        if (vo == null) {
            return false;
        }
        RegisterBP bp = new RegisterBP();
        return bp.register(vo);
    }

}
