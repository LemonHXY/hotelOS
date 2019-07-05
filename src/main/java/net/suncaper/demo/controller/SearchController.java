package net.suncaper.demo.controller;

import net.suncaper.demo.domain.*;
import net.suncaper.demo.service.HotelService;
import net.suncaper.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//搜索控制器
@Controller
@RequestMapping("/search")
public class SearchController {
    private static final double EARTH_RADIUS = 6378.137;

    @Autowired
    private HotelService hotelService;
    @Autowired
    private RoomService roomservice;

    //  显示搜索界面
    @GetMapping
    public String SearchPage(Model model) {
        model.addAttribute("search", new MySearch());
        return "/hotel_search.html";
    }

    //从home接受信息传入此方法 并进行处理 显示在页面上
    @PostMapping
    public String greetingSubmit(MySearch mySearch, Model model, HttpServletRequest request) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        City temp = hotelService.finCityByString(mySearch.getCity());
        Date arr = formatter.parse(mySearch.getStart());
        Date dep = formatter.parse(mySearch.getEnd());

        // 判断登陆状态
        Cookie[] cookies = request.getCookies();
        int b = 0;
        if(cookies!=null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("b"))
                    if (cookie.getValue() != null)
                        b = Integer.parseInt(cookie.getValue());
            }
        }
        // 分割字符 以备关键字搜索
        String[] s = mySearch.getName().split("\\s+");
        List<String> keyWord = Arrays.asList(s);

        // 城市为空则重新搜索
        if (temp == null) {
            model.addAttribute("search", new MySearch());
            return "/hotel_search.html";
        }

        List<Hotel> c = hotelService.findByCityAndName(temp.getCity(), keyWord);
//        Iterator<Hotel> it = c.iterator();
//        while (it.hasNext()) {
//            Hotel h = it.next();
//            List<Room> rooms = roomservice.findRoomByHotelId(h.getHotelId());
//            List<Room> r = roomservice.getRemainBetween(rooms, arr, dep, b);
//            if (r.size() == 0)
//                it.remove();
//        }

        for (int i = 0; i < c.size(); i++) {
            double distance = getDistance(mySearch.getLongitude(), mySearch.getLatitude(), c.get(i).getLongitude(), c.get(i).getLatitude());
            c.get(i).setDistance((double) Math.round(distance * 100) / 100);
        }



        //List<Hotel>  c=hotelService.findHotelByCityId(temp.getCityId());
        model.addAttribute("search", new MySearch());
        model.addAttribute("hotels", c);
        return "/hotel_search.html";
    }

    @GetMapping("/room")
    public String SearchPage(Model model, HttpServletRequest request, HttpServletResponse response) throws ParseException {
        int hotelId = Integer.parseInt(request.getQueryString());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Cookie[] cookies = request.getCookies();
        int b = 0;
        Date arr = null;
        Date dep = null;
        if(cookies!=null){
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("b")) {
                if (cookie.getValue() != null)
                    b = Integer.parseInt(cookie.getValue());
            } else if (cookie.getName().equals("arr")) {
                if (cookie.getValue() != null)
                    arr = formatter.parse(cookie.getValue());
            } else if (cookie.getName().equals("dep")) {
                if (cookie.getValue() != null)
                    dep = formatter.parse(cookie.getValue());
            }
        }
        }
        Hotel hotel = hotelService.findHotelByKey(hotelId);
        List<Room> rooms = roomservice.findRoomByHotelId(hotelId);
        List<Room> result = new ArrayList<>();
        // List<Room> r= roomservice.getRemainBetween(rooms,arr,dep,b);
        for (Room room : rooms) {
            int num = roomservice.getRemainNumBetween(room.getRoomId(), arr, dep);
            Cookie cookie = new Cookie(String.valueOf(room.getRoomId()), String.valueOf(num));
            cookie.setPath("/");
            response.addCookie(cookie);
           // if (num > 0)
                result.add(room);
        }
        model.addAttribute("search", new MySearch());
        model.addAttribute("hotel", hotel);
        model.addAttribute("rooms", result);
        return "/hotel_room.html";
    }

    @PostMapping("/room")
    public String SearchPageByPost(MySearch search, Model model, HttpServletRequest request, HttpServletResponse response) throws ParseException {
        int hotelId = Integer.parseInt(request.getQueryString());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Cookie[] cookies = request.getCookies();
        int b = 0;
        String a1 = search.getStart();
        String d1 = search.getEnd();
        Date arr = formatter.parse(a1);
        Date dep = formatter.parse(d1);

        Hotel hotel = hotelService.findHotelByKey(hotelId);
        List<Room> rooms = roomservice.findRoomByHotelId(hotelId);
        List<Room> result = new ArrayList<>();
        // List<Room> r= roomservice.getRemainBetween(rooms,arr,dep,b);
        for (Room room : rooms) {
            int num = roomservice.getRemainNumBetween(room.getRoomId(), arr, dep);
            Cookie cookie = new Cookie(String.valueOf(room.getRoomId()), String.valueOf(num));
            cookie.setPath("/");
            response.addCookie(cookie);
            if (num > 0)
                result.add(room);
        }
        model.addAttribute("search", new MySearch());
        model.addAttribute("hotel", hotel);
        model.addAttribute("rooms", result);
        return "/hotel_room.html";
    }

    // 计算距离
    public static double getDistance(double longitude1, double latitude1, double longitude2, double latitude2) {
        // 纬度
        double lat1 = Math.toRadians(latitude1);
        double lat2 = Math.toRadians(latitude2);
        // 经度
        double lng1 = Math.toRadians(longitude1);
        double lng2 = Math.toRadians(longitude2);
        // 纬度之差
        double a = lat1 - lat2;
        // 经度之差
        double b = lng1 - lng2;
        // 计算两点距离的公式
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) +
                Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(b / 2), 2)));
        // 弧长乘地球半径, 返回单位: 千米
        s = s * EARTH_RADIUS;
        return s;
    }
}









