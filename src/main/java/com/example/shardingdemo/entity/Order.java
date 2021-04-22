package com.example.shardingdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: WangYuanrong
 * @Date: 2021/4/21 14:16
 */
@Data
@TableName("t_order_")
public class Order implements Serializable {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private Long userId;

    private String total;

    private Date createTime;

    @Version
    private Integer version;

}
