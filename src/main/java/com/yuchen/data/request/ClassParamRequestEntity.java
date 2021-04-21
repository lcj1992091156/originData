package com.yuchen.data.request;

import lombok.Data;

/**
 * 查询参数
 * @author admin
 */
@Data
public class ClassParamRequestEntity {
    /**
     * 父节点uuid
     */
    private String  uuid;
    /**
     * 是否是父节点 第一次传参
     */
    private Boolean  parentNode;
    /**
     *  name
     */
    private String name;
}
