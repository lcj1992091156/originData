package com.yuchen.data.service;

import com.yuchen.data.model.Protege;
import com.yuchen.data.request.ClassParamRequestEntity;
import com.yuchen.data.request.RelationshipParamRequestEntity;
import org.neo4j.ogm.response.model.RelationshipModel;

public interface ProtegeService {

    String addProtege(Protege protege);

    /**
     * 查询当前节点
     * @param id
     * @return
     */
    Integer selectByIdCount( Integer  id);
    /**
     * 创建关联关系
     * @return
     */
    int  addRelationship(RelationshipParamRequestEntity RelationshipParamRequestEntity);

    /**
     * 先创建 再添加关系
     * @param  entity
     * @return
     */
    Object  addProtegeRelationShip(RelationshipParamRequestEntity entity);

    /**
     * 左侧树形
     * @param entity
     * @return
     */
    Object queryAll(ClassParamRequestEntity  entity);
}
