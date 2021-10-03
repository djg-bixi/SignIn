package com.djg.signin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.djg.signin.domain.Sign;
import com.djg.signin.domain.User;
import com.djg.signin.mapper.SignMapper;
import com.djg.signin.mapper.UserMapper;
import com.djg.signin.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @NAME: SignServiceImpl
 * @author: DaiJianG
 * @DATE: 2021/10/1
 **/
@Service
public class SignServiceImpl implements SignService {
    @Autowired
    private SignMapper signMapper;
    @Autowired
    private UserMapper userMapper;


    /**
     * 签到
     * @param sign
     * @return
     */
    @Override
    public Integer signIn(Sign sign) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        //查询该用户记录
        User user = userMapper.selectById(sign.getUserId());
        //如果存在该用户
        if(user!=null){

            //查询当天该人的签到记录 有记录 不让再次签到
            QueryWrapper<Sign> wrapper = new QueryWrapper<>();
            wrapper.eq("user_id",sign.getUserId()).ge("sign_in_time",simpleDateFormat.format(new Date()));
            List<Sign> signs = signMapper.selectList(wrapper);
            if (signs.size()>0){
                return -2;
            }

            //累计天数做累加  修改
            user.setCumulateDaysMonth(user.getCumulateDaysMonth()+1);
            user.setTotalDays(user.getTotalDays()+1);
            userMapper.updateById(user);

            //添加签到记录
            sign.setSignInTime(new Date());
            return signMapper.insert(sign);
        }else {
            //如果用户不存在 返回错误信息
            return -1;
        }
    }

    /**
     * 签退
     * @param sign
     * @return
     */
    @Override
    public Integer signOut(Sign sign) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        //先查询到签到记录
        QueryWrapper<Sign> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",sign.getUserId()).ge("sign_in_time",simpleDateFormat.format(new Date()));
        List<Sign> signs = signMapper.selectList(wrapper);
        //如果没有签到记录
        if (signs.size()==0) {
            return -1;
        }else {
            Sign signout = signs.get(0);
            signout.setSignOutTime(new Date());
            return signMapper.updateById(signout);
        }
    }

    /**
     * 查询
     * @param sign
     * @return
     */
    @Override
    public List<Sign> selectList(Sign sign) {
        QueryWrapper<Sign> wrapper = new QueryWrapper<>();
        if (sign.getStartTime()!=null && sign.getEndTime() != null) {
            wrapper.between("sign_in_time" , sign.getStartTime(),sign.getEndTime());
        }
        return signMapper.selectList(wrapper);
    }
}
