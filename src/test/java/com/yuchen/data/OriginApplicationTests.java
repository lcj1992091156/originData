package com.yuchen.data;

import com.yuchen.data.enums.TypeEnums;
import com.yuchen.data.mapper.neo4j.UserMapper;
import com.yuchen.data.model.Protege;
import com.yuchen.data.model.UserModel;
import com.yuchen.data.service.ProtegeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OriginApplicationTests {
    @Autowired
    private ProtegeService protegeService;
    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
//        UserModel  model=new UserModel();
//        model.setAge(22);
//        model.setName("ces");
//        userMapper.add(model);
        Protege  protege=new Protege();
        protege.setName("创建");
        protege.setDataType(TypeEnums.CLASS.getCode());
        protege.setStrId("uuid");
        protegeService.addProtege(protege);
//
//        Protege  protege2=new Protege();
//        protege2.setName("创建");
//        protege2.setDataType(TypeEnums.CLASS.getCode());
//        protege2.setUuId("uuid");
//        protegeService.addProtege(protege2);
    }

}
