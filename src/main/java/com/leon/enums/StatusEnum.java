package com.leon.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * 枚举状态
 */
public enum StatusEnum {

    WORK(1, "上班"),
    REST(0, "休息");


    @EnumValue // 通⽤枚举类注解，将数据库字段映射成实体类的枚举类型成员变量
    private Integer code;
    private String msg;

    StatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
