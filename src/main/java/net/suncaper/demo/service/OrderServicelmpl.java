package net.suncaper.demo.service;
/*
HEAD<<<<<<< HEAD
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

*//*    @Override
    public boolean creatOneOrder(R_order order) {
        orderMapper.insert(order);
        return false;
    }*//*

    @Override
    public List<R_order> findByUserId(int uId) {
        R_orderExample example=new R_orderExample();
        example.createCriteria().andUIdEqualTo(uId);
        return  orderMapper.selectByExample(example);
    }
}

=======*/
import net.suncaper.demo.domain.*;
import net.suncaper.demo.mapper.HotelMapper;
import net.suncaper.demo.mapper.R_orderMapper;
import net.suncaper.demo.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServicelmpl  implements OrderService{
    @Autowired
    private R_orderMapper r_orderMapper;
    @Autowired
    private HotelMapper hotelMapper;
    @Autowired
    private RoomMapper roomMapper;
    
    public List<OrderOutput> GetOrderLists(int uId){
        R_orderExample example=new R_orderExample();
        example.createCriteria().andUIdEqualTo(uId);
        List<R_order> r_order = r_orderMapper.selectByExample(example);
        List<OrderOutput> orderList=new ArrayList<OrderOutput>();
        for(R_order order:r_order) {
            OrderOutput orderOutput = new OrderOutput();
            int roomId = order.getRoomId();
            Room room = roomMapper.selectByPrimaryKey(roomId);
            int hotelId = room.getHotelId();
            Hotel hotel = hotelMapper.selectByPrimaryKey(hotelId);

            orderOutput.setHotelName(hotel.getHotelName());
            orderOutput.setRoomType(room.getRoomType());
            orderOutput.setoId(order.getoId());
            orderOutput.setArrDate(order.getArrDate());
            orderOutput.setDepDate(order.getDepDate());
            orderOutput.setQuantity(order.getQuantity());
            orderOutput.setTotalPrice(order.getTotalPrice());
            orderOutput.setoStatus(order.getoStatus());
            orderList.add(orderOutput);
        }
        return orderList;
    }
}

