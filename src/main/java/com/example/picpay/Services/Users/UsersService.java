package com.example.picpay.Services.Users;

import com.example.picpay.Entity.Users.UsersEntity;

import java.util.List;

public interface UsersService {

    UsersEntity saveUsers(UsersEntity usersEntity) throws Exception;

    List<UsersEntity> getAllUsers() throws Exception;
}
