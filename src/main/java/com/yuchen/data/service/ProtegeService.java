package com.yuchen.data.service;

import com.yuchen.data.mapper.neo4j.ProtegeMapper;
import com.yuchen.data.model.Protege;
import com.yuchen.data.request.RelationshipParamRequestEntity;
import org.apache.ibatis.annotations.Param;

public interface ProtegeService {

    Object addProtege(Protege protege);

    /**
     * 查询当前节点
     * @param id
     * @return
     */
    Integer selectByIdCount( String  id);
    /**
     * 创建关联关系
     * @return
     */
    int  addRelationship(RelationshipParamRequestEntity RelationshipParamRequestEntity);

}
