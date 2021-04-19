package com.yuchen.data.enums;

public enum  TypeEnums {
    CLASS("class","Hierarchy"),
    Pro("","");

    private final String  code;
    private final String  type;

    TypeEnums(String code, String type) {
        this.code = code;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    // 普通方法
    public static String getName(String  index) {
        for (TypeEnums c : TypeEnums.values()) {
            if (c.getCode().equals(index)) {
                return c.getType();
            }
        }
        return null;
    }

}
