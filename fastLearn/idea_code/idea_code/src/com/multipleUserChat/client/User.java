package com.multipleUserChat.client;

import java.io.Serializable;

/**
 * 用户信息
 */
public class User implements Serializable {
    private String usrId;
    private String password;
    private static final long serialVersionUID = 1L;

    public String getUsrId() {
        return usrId;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String usrId, String password) {
        this.usrId = usrId;
        this.password = password;
    }
}
