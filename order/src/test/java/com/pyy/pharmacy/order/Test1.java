package com.pyy.pharmacy.order;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pyy.pharmacy.order.dao.PyyOrderDao;
import com.pyy.pharmacy.order.entity.PyyOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class Test1 {
    @Autowired
    PyyOrderDao pyyOrderDao;
    @Test
    public void test1(){
        QueryWrapper<PyyOrder> queryWrapper=new QueryWrapper();
        queryWrapper.isNotNull("name");
       pyyOrderDao.selectList(null).forEach(System.out::println);


    }
}
