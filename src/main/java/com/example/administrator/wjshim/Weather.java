package com.example.administrator.wjshim;

/**
 * Created by Administrator on 2016-08-13.
 */
public class Weather {

    int lat;
    int ion;
    int temprature;
    int cloudy;
    String city;
    String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getIon() {
        return ion;
    }

    public void setIon(int ion) {
        this.ion = ion;
    }

    public int getTemprature() {
        return temprature;
    }

    public void setTemprature(int temprature) {
        this.temprature = temprature;
    }

    public int getCloudy() {
        return cloudy;
    }

    public void setCloudy(int cloudy) {
        this.cloudy = cloudy;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
