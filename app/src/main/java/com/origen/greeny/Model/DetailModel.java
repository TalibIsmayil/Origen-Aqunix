package com.origen.greeny.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailModel {
    @SerializedName("plantPhoto")
    @Expose
    private String plantPhoto;
    @SerializedName("plantTitle")
    @Expose
    private String plantTitle;
    @SerializedName("plantDescription")
    @Expose
    private String plantDescription;
    @SerializedName("weather")
    @Expose
    private String weather;
    @SerializedName("gubreleme")
    @Expose
    private String gubreleme;
    @SerializedName("sun")
    @Expose
    private String sun;
    @SerializedName("soil")
    @Expose
    private String soil;
    @SerializedName("min")
    @Expose
    private String min;
    @SerializedName("florish")
    @Expose
    private String florish;

    public DetailModel() {
    }

    public DetailModel(String plantPhoto, String plantTitle, String plantDescription, String weather, String gubreleme, String sun, String soil, String min, String florish) {
        this.plantPhoto = plantPhoto;
        this.plantTitle = plantTitle;
        this.plantDescription = plantDescription;
        this.weather = weather;
        this.gubreleme = gubreleme;
        this.sun = sun;
        this.soil = soil;
        this.min = min;
        this.florish = florish;
    }

    public String getPlantPhoto() {
        return plantPhoto;
    }

    public void setPlantPhoto(String plantPhoto) {
        this.plantPhoto = plantPhoto;
    }

    public String getPlantTitle() {
        return plantTitle;
    }

    public void setPlantTitle(String plantTitle) {
        this.plantTitle = plantTitle;
    }

    public String getPlantDescription() {
        return plantDescription;
    }

    public void setPlantDescription(String plantDescription) {
        this.plantDescription = plantDescription;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getGubreleme() {
        return gubreleme;
    }

    public void setGubreleme(String gubreleme) {
        this.gubreleme = gubreleme;
    }

    public String getSun() {
        return sun;
    }

    public void setSun(String sun) {
        this.sun = sun;
    }

    public String getSoil() {
        return soil;
    }

    public void setSoil(String soil) {
        this.soil = soil;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getFlorish() {
        return florish;
    }

    public void setFlorish(String florish) {
        this.florish = florish;
    }

    @Override
    public String toString() {
        return "DetailModel{" +
                "plantPhoto='" + plantPhoto + '\'' +
                ", plantTitle='" + plantTitle + '\'' +
                ", plantDescription='" + plantDescription + '\'' +
                ", weather='" + weather + '\'' +
                ", gubreleme='" + gubreleme + '\'' +
                ", sun='" + sun + '\'' +
                ", soil='" + soil + '\'' +
                ", min='" + min + '\'' +
                ", florish='" + florish + '\'' +
                '}';
    }
}
