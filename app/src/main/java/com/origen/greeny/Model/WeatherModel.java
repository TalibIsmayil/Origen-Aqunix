package com.origen.greeny.Model;

public class WeatherModel {
    private String name;
    private String imagelink;
    private String humidity;
    private String temp;

    public WeatherModel() {
    }

    public WeatherModel(String name, String imagelink, String humidity, String temp) {
        this.name = name;
        this.imagelink = imagelink;
        this.humidity = humidity;
        this.temp = temp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagelink() {
        return imagelink;
    }

    public void setImagelink(String imagelink) {
        this.imagelink = imagelink;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}
