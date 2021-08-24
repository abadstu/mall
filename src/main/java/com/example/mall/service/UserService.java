package com.example.mall.service;


import com.example.mall.exception.MallException;
import com.example.mall.model.pojo.User;

public interface UserService {


    User getUser();

    void register(String userName, String password) throws MallException;

    User login(String userName, String password) throws MallException;

    void updateInformation(User user) throws  MallException;

    boolean checkAdminRole(User user);
}
