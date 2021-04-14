package com.yuchen.data.controller;

import com.yuchen.data.mapper.mysql.MysqlDemo;
import com.yuchen.data.mapper.neo4j.UserMapper;
import com.yuchen.data.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private  MysqlDemo mysqlDemo;

    @Autowired
    private UserMapper userMapper;
    @PostMapping("/1")
    public  Object  demo1(){

        List<Map> maps = mysqlDemo.queryAll();
        List<UserModel> all = userMapper.getAll();
        Map map=new HashMap(2);
        map.put("mysql",maps);
        map.put("neo4j",all);
        return map;
    }
}
