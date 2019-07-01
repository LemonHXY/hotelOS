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
import net.suncaper.demo.domain.Hotel;
import net.suncaper.demo.domain.OrderOutput;
import net.suncaper.demo.domain.R_order;
import net.suncaper.demo.domain.Room;
import net.suncaper.demo.mapper.HotelMapper;
import net.suncaper.demo.mapper.R_orderMapper;
import net.suncaper.demo.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServicelmpl  implements OrderService{
    @Autowired
    private R_orderMapper r_orderMapper;
    @Autowired
    private HotelMapper hotelMapper;
    @Autowired
    private RoomMapper roomMapper;
    
    public OrderOutput GetOrderLists(int oId){
        OrderOutput orderOutput = new OrderOutput();

        R_order r_order = r_orderMapper.selectByPrimaryKey(oId);
        int roomId = r_order.getRoomId();
        Room room = roomMapper.selectByPrimaryKey(roomId);
        int hotelId = room.getHotelId();
        Hotel hotel = hotelMapper.selectByPrimaryKey(hotelId);

        orderOutput.setHotelName(hotel.getHotelName());
        orderOutput.setRoomType(room.getRoomType());
        orderOutput.setoId(r_order.getoId());
        orderOutput.setArrDate(r_order.getArrDate());
        orderOutput.setDepDate(r_order.getDepDate());
        orderOutput.setQuantity(r_order.getQuantity());
        orderOutput.setTotalPrice(r_order.getTotalPrice());
        orderOutput.setoStatus(r_order.getoStatus());

        return orderOutput;
    }
}

