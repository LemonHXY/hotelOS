package net.suncaper.demo.service;

import net.suncaper.demo.domain.City;
import net.suncaper.demo.domain.Hotel;
import net.suncaper.demo.domain.OrderOutput;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    public OrderOutput GetOrderLists(int oId);
    public List<OrderOutput>  GetOrderListsAll (int uId);
}
