package com.tansun.user.controller;

import com.tansun.pojo.User;
import com.tansun.service.UserService;
import com.tansun.utils.CookieUtil;
import com.tansun.utils.JsonResult;
import com.tansun.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class UserController {

   private static final Logger logger = LoggerFactory.getLogger(UserController.class);
   @Autowired
   private UserService userService;



   @GetMapping("{userId}")
   public JsonResult<User> getUser(@PathVariable Integer userId){
      logger.info("userId=="+userId);
      User user = userService.getUser(userId);
      return JsonResult.ok(user);
   }

   @GetMapping("{userId}/addScore")
   public JsonResult addScore(@PathVariable Integer userId, Integer score){
      userService.addScore(userId, score);
      return JsonResult.ok("");
   }

}
