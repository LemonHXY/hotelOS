package net.suncaper.demo.domain;

import java.util.Date;

public class OrderOutput {


    private String hotelName;
    private int oId;
    private String roomType;
    private Date arrDate;
    private Date depDate;
    private int quantity;
    private int totalPrice;
    private String oStatus;

    public OrderOutput(String hotelName,int oId,String roomType,Date arrDate,Date depDate,int quantity,int totalPrice,String oStatus)
    {
        this .hotelName = hotelName;
        this.roomType = roomType;
        this.arrDate = arrDate;
        this.depDate = depDate;
        this.quantity = quantity;
        this.oId =oId;
        this.totalPrice = totalPrice;
        this.oStatus = oStatus;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
       this .hotelName = hotelName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Date getArrDate() {
        return arrDate;
    }

    public void setArrDate(Date arrDate) {
        this.arrDate = arrDate;
    }

    public Date getDepDate() {
        return depDate;
    }

    public void setDepDate(Date depDate) {
        this.depDate = depDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getoId() {
        return oId;
    }

    public void setoId(int oId) { this.oId =oId; }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getoStatus() {
        return oStatus;
    }

    public void setoStatus(String oStatus) {
        this.oStatus = oStatus;
    }
}
