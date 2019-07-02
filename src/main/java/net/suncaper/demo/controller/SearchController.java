package net.suncaper.demo.controller;

import net.suncaper.demo.domain.City;
import net.suncaper.demo.domain.Hotel;
import net.suncaper.demo.domain.MySearch;
import net.suncaper.demo.domain.Room;
import net.suncaper.demo.service.HotelService;
import net.suncaper.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
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
    public String greetingSubmit(MySearch mySearch, Model model , HttpServletRequest request) {
        City temp=hotelService.finCityByString(mySearch.getCity());
        String []s=mySearch.getName().split("\\s+");
        List<String>  keyWord= Arrays.asList(s);
        if(temp==null)
        {
            model.addAttribute("search",new MySearch());
            return "/hotel_search.html";
        }
        List<Hotel>  c=hotelService.findByCityAndName(temp.getCity(),keyWord);
        //List<Hotel>  c=hotelService.findHotelByCityId(temp.getCityId());
        model.addAttribute("search",new MySearch());
        model.addAttribute("hotels",c);
        return "/hotel_search.html";
    }
    @GetMapping("/room")
    public String SearchPage(Model model,HttpServletRequest request) {
        int hotelId=Integer.parseInt(request.getQueryString());
        Hotel hotel=hotelService.findHotelByKey(hotelId);
        List<Room> rooms=roomservice.findRoomByHotelId(hotelId);
        model.addAttribute("hotel",hotel);
        model.addAttribute("rooms",rooms);
        return "/hotel_room.html";
    }
}
