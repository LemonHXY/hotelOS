package net.suncaper.demo.service;
import net.suncaper.demo.domain.*;
import net.suncaper.demo.mapper.HotelMapper;
import net.suncaper.demo.mapper.R_orderMapper;
import net.suncaper.demo.mapper.RoomMapper;
import net.suncaper.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServicelmpl implements OrderService {
    @Autowired
    private R_orderMapper r_orderMapper;
    @Autowired
    private HotelMapper hotelMapper;
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private UserMapper userMapper;

    public List<OrderOutput> GetOrderLists(int uId) {
        R_orderExample example = new R_orderExample();
        example.createCriteria().andUIdEqualTo(uId);
        List<R_order> r_order = r_orderMapper.selectByExample(example);
        List<OrderOutput> orderList = new ArrayList<OrderOutput>();

        for (R_order order : r_order) {
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

    public OrderOutput GetOrderLists2(int oId) {
        OrderOutput orderOutput = new OrderOutput();

        R_order r_order = r_orderMapper.selectByPrimaryKey(oId);
        int roomId = r_order.getRoomId();

        Room room = roomMapper.selectByPrimaryKey(roomId);
        int hotelId = room.getHotelId();

        User user = userMapper.selectByPrimaryKey(r_order.getuId());

        Hotel hotel = hotelMapper.selectByPrimaryKey(hotelId);
        orderOutput.setHotelName(hotel.getHotelName());
        orderOutput.setHotelAddress(hotel.getAddressline());
        orderOutput.setRoomType(room.getRoomType());
        orderOutput.setArrDate(r_order.getArrDate());
        orderOutput.setDepDate(r_order.getDepDate());
        orderOutput.setTotalPrice(r_order.getTotalPrice());
        orderOutput.setuName(user.getuName());
        orderOutput.setuPhone("13208199005");
        orderOutput.setoId(r_order.getoId());
        orderOutput.setoStatus(r_order.getoStatus());

        return orderOutput;
    }

    public List<OrderOutput> GetAllOrderOutput(){
        R_orderExample example = new R_orderExample();
        example.createCriteria().andOIdIsNotNull();
        List<R_order> r_order = r_orderMapper.selectByExample(example);
        List<OrderOutput> orderList = new ArrayList<OrderOutput>();

        for (R_order order : r_order) {
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

