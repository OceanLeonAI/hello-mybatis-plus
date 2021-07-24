package com.leon.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.leon.enums.AgeEnum;
import com.leon.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User implements Serializable {
    private static final long serialVersionUID = 7182540572637741115L;

    @TableId(type = IdType.NONE)
    private Long id; // 使用雪花算法
//    @TableId(type = IdType.ASSIGN_UUID)
//    private String id; // 使用 UUID

    @TableField(select = true) // select 是否查询该字段
    private String name;

    // 别名
//    @TableField(value = "name") // 数据库字段名
//    private String aka; // 实体 field 属性

    @TableField(select = true)
    private Integer age;
//    private AgeEnum age;

    private String email;

    @TableField(exist = false) // exist 标记该属性是否有数据库对应字段
    private String hobby;

    // 创建时间，需要设置自动填充处理器
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    // 修改时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    // 标记乐观锁，通过 version 字段来保证数据的安全性，
    // 当修改数据的时候，会以 version 作为条件，
    // 当条件成⽴的时候才会修改成功
    /**
     * 线程 1:update ... set version = 2 where version = 1
     * <p>
     * 线程2 ： update ... set version = 2 where version = 1
     * <p>
     * 1、数据库表添加 version 字段，默认值为 1
     * 2、实体类添加 version 成员变量，并且添加 @Version
     * 3、注册配置类
     */
    @Version
    private Integer version;

    private StatusEnum status;

    @TableLogic
    private Integer deleted;
}
