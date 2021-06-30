package com.example.retrofittest;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReservationList {
    @SerializedName("reservation_list")
    @Expose
    private List<Reservation> reservationList = null;

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public String toString(){
        String result = "";
        for (int i = 0; i < reservationList.size(); i++){
            result += reservationList.get(i).toString();
            result += "\n";
        }
        return result;
    }
}
