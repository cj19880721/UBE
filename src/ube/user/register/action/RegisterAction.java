package ube.user.register.action;

import ube.user.register.bean.User;
import ube.user.register.impl.service.UserRegisterImpl;
import ube.user.register.itf.service.IUserRegister;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    private User user;

    private IUserRegister registerService;

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public IUserRegister getRegisterService() {
        return this.registerService;
    }

    public void setRegisterService(IUserRegister registerService) {
        this.registerService = registerService;
    }

    @Override
    public String execute() throws Exception {
        if (this.registerService == null) {
            this.registerService = new UserRegisterImpl();
        }
        if (this.registerService.register(this.user)) {
            return Action.SUCCESS;
        }
        return Action.ERROR;
    }

}
