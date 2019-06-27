package net.suncaper.demo.service;

import net.suncaper.demo.domain.Room;
import net.suncaper.demo.domain.Room_quantity;

import java.sql.Date;
import java.util.List;


public interface RoomService {
    public List<Room> findRoomByHotelId(int id);//仅仅提供通过酒店id寻找room

    boolean saveRoom(Room room);//保存一个房间              后台

    void deleteRoomById(int id);//通过id删除一个房间         后台

    public Room findRoomById(int id); //通过房间id寻找一个房间

    public List<Room_quantity> getRemain(int id, Date date);//查询某天某id房间的剩余数量

    public boolean roomPlus(int id, Date date, int num);//某日date房间id增加num个

    public boolean roomMinus(int id, Date date, int num);//某日date房间id减少num个

}
