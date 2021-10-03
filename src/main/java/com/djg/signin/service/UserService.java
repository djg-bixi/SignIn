package com.djg.signin.service;

import com.djg.signin.domain.Sign;
import com.djg.signin.domain.User;

import java.util.List;

/**
 * @NAME: UserService
 * @author: DaiJianG
 * @DATE: 2021/10/1
 **/
public interface UserService {
    List<User> selectList(User user);
}
