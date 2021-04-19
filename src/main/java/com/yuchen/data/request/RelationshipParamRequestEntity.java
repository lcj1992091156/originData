package com.yuchen.data.request;

import lombok.Data;

/**
 * @author admin
 */
@Data

public class RelationshipParamRequestEntity {
    /**
     * 节点ID
     */
    private String  id;
    /**
     * 目标节点Id
     */
    private String  tagId;
    /**
     * 关系
     */
    private  String relationship;

}
