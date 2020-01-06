
package com.mulama.beer_superior.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mulama.beer_superior.Photo;

public class Item {

    @SerializedName("photo_id")
    @Expose
    private Integer photoId;
    @SerializedName("photo")
    @Expose
    private Photo photo;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("checkin_id")
    @Expose
    private Integer checkinId;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Item() {
    }

    /**
     * 
     * @param createdAt
     * @param checkinId
     * @param photoId
     * @param photo
     */
    public Item(Integer photoId, Photo photo, String createdAt, Integer checkinId) {
        super();
        this.photoId = photoId;
        this.photo = photo;
        this.createdAt = createdAt;
        this.checkinId = checkinId;
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getCheckinId() {
        return checkinId;
    }

    public void setCheckinId(Integer checkinId) {
        this.checkinId = checkinId;
    }

}
