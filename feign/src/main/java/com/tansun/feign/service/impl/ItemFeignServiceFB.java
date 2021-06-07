package com.tansun.feign.service.impl;
import java.util.List;

import com.tansun.feign.service.ItemFeignService;
import com.tansun.pojo.Item;
import com.tansun.utils.JsonResult;
import org.springframework.stereotype.Component;

@Component
public class ItemFeignServiceFB implements ItemFeignService {

    @Override
    public JsonResult<List<Item>> getItems(String orderId) {
        return JsonResult.err("无法获取订单商品列表");
    }

    @Override
    public JsonResult decreaseNumber(List<Item> items) {
        return JsonResult.err("无法修改商品库存");
    }

}