package net.suncaper.demo.service;

import net.suncaper.demo.domain.OrderOutput;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    public List<OrderOutput> GetOrderLists(int uId);
    public OrderOutput GetOrderLists2(int oId) ;
}
