package com.ronwu.springbootdemo.dto;

import jakarta.validation.constraints.NotNull;

public class DataRequest {
    @NotNull
    private String farmnm_ch;
    @NotNull
    private String tel;

    private String fax;
    @NotNull
    private String pcode;
    @NotNull
    private String county;
    @NotNull
    private String township;
    @NotNull
    private String address_ch;
    @NotNull
    private String address_en;

    private String weburl;
    @NotNull
    private Float longitude;
    @NotNull
    private Float latitude;
    @NotNull
    private String serveitem;

    private String facebook;

    public String getFarmnm_ch() {
        return farmnm_ch;
    }

    public void setFarmnm_ch(String farmnm_ch) {
        this.farmnm_ch = farmnm_ch;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getTownship() {
        return township;
    }

    public void setTownship(String township) {
        this.township = township;
    }

    public String getAddress_ch() {
        return address_ch;
    }

    public void setAddress_ch(String address_ch) {
        this.address_ch = address_ch;
    }

    public String getAddress_en() {
        return address_en;
    }

    public void setAddress_en(String address_en) {
        this.address_en = address_en;
    }

    public String getWeburl() {
        return weburl;
    }

    public void setWeburl(String weburl) {
        this.weburl = weburl;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public String getServeitem() {
        return serveitem;
    }

    public void setServeitem(String serveitem) {
        this.serveitem = serveitem;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }
}
