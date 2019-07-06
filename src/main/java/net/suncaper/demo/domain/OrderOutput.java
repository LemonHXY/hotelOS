package net.suncaper.demo.domain;

import java.util.Date;

public class OrderOutput {


    private String HotelName;
    private String HotelAddress;
    private String roomType;
    private Date arrDate;
    private Date depDate;
    private int quantity;
    private int totalPrice;
    private String uName;
    private String uPhone;
    private int oId;
    private String oStatus;
    private String arrDateStr;
    private String depDateStr;

    public String getArrDateStr() {
        return arrDateStr;
    }

    public void setArrDateStr(String arrDateStr) {
        this.arrDateStr = arrDateStr;
    }

    public String getDepDateStr() {
        return depDateStr;
    }

    public void setDepDateStr(String depDateStr) {
        this.depDateStr = depDateStr;
    }


    public OrderOutput() {
        this.HotelName = null;
        this.HotelAddress = null;
        this.roomType = null;
        this.arrDate = null;
        this.depDate = null;
        this.quantity = 0;
        this.totalPrice = 0;
        this.uName = null;
        this.uPhone = null;
        this.oId = 0;
        this.oStatus = null;
    }

    public String getHotelAddress() {
        return HotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        HotelAddress = hotelAddress;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public String getHotelName() {
        return HotelName;
    }

    public void setHotelName(String hotelName) {
        HotelName = hotelName;
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

    public void setoId(int oId) {
        this.oId = oId;
    }

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
