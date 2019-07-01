package net.suncaper.demo.controller;

import net.suncaper.demo.domain.R_order;
import net.suncaper.demo.domain.R_orderExample;
import net.suncaper.demo.mapper.HotelMapper;
import net.suncaper.demo.mapper.R_orderMapper;
import net.suncaper.demo.mapper.RoomMapper;
import net.suncaper.demo.service.UserService;

import java.util.List;

public class Test {
    private UserService userService;
    private HotelMapper hotelMapper;
    private RoomMapper roomMapper;

    public static void main(String[] args) {
        R_orderMapper r_orderMapper = null;
        R_orderExample r_orderexample = new R_orderExample();
        r_orderexample.createCriteria().andOIdEqualTo(1);
        List<R_order> o = r_orderMapper.selectByExample(r_orderexample);
        System.out.println(1);
    }

}
