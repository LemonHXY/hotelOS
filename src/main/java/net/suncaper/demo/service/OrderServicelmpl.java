package net.suncaper.demo.service;

import net.suncaper.demo.domain.Hotel;
import net.suncaper.demo.domain.OrderOutput;
import net.suncaper.demo.domain.R_order;
import net.suncaper.demo.domain.Room;
import net.suncaper.demo.mapper.HotelMapper;
import net.suncaper.demo.mapper.R_orderMapper;
import net.suncaper.demo.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServicelmpl implements OrderService{
    @Autowired
    private R_orderMapper r_orderMapper;
    @Autowired
    private HotelMapper hotelMapper;
    @Autowired
    private RoomMapper roomMapper;

    @Override
    public OrderOutput GetOrderLists(int oId){
        OrderOutput orderOutput = new OrderOutput();

        R_order r_order = r_orderMapper.selectByPrimaryKey(oId);
        int roomId = r_order.getRoomId();
        Room room = roomMapper.selectByPrimaryKey(roomId);
        int hotelId = room.getHotelId();
        Hotel hotel = hotelMapper.selectByPrimaryKey(hotelId);

        orderOutput.setHotelName(hotel.getHotelName());
        orderOutput.setRoomType(room.getRoomType());
        orderOutput.setArrDate(r_order.getArrDate());
        orderOutput.setDepDate(r_order.getDepDate());
        orderOutput.setQuantity(r_order.getQuantity());
        orderOutput.setTotalPrice(r_order.getTotalPrice());
        orderOutput.setoStatus(r_order.getoStatus());

        return orderOutput;
    }

    @Override
    public List<OrderOutput> GetOrderListsAll(int uId) {
        OrderOutput orderOutput = new OrderOutput();
//        R_order r_order = r_orderMapper.

        return null;

    }

}
