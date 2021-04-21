package com.example.shardingdemo.config;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: WangYuanrong
 * @Date: 2021/4/21 10:54
 */
@Getter
@Setter
public class DataSourceProperties {

    private String url;
    private String username;
    private String password;
    private String driverClassName;
    private Integer initialSize;
    private Integer minIdle;
    private Integer maxActive;
    private Long maxWait;

}
