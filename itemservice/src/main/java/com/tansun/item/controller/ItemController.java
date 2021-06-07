package com.tansun.item.controller;

import com.tansun.pojo.Item;
import com.tansun.service.ItemService;
import com.tansun.utils.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/")
public class ItemController {

   private Logger logger = LoggerFactory.getLogger(ItemController.class);

   @Autowired
   private ItemService itemService;

   @Value("${server.port}")
   private int port;

   @GetMapping("{orderId}")
   public JsonResult<List<Item>> getItems(@PathVariable Integer orderId) throws InterruptedException {
      // 设置随机延迟时间，以便测试 ribbon 的重试
      long t = new Random().nextInt(5000);
      double random = Math.random();
      logger.info("当前随机数[{}{}",random,"]");
      if(random < 0.6) {
         logger.info("item-service-"+port+" - 暂停 "+t);
         Thread.sleep(t);
      }

      logger.info("server.port=="+port+", orderId=="+orderId);
      List<Item> items = itemService.getItem(orderId);
      return JsonResult.ok(items).msg("port="+port);
   }


   @PostMapping("addItem")
   public JsonResult addItem(@RequestBody List<Item> items){
      itemService.dereaseNumbers(items);
      return JsonResult.ok(items);
   }
}
