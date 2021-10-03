package com.djg.signin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.djg.signin.domain.Sign;
import com.djg.signin.domain.User;
import com.djg.signin.mapper.UserMapper;
import com.djg.signin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @NAME: UserServiceImpl
 * @author: DaiJianG
 * @DATE: 2021/10/1
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询
     * @param user
     * @return
     */
    @Override
    public List<User> selectList(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        return userMapper.selectList(wrapper);
    }
}
