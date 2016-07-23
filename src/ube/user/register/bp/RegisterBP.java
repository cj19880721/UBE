package ube.user.register.bp;

import ube.user.bean.User;

public class RegisterBP {
    public boolean register(User user) {
        if (user == null) {
            return false;
        }
        if ("cj".equals(user.getUsername())) {
            return false;
        }
        return true;
    }

}
