package com.yuchen.data.mapper.mysql;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface MysqlDemo {

   List<Map> queryAll(@Param("str") Integer str);
}
