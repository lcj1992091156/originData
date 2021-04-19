package com.yuchen.data;

import com.yuchen.data.config.DataSourcePrimary;
import com.yuchen.data.config.DataSourceSecond;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import javax.xml.crypto.Data;

@SpringBootApplication
@EnableConfigurationProperties(value = { DataSourcePrimary.class, DataSourceSecond.class })
public class OriginApplication {
    public static void main(String[] args) {
        SpringApplication.run(OriginApplication.class, args);
    }

}
