package com.yuchen.data.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author admin
 */
@Data
public class Protege   implements Serializable {

    private String  id;
    private String name;
    private String dataType;
    private String strId;

}
