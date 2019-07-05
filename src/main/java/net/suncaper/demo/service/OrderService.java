package net.suncaper.demo.service;

import net.suncaper.demo.domain.OrderOutput;
import net.suncaper.demo.domain.R_order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    public List<OrderOutput> GetOrderLists(int uId);
    public OrderOutput GetOrderLists2(int oId) ;
    public void saveOne(R_order order);
    public List<OrderOutput> GetAllOrderOutput();
    public List<OrderOutput> GetAllByCheckOut();
}
