package com.yuchen.data.request;

import com.yuchen.data.model.Protege;
import lombok.Data;

/**
 * @author admin
 */
@Data
public class RelationshipParamRequestEntity {
    /**
     * 节点ID
     */
    private Integer  id;
    /**
     * 目标节点Id
     */
    private String  tagId;
    /**
     * 关系
     */
    private  String relationship;
    /**
     * 创建
     */
    private Protege  protege;

}
