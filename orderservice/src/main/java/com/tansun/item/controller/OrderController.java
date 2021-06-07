package com.tansun.item.controller;

import com.tansun.pojo.Item;
import com.tansun.pojo.Order;
import com.tansun.pojo.User;
import com.tansun.service.ItemService;
import com.tansun.service.OrderService;
import com.tansun.utils.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class OrderController {

   private Logger logger = LoggerFactory.getLogger(OrderController.class);

   @Autowired
   private OrderService orderService;

   @Value("${server.port}")
   private int port;

   @GetMapping("/{orderId}")
   public JsonResult<Order> getOrder(@PathVariable Integer orderId) {
      logger.info("get order, id="+orderId);

      Order order = orderService.getOrder(orderId);
      return JsonResult.ok(order).msg("port="+port);
   }

   @GetMapping("/")
   public JsonResult addOrder() {
      //模拟post提交的数据
      Order order = new Order();
      order.setId(123);
      order.setUser(new User(7,null,null));
      order.setItems(Arrays.asList(new Item[] {
              new Item(1,"aaa",2),
              new Item(2,"bbb",1),
              new Item(3,"ccc",3),
              new Item(4,"ddd",1),
              new Item(5,"eee",5),
      }));
      orderService.addOrder(order);
      return JsonResult.ok().msg("port="+port);
   }
}
