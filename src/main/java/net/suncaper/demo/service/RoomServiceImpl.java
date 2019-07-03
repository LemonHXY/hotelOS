package net.suncaper.demo.service;

import net.suncaper.demo.domain.*;
import net.suncaper.demo.mapper.RoomMapper;
import net.suncaper.demo.mapper.Room_quantityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Service
public  class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private Room_quantityMapper room_quantityMapper;

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
    public Room_quantity getRemain(int id, Date date) {
        Room_quantityKey key = new Room_quantityKey(id,date);
        return room_quantityMapper.selectByPrimaryKey(key);
    }

    @Override
    public int getRemainNumBetween(int id, Date date1, Date date2) {
        int min=Integer.MAX_VALUE;
        Room_quantityKey key=new Room_quantityKey();
        key.setRoomId(id);
        Calendar ca = Calendar.getInstance();
        Date curDate = date1;
        while(curDate.compareTo(date2)<=0){
            ca.setTime(curDate);
            key.setrDate(curDate);
            Room_quantity q=room_quantityMapper.selectByPrimaryKey(key);
            min=min<q.getRemain()?min:q.getRemain();
            ca.add(ca.DATE, 1);
            curDate = ca.getTime();
        }
        return min;
    }

    @Override
    public List<Room> getRemainBetween(List<Room> list, Date date1, Date date2 ,int b) {
        Room_quantityExample example=new Room_quantityExample();
        List<Room> roomList = list;
        for(Room room:list)
        {
            example.clear();
            example.createCriteria().andRoomIdEqualTo(room.getRoomId()).andRDateBetween(date1,date2);
            if(room_quantityMapper.countByExample(example)<=b)
            {
                roomList.remove(room);
            }
        }

        return roomList;
    }

    @Override
    public boolean roomPlus(int id, Date date, int num) {
        return false;
    }

    @Override
    public boolean roomMinus(int id, Date date, int num) {
        return false;
    }

    @Override
    public List<Room> findRoomByDate(int hotelId, Date start, Date end) {
        List<Room> roomList=findRoomByHotelId(hotelId);
        List<Room> result=new ArrayList<Room>();
        for(Room room:roomList )
        {

        }
        return null;
    }

}
