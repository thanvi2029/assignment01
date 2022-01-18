package com.assignment.assignment;

import java.util.Date;

public class Pojo {

    String storeId;
    String postCode;
    String city;
    String address;
    Date openedDate;


    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public void setPostCode(String postCode) {
        postCode = postCode;
    }

    public void setCity(String city) {
        city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOpenedDate(Date openedDate) {
        openedDate = openedDate;
    }

    public String getStoreId() {
        return storeId;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public Date getOpenedDate() {
        return openedDate;
    }

}
