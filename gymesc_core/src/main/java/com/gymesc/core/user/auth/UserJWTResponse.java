package com.gymesc.core.user.auth;

import com.gymesc.core.user.repository.dto.UserDTO;

import java.io.Serializable;

public class UserJWTResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private String jwt;
    private UserDTO userDTO;

    public UserJWTResponse(String jwt, UserDTO userDTO) {
        this.jwt = jwt;
        this.userDTO = userDTO;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public UserDTO getUserVO() {
        return userDTO;
    }

    public void setUserVO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
