package com.djg.signin.service;

import com.djg.signin.domain.Sign;

import java.util.List;

/**
 * @NAME: SignService
 * @author: DaiJianG
 * @DATE: 2021/10/1
 **/
public interface SignService {
    Integer signIn(Sign sign);
    Integer signOut(Sign sign);
    List<Sign> selectList(Sign sign);
}
