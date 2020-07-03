package com.origen.greeny.Model;

public class HomeModel {

    private String username;
    private String photo;
    private String postPhoto;
    private String postTime;
    private boolean isLiked,isSaved;
    private String postComment;

    public HomeModel() {
    }

    public HomeModel(String username, String photo, String postPhoto, String postTime, boolean isLiked, boolean isSaved, String postComment) {
        this.username = username;
        this.photo = photo;
        this.postPhoto = postPhoto;
        this.postTime = postTime;
        this.isLiked = isLiked;
        this.isSaved = isSaved;
        this.postComment = postComment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPostPhoto() {
        return postPhoto;
    }

    public void setPostPhoto(String postPhoto) {
        this.postPhoto = postPhoto;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public boolean isSaved() {
        return isSaved;
    }

    public void setSaved(boolean saved) {
        isSaved = saved;
    }

    public String getPostComment() {
        return postComment;
    }

    public void setPostComment(String postComment) {
        this.postComment = postComment;
    }
}
