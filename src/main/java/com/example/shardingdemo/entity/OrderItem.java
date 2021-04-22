package com.example.shardingdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: WangYuanrong
 * @Date: 2021/4/21 14:20
 */
@Data
@TableName("t_order_item_")
public class OrderItem implements Serializable {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private Long orderId;

    private String itemName;

    private Date createTime;

    private Boolean deleted;

}
