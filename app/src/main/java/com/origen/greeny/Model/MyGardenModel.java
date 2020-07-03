package com.origen.greeny.Model;

public class MyGardenModel {
    private String plantPhoto,plantName,plantDescription;
    private int image1,image2,image3,image4;

    public MyGardenModel() {
    }

    public MyGardenModel(String image, String name, String desc, int image1, int image2, int image3, int image4) {
        this.plantPhoto = image;
        this.plantName = name;
        this.plantDescription = desc;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
    }

    public String getImage() {
        return plantPhoto;
    }

    public void setImage(String image) {
        this.plantPhoto = image;
    }

    public String getName() {
        return plantName;
    }

    public void setName(String name) {
        this.plantName = name;
    }

    public String getDesc() {
        return plantDescription;
    }

    public void setDesc(String desc) {
        this.plantDescription = desc;
    }

    public int getImage1() {
        return image1;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }

    public int getImage2() {
        return image2;
    }

    public void setImage2(int image2) {
        this.image2 = image2;
    }

    public int getImage3() {
        return image3;
    }

    public void setImage3(int image3) {
        this.image3 = image3;
    }

    public int getImage4() {
        return image4;
    }

    public void setImage4(int image4) {
        this.image4 = image4;
    }
}
