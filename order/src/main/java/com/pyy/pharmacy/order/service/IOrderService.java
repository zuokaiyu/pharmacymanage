package com.pyy.pharmacy.order.service;

import com.pyy.pharmacy.order.entity.PyyOrder;
import com.pyy.pharmacy.order.service.impl.OrderServiceImpl;

import java.util.List;

public interface IOrderService {

    void add(PyyOrder pyyOrder);

    List<PyyOrder> selectAll();
}
