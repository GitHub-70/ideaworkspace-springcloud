package com.tansun.item.service;

import com.tansun.pojo.Item;
import com.tansun.pojo.Order;
import com.tansun.pojo.User;
import com.tansun.service.ItemService;
import com.tansun.service.OrderService;
import com.tansun.utils.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private ItemFeignService itemService;
    @Autowired
    private UserFeignService userService;

    @Override
    public Order getOrder(Integer orderId) {
        //TODO: 调用user-service获取用户信息
        JsonResult<User> user = userService.getUser(7);
        //TODO: 调用item-service获取商品信息
        JsonResult<List<Item>> items = itemService.getItems(orderId);

        Order order = new Order();
        order.setId(orderId);
        return order;
    }

    @Override
    public void addOrder(Order order) {
        //TODO: 调用item-service减少商品库存
        itemService.decreaseNumber(order.getItems());
        //TODO: 调用user-service增加用户积分
        userService.addScore(7, 100);
        log.info("保存订单："+order);
    }
}
