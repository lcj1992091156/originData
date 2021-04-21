package com.yuchen.data.mapper.neo4j;

import com.yuchen.data.model.Protege;
import com.yuchen.data.request.ClassParamRequestEntity;
import com.yuchen.data.request.RelationshipParamRequestEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author admin
 */
public interface ProtegeMapper {
    /**
     * 添加 方法
     * @param protege
     * @return
     */
    int add(@Param("protege") Protege protege);

    /**
     * 查询方法
     * @param id  id
     * @return
     */
    Protege  selectById(@Param("id") String  id);

    /**
     * 创建关联关系
     * @return
     */
    int  addRelationship(@Param("entity") RelationshipParamRequestEntity RelationshipParamRequestEntity);

    /**
     * 查询当前节点
     * @param id
     * @return
     */
    Integer selectByIdCount(@Param("id") Integer  id);

    /**
     * 查询  当前一级节点
     * @param entity
     * @return
     */
    List<Protege> selectAll(@Param("entity")ClassParamRequestEntity entity);
    /**
     * 查询  当前一级节点
     * @param entity
     * @return
     */
    List<Protege> selectAllSon(@Param("entity")ClassParamRequestEntity entity);
}
