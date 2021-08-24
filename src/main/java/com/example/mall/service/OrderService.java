package com.example.mall.service;

import com.example.mall.model.pojo.Order;
import com.example.mall.model.request.CreateOrderReq;
import com.example.mall.model.vo.OrderVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 订单Service
 */
public interface OrderService {
    String create(CreateOrderReq createOrderReq);

    OrderVO detail(String orderNo);

    PageInfo listForCustomer(Integer pageNum, Integer pageSize);

    List<OrderVO> orderListToOrderVOList(List<Order> orderList);

    void cancel(String orderNo);

    String qrcode(String orderNo);

    PageInfo listForAdmin(Integer pageNum, Integer pageSize);

    void pay(String orderNo);

    //发货
    void deliver(String orderNo);

    //完结
    void finish(String orderNo);
}
