package com.tunsun.RibbonController;

import java.util.List;

import com.tansun.pojo.Item;
import com.tansun.pojo.Order;
import com.tansun.pojo.User;
import com.tansun.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class RibbonController {


    @Autowired
    private RestTemplate rt;

    //调用后台的商品微服务
    //获取商品
    @GetMapping("/item-service/{orderId}")
    public JsonResult<List<Item>> getItems(@PathVariable String orderId) {
        //向指定微服务地址发送 get 请求，并获得该服务的返回结果
        //{1} 占位符，用 orderId 填充
        //这里服务器路径用 服务名称 代替，ribbon 会向服务的多台集群服务器分发请求
        return rt.getForObject("http://item-server/{1}", JsonResult.class, orderId);
    }
    //@RequestBody: JSON转对象
    //减少商品数量
    @PostMapping("/item-service/decreaseNumber")
    public JsonResult decreaseNumber(@RequestBody List<Item> items) {
        //发送 post 请求
        return rt.postForObject("http://item-server/decreaseNumber", items, JsonResult.class);
    }

    /////////////////////////////////////////
    //调用后台的用户微服务
    //RestTemplate 只能访问单台服务器,不能实现负载均衡的功能.
    //获取用户
    @GetMapping("/user-service/{userId}")
    public JsonResult<User> getUser(@PathVariable Integer userId) {
        return rt.getForObject("http://user-server/{1}", JsonResult.class, userId);
    }
    //添加积分
    @GetMapping("/user-service/{userId}/score")
    public JsonResult addScore(
            @PathVariable Integer userId, Integer score) {
        return rt.getForObject("http://user-server/{1}/score?score={2}", JsonResult.class, userId, score);
    }

    /////////////////////////////////////////
    //调用后台的订单微服务
    //获取订单
    @GetMapping("/order-service/{orderId}")
    public JsonResult<Order> getOrder(@PathVariable String orderId) {
        return rt.getForObject("http://order-server/{1}", JsonResult.class, orderId);
    }
    //添加订单
    @GetMapping("/order-service")
    public JsonResult addOrder() {
        return rt.getForObject("http://order-server/", JsonResult.class);
    }
}