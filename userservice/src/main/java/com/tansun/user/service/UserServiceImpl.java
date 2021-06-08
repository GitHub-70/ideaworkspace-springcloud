package com.tansun.user.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tansun.pojo.User;
import com.tansun.service.UserService;
import com.tansun.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.List;

@RefreshScope // 对该 Bean 刷新配置信息
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    /**
     * @RefreshScope 或
     * @ConfigurationProperties 如果有前缀，则可以设置prefix=XXX
     * 动态刷新 配置信息
     */
    @Value("${sp.user-service.users}")
    private String userJson;

    @Override
    public User getUser(Integer userId) {
        // 解析json串
        List<User> userList = JsonUtil.from(userJson, new TypeReference<List<User>>() {});
        for (User user: userList) {
            if (user.getId().equals(userId)){
                return user;
            }
        }
        return new User(userId,"userName", "password");
    }

    @Override
    public void addScore(Integer userId, Integer score) {
        // todo 增加积分逻辑
        logger.info("用户["+userId+"]增加积分["+score+"]成功-----");
    }
}
