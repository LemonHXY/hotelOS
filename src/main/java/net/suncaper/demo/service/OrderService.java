package net.suncaper.demo.service;

import net.suncaper.demo.domain.OrderOutput;

import java.util.List;


public interface OrderService {
    public List<OrderOutput> GetOrderLists(int uId);
    public OrderOutput GetAOrder(int uId);

}
