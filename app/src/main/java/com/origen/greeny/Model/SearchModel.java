package com.origen.greeny.Model;

public class SearchModel {

    private String id,plantName,plantDescription,plantPhoto;

    public SearchModel() {
    }

    public SearchModel(String id, String plantName, String plantDescription, String plantPhoto) {
        this.id = id;
        this.plantName = plantName;
        this.plantDescription = plantDescription;
        this.plantPhoto = plantPhoto;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getPlantDescription() {
        return plantDescription;
    }

    public void setPlantDescription(String plantDescription) {
        this.plantDescription = plantDescription;
    }

    public String getPlantPhoto() {
        return plantPhoto;
    }

    public void setPlantPhoto(String plantPhoto) {
        this.plantPhoto = plantPhoto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
