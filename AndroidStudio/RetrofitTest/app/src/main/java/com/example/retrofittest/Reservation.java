package com.example.retrofittest;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Reservation {
    @SerializedName("no")
    @Expose
    private String no;
    @SerializedName("reservationDate")
    @Expose
    private String reservationDate;
    @SerializedName("reservationTime")
    @Expose
    private String reservationTime;
    @SerializedName("totalPrice")
    @Expose
    private String totalPrice;
    @SerializedName("cancelDate")
    @Expose
    private String cancelDate;
    @SerializedName("stylingTitle")
    @Expose
    private String stylingTitle;
    @SerializedName("shopName")
    @Expose
    private String shopName;
    @SerializedName("designerName")
    @Expose
    private String designerName;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(String reservationTime) {
        this.reservationTime = reservationTime;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(String cancelDate) {
        this.cancelDate = cancelDate;
    }

    public String getStylingTitle() {
        return stylingTitle;
    }

    public void setStylingTitle(String stylingTitle) {
        this.stylingTitle = stylingTitle;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getDesignerName() {
        return designerName;
    }

    public void setDesignerName(String designerName) {
        this.designerName = designerName;
    }

    public String toString(){
        return "no :" + no + " reservationDate : " + reservationTime + " reservationTime : "
                + reservationTime  + " totalPrice : " + totalPrice  + " stylingTitle : "
                + stylingTitle + " shopName : " + shopName + " designerName : " + designerName;
    }

}

