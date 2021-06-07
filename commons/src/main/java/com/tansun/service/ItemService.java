package com.tansun.service;

import com.tansun.pojo.Item;

import java.util.List;

public interface ItemService {
    /**
     * 根据订单编号，获取订单商品信息
     * @param orderId
     * @return
     */
    List<Item> getItem(Integer orderId);

    /**
     * 批量增加商品
     * @param itemList
     */
    void dereaseNumbers(List<Item> itemList);

}