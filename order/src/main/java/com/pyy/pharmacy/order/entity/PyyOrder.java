package com.pyy.pharmacy.order.entity;


import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@TableName("pyy_order")//标识对象与表的映射关系，如果表名与对象名称一致，user参数可不写
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PyyOrder implements Serializable  {
/*    @Id
    @Column(name = "ID")*/
//1. 雪花算法
/*@TableId(type = IdType.ID_WORKER)*/

//2. 主键自增(主键生成策略)
@TableId(type = IdType.AUTO)
    private Long id;
/*    @Column(name = "NAME")*/
    private String name;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @Version
    private int version;
    @TableLogic
    private int deleted;


}
