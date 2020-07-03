package com.origen.greeny.Model;

public class NotifModel {
    private String name,desc;
    private boolean isAlarmed;

    public NotifModel() {
    }

    public NotifModel(String name, String desc, boolean isAlarmed) {
        this.name = name;
        this.desc = desc;
        this.isAlarmed = isAlarmed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isAlarmed() {
        return isAlarmed;
    }

    public void setAlarmed(boolean alarmed) {
        isAlarmed = alarmed;
    }
}
