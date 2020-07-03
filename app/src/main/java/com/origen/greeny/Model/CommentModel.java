package com.origen.greeny.Model;

import android.media.Image;
import android.widget.ImageView;

public class CommentModel {
    private String name,comment,daysAgo;
    private String  image;

    public CommentModel() {
    }

    public CommentModel(String name, String comment, String daysAgo, String image) {
        this.name = name;
        this.comment = comment;
        this.daysAgo = daysAgo;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDaysAgo() {
        return daysAgo;
    }

    public void setDaysAgo(String daysAgo) {
        this.daysAgo = daysAgo;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
