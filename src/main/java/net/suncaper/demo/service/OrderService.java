package net.suncaper.demo.service;

import net.suncaper.demo.domain.*;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface OrderService {
    public List<OrderOutput> GetOrderLists(int uId);
    public OrderOutput GetOrderLists2(int oId);
    public List<OrderOutput> GetAllOrderOutput();
    public List<OrderOutput> GetAllByCheckOut();
}
