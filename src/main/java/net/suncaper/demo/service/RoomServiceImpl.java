package net.suncaper.demo.service;

import net.suncaper.demo.domain.Room;
import net.suncaper.demo.domain.RoomExample;
import net.suncaper.demo.domain.Room_quantity;
import net.suncaper.demo.domain.Room_quantityExample;
import net.suncaper.demo.mapper.RoomMapper;
import net.suncaper.demo.mapper.Room_quantityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;


@Service
public  class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private Room_quantityMapper Room_quantityMapper;

    @Override
    public List<Room> findRoomByHotelId(int id) {
        RoomExample roomExample=new RoomExample();
        roomExample.createCriteria().andHotelIdEqualTo(id);
        return roomMapper.selectByExample(roomExample);
    }

    @Override
    public boolean saveRoom(Room room) {
        RoomExample example = new RoomExample();
        if(room.getRoomId()<2147483647&&room.getRoomId()>-2147483648&&room.getAmout()>0
                &&room.getHotelId()>0&&room.getBreakfast().length()>0&&room.getRoomType().length()>0&&room.getPrice()>0)
        {
            roomMapper.insert(room);
            return true;
        }
        else
            return false;
    }

    @Override
    public void deleteRoomById(int id) {

    }

    @Override
    public Room findRoomById(int id) {
        return roomMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Room_quantity> getRemain(int id, Date date) {
        Room_quantityExample example = new Room_quantityExample();
        example.createCriteria().andRoomIdEqualTo(id).andRDateEqualTo(date);
        return Room_quantityMapper.selectByExample(example);
    }

    @Override
    public boolean roomPlus(int id, Date date, int num) {
        return false;
    }

    @Override
    public boolean roomMinus(int id, Date date, int num) {
        return false;
    }

}
