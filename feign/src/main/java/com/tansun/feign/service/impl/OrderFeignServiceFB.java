package com.tansun.feign.service.impl;

import com.tansun.feign.service.OrderFeignService;
import com.tansun.pojo.Order;
import com.tansun.utils.JsonResult;
import org.springframework.stereotype.Component;


@Component
public class OrderFeignServiceFB implements OrderFeignService {

    @Override
    public JsonResult<Order> getOrder(String orderId) {
        return JsonResult.err("无法获取商品订单");
    }

    @Override
    public JsonResult addOrder() {
        return JsonResult.err("无法保存订单");
    }

}