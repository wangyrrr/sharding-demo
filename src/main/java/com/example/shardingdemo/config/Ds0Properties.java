package com.example.shardingdemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: WangYuanrong
 * @Date: 2021/4/21 11:13
 */
@Component
@ConfigurationProperties(prefix = "datasource.ds0")
public class Ds0Properties extends DataSourceProperties {
}
