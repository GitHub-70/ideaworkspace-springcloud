package com.tansun.service;

import com.tansun.pojo.User;

public interface UserService {
    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    User getUser(Integer userId);

    /**
     * 根据用户id增加用户积分
     * @param userId
     * @param score
     */
    void addScore(Integer userId, Integer score);

}