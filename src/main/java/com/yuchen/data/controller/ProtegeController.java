package com.yuchen.data.controller;


import com.yuchen.data.model.Protege;
import com.yuchen.data.request.ClassParamRequestEntity;
import com.yuchen.data.request.RelationshipParamRequestEntity;
import com.yuchen.data.service.ProtegeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/class")
@Log4j2
public class ProtegeController {
    @Autowired
    private ProtegeService protegeService;

    /**
     * 添加节点接口
     * @param protege
     * @return
     */
    @PostMapping("/addClass")
    public Object addClass(@RequestBody Protege protege) {
        return protegeService.addProtege(protege);
    }

    /**
     * 添加子节点 跟父子关系的接口
     * @param entity
     * @return
     */
    @PostMapping("/addRelationship")
    public Object addRelationship(@RequestBody RelationshipParamRequestEntity entity) {
        return protegeService.addProtegeRelationShip(entity);
    }

    /**
     *查询父子节点
     * @param entity
     * @return
     */
    @PostMapping("/getAll")
    public Object  queryAll(@RequestBody ClassParamRequestEntity entity){
        return protegeService.queryAll(entity);
    }


}
