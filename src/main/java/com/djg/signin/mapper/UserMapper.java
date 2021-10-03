package com.djg.signin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.djg.signin.domain.User;
import org.apache.ibatis.annotations.Update;

/**
 * @NAME: UserMapper
 * @author: DaiJianG
 * @DATE: 2021/10/1
 **/
public interface UserMapper extends BaseMapper<User> {

    @Update("update user set cumulate_days_month = 0")
    int updateMonthDay();
}
