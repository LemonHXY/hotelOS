package net.suncaper.demo.controller;

import net.suncaper.demo.domain.*;
import net.suncaper.demo.service.HotelService;
import net.suncaper.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
//搜索控制器
@Controller
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private HotelService hotelService;
    @Autowired
    private RoomService roomservice;
//  显示搜索界面
    @GetMapping
    public String SearchPage(Model model) {
        model.addAttribute("search",new MySearch());
        return "/hotel_search.html";
    }

    //从home接受信息传入此方法 并进行处理 显示在页面上
    @PostMapping
    public String greetingSubmit(MySearch mySearch, Model model , HttpServletRequest request) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        City temp=hotelService.finCityByString(mySearch.getCity());
        Date arr=formatter.parse(mySearch.getStart());
        Date dep=formatter.parse(mySearch.getEnd());
        Cookie []cookies=request.getCookies();
        int b=0;
        for(Cookie cookie:cookies)
        {
            if(cookie.getName().equals("b"))
                if (cookie.getValue()!=null)
                    b=Integer.parseInt(cookie.getValue());
        }
        String []s=mySearch.getName().split("\\s+");
        List<String>  keyWord= Arrays.asList(s);
        if(temp==null)
        {
            model.addAttribute("search",new MySearch());
            return "/hotel_search.html";
        }
        List<Hotel>  c;
        c = hotelService.findByCityAndName(temp.getCity(),keyWord);
        Iterator<Hotel> it = c.iterator();
        while(it.hasNext())
        {
            Hotel h=it.next();
            List<Room> rooms=roomservice.findRoomByHotelId(h.getHotelId());
           List<Room> r= roomservice.getRemainBetween(rooms,arr,dep,b);
           if(r.size()==0)
               it.remove();
        }
        //List<Hotel>  c=hotelService.findHotelByCityId(temp.getCityId());
        model.addAttribute("search",new MySearch());
        model.addAttribute("hotels",c);
        return "/hotel_search.html";
    }

    @GetMapping("/room")
    public String SearchPage(Model model, HttpServletRequest request, HttpServletResponse response) throws ParseException {
        int hotelId=Integer.parseInt(request.getQueryString());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Cookie []cookies=request.getCookies();
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
        Hotel hotel=hotelService.findHotelByKey(hotelId);
        List<Room> rooms=roomservice.findRoomByHotelId(hotelId);
       // List<Room> r= roomservice.getRemainBetween(rooms,arr,dep,b);
        for (Room room:rooms)
        {
            int num=roomservice.getRemainNumBetween(room.getRoomId(),arr,dep);
            Cookie cookie=new Cookie(String.valueOf(room.getRoomId()),String.valueOf(num));
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        model.addAttribute("hotel",hotel);
        model.addAttribute("rooms",rooms);
        return "/hotel_room.html";
    }
}









