package com.example.shardingdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author: WangYuanrong
 * @Date: 2022/1/13 9:03
 */
@Data
@TableName("t_user")
public class User {


    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;
}
