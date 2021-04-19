package com.yuchen.data.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
@Data
@ConfigurationProperties(prefix = "spring.datasource.second")
public class DataSourceSecond {
    private String url;
    private String username;
    private String password;
    private String driverClassName;
}
