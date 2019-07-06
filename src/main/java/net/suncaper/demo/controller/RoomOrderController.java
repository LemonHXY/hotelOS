package net.suncaper.demo.controller;

import net.suncaper.demo.domain.Hotel;
import net.suncaper.demo.domain.R_order;
import net.suncaper.demo.domain.Room;
import net.suncaper.demo.service.HotelService;
import net.suncaper.demo.service.OrderService;
import net.suncaper.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

// 确定订单页面
@Controller
@RequestMapping("/roomorder")
public class RoomOrderController {
    @Autowired
    private HotelService hotelService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private OrderService orderService;

    //
    @GetMapping
    public String getRegister(Model model, HttpServletRequest request) throws ParseException {
        /*首先要查询一下room，hotel
        * 然后传回，本地提取日期信息
        * 填写之后js创表传回
        * 所定日期房间数量-1，若为0则返回失败页面
         * 成功则save订单 转至订单详情页面
         * 完成*/
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        int roomId=Integer.parseInt(request.getQueryString());
        Room room=roomService.findRoomById(roomId);
        Hotel hotel=hotelService.findHotelByKey(room.getHotelId());

        Cookie[]cookies=request.getCookies();
        int b=0;
        Date arr=null;
        Date dep=null;
        for(Cookie cookie:cookies)
        {
            if(cookie.getName().equals("b")){
                if (cookie.getValue()!=null)
                    b=Integer.parseInt(cookie.getValue());
            }
            else if (cookie.getName().equals("arr")) {
                if (cookie.getValue()!=null)
                    arr=formatter.parse(cookie.getValue());
            }
            else if (cookie.getName().equals("dep")){
                if (cookie.getValue()!=null)
                    dep=formatter.parse(cookie.getValue());
            }
        }
        int remain=roomService.getRemainNumBetween(roomId,arr,dep);

        model.addAttribute("remain", remain);
        model.addAttribute("hotelName", hotel.getHotelName());
        model.addAttribute("roomId",room.getRoomId() );
        model.addAttribute("roomId1",room.getRoomId() );
        model.addAttribute("arr",formatter.format(arr));

        model.addAttribute("dep",formatter.format(dep));

        model.addAttribute("nNight",b);
        model.addAttribute("roomType",room.getRoomType());
        model.addAttribute("breakfast",room.getBreakfast());
        model.addAttribute("oneprice",room.getPrice());
        model.addAttribute("result","");



        return "/hotel_room_order.html";
    }

    //待修改
    //从home接受信息传入此方法 并进行处理 显示在页面上
    @PostMapping
    public String saveUser(List<Hotel> d, Model model) {

        return "redirect:roomorder";

    }
    @PostMapping("/sure")
    public String sure(Model model, HttpServletRequest request) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String temp = request.getParameter("roomId");
        int roomId=Integer.parseInt(temp);
        temp= (String) request.getParameter("uId");
        int uId = Integer.parseInt(temp);
        Date oTime=new Date();
        Date arr=formatter.parse((String) request.getParameter("arr"));
        Date dep=formatter.parse((String) request.getParameter("dep"));
        String uPhone = (String) request.getParameter("uPhone");
        String uName = (String) request.getParameter("uName");
        temp=(String) request.getParameter("quantity");
        int quantity =Integer.parseInt(temp);
        temp=(String) request.getParameter("oneprice");
        int oneprice=Integer.parseInt(temp);
        int totalPrice=quantity*oneprice;
        String oStatus="未入住";
        R_order newOrder=new R_order(uId,  roomId,  oTime, arr, dep, quantity, totalPrice, uName, uPhone, oStatus);
        /*存入订单之前需要检查房源数量*/
        int remain=roomService.getRemainNumBetween(roomId,arr,dep);
        if(remain<quantity) {
            model.addAttribute("remain", remain);
            model.addAttribute("result","房源不足");
            return "redirect:/roomorder?"+roomId;
        }
        else
            orderService.saveOne(newOrder);
        return "redirect:/userorder";

    }
}
