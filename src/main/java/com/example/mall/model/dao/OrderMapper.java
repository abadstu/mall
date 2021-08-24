package com.example.mall.model.dao;

import com.example.mall.model.pojo.Order;
import com.example.mall.model.pojo.OrderItem;
import io.swagger.models.auth.In;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.keyvalue.core.event.KeyValueEvent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    Order selectByOrderNo(String orderNo);

    List<Order> selectForCustomer(Integer userId);

    List<Order> selectAllForAdmin();

}