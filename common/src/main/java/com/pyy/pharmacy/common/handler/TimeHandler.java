package com.pyy.pharmacy.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class TimeHandler implements MetaObjectHandler {
    private final static Date DATE_TIME=new Date();
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime",DATE_TIME,metaObject);
        this.setFieldValByName("updateTime",DATE_TIME,metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime",DATE_TIME,metaObject);


    }
}
