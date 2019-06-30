package net.suncaper.demo.service;

import net.suncaper.demo.domain.R_order;
import net.suncaper.demo.domain.R_orderExample;
import net.suncaper.demo.mapper.R_orderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServicelmpl implements OrderService{
    @Autowired
    R_orderMapper orderMapper;

/*    @Override
    public boolean creatOneOrder(R_order order) {
        orderMapper.insert(order);
        return false;
    }*/

    @Override
    public List<R_order> findByUserId(int uId) {
        R_orderExample example=new R_orderExample();
        example.createCriteria().andUIdEqualTo(uId);
        return  orderMapper.selectByExample(example);
    }
}

