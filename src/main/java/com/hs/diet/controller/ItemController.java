package com.hs.diet.controller;

import com.hs.diet.entity.Item;
import com.hs.diet.service.ItemDataService;
import com.hs.diet.service.ItemService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemDataService itemDataService;

    /**
     * 对外提供接口服务，查询商品信息
     *
     * @param id
     * @return
     */
    @GetMapping(value = "item/{id}")
    @ApiOperation("获取商品详情")
    @ApiImplicitParam(name = "itemName", value = "商品名称", required = true, dataType = "String")
    public Item queryItemById(@PathVariable("id") Long id) {
        return this.itemService.queryItemById(id);
    }

    @GetMapping(value = "item/add/{title}")
    public String addItem(@PathVariable("title")String title){
        Item item=new Item();
        item.setTitle(title);
        item.setDescription("ss");
        item.setPic("sss");
        item.setPrice(20.0);
        itemDataService.add(item);
        return "success";
    }
}
