package com.tansun.service;

import com.tansun.pojo.Item;
import com.tansun.pojo.Order;

import java.util.List;

public interface OrderService {
    /**
     * 获取订单信息
     * @param orderId
     * @return
     */
    Order getOrder(Integer orderId);

    /**
     * 增加订单
     * @param order
     */
    void addOrder(Order order);

}