package net.suncaper.demo.service;


import net.suncaper.demo.domain.R_order;

import java.util.List;

public interface OrderService{

    //public boolean creatOneOrder(R_order order);
    public List<R_order> findByUserId(int uId);
}