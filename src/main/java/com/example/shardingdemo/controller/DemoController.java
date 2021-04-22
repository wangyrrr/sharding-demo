package com.example.shardingdemo.controller;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.shardingdemo.entity.Order;
import com.example.shardingdemo.entity.OrderItem;
import com.example.shardingdemo.mapper.OrderItemMapper;
import com.example.shardingdemo.mapper.OrderMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: WangYuanrong
 * @Date: 2021/4/21 15:16
 */
@RestController
@RequestMapping("test")
public class DemoController {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderItemMapper orderItemMapper;


    @Transactional
    @GetMapping("create")
    public String create() {
        for (int i = 0; i < 10; i++) {
            Order order = new Order();
            order.setTotal(i + "");
            order.setUserId((long) i);
            orderMapper.insert(order);

            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(order.getId());
            orderItem.setItemName(order.getId() + "______0");
            orderItemMapper.insert(orderItem);
            if (i == 9) {
//                throw new RuntimeException();
            }
            OrderItem orderItem1 = new OrderItem();
            orderItem1.setOrderId(order.getId());
            orderItem1.setItemName(order.getId() + "______1");
            orderItemMapper.insert(orderItem1);
        }

        return "success";
    }

    @PostMapping("update")
    public Boolean update(@RequestParam Long orderId) {
        LambdaUpdateWrapper<Order> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(Order::getId, orderId);
        wrapper.set(Order::getTotal, "11111111");
        int i = orderMapper.update(null, wrapper);
        return i > 0;
    }

    @PostMapping("updateEntity")
    public Boolean updateEntity(@RequestParam Long orderId) {
        Order order = orderMapper.selectById(orderId);
        order.setUserId(null);
        order.setTotal("222222222");
        int i = orderMapper.updateById(order);
        return i > 0;
    }


    @GetMapping("delete")
    public String delete(@RequestParam Long orderItemId) {
        orderItemMapper.deleteById(orderItemId);
        return "success";
    }

    @GetMapping("list")
    public List<Order> list() {
        return orderMapper.selectList(null);
    }

    @GetMapping("page")
    public IPage<Order> page(@RequestParam Integer current,
                             @RequestParam Integer size) {
        Page<Order> page = new Page<>(current, size);
        Page<Order> result = orderMapper.selectPage(page, null);
        return result;
    }
}
