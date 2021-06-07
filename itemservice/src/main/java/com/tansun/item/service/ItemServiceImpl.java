package com.tansun.item.service;

import com.tansun.pojo.Item;
import com.tansun.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private static final Logger log = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Override
    public List<Item> getItem(Integer orderId) {
        ArrayList<Item> list = new ArrayList<Item>();
        list.add(new Item(1, "商品 1",1));
        list.add(new Item(2, "商品 2",2));
        list.add(new Item(3, "商品 3",3));
        list.add(new Item(4, "商品 4",4));
        list.add(new Item(5, "商品 5",5));
        return list;
    }

    @Override
    public void dereaseNumbers(List<Item> itemList) {
        if (log.isInfoEnabled()) {
            for(Item item : itemList) {
                log.info("减少库存 - "+item);
            }
        }
    }

}
