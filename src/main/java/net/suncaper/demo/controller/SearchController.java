package net.suncaper.demo.controller;

import net.suncaper.demo.domain.City;
import net.suncaper.demo.domain.Hotel;
import net.suncaper.demo.domain.MySearch;
import net.suncaper.demo.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

//搜索控制器
@Controller
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private HotelService hotelService;

    //  显示搜索界面
    @GetMapping("/get")
    public String SearchPage(Model model) {
        model.addAttribute("search", new MySearch());
        return "/hotel_search.html";
    }

    //待修改
    //从home接受信息传入此方法 并进行处理 显示在页面上
    @PostMapping("/get")
    public String greetingSubmit(MySearch mySearch, Model model) {
        City temp = hotelService.finCityByString(mySearch.getCity());
        String[] s = mySearch.getName().split("\\s+");
        List<String> keyWord = Arrays.asList(s);
        if (temp == null) {
            model.addAttribute("search", new MySearch());
            return "/hotel_search.html";
        }
        List<Hotel> c = hotelService.findByCityAndName(temp.getCity(), keyWord);
//        List<Hotel> c = hotelService.findHotelByCityId(temp.getCityId());
        model.addAttribute("search", new MySearch());
        model.addAttribute("hotels", c);
        return "/hotel_search.html";
    }
}
