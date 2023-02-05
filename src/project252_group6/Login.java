package project252_group6;


import project252_group6.Access;
import project252_group6.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author reemansabir
 */
public class Login implements Access {

    private String username;
    private String password;

    public Login(String user, String password) {
        this.username = user;
        this.password = password;
    }

    public String getUser() {
        return username;
    }

    public void setUser(String user) {
        this.username = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public User checkaccess() {
        return null;
    }

}