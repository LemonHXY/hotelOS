package net.suncaper.demo.service;

import net.suncaper.demo.domain.City;
import net.suncaper.demo.domain.Hotel;
import net.suncaper.demo.domain.OrderOutput;

import java.util.List;


public interface OrderService {
    public OrderOutput GetOrderLists(int oId);
}
