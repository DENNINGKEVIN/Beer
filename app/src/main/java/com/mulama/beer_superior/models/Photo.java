
package com.mulama.beer_superior.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photo {

    @SerializedName("photo_img_sm")
    @Expose
    private String photoImgSm;
    @SerializedName("photo_img_md")
    @Expose
    private String photoImgMd;
    @SerializedName("photo_img_lg")
    @Expose
    private String photoImgLg;
    @SerializedName("photo_img_og")
    @Expose
    private String photoImgOg;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Photo() {
    }

    /**
     * 
     * @param photoImgLg
     * @param photoImgOg
     * @param photoImgMd
     * @param photoImgSm
     */
    public Photo(String photoImgSm, String photoImgMd, String photoImgLg, String photoImgOg) {
        super();
        this.photoImgSm = photoImgSm;
        this.photoImgMd = photoImgMd;
        this.photoImgLg = photoImgLg;
        this.photoImgOg = photoImgOg;
    }

    public String getPhotoImgSm() {
        return photoImgSm;
    }

    public void setPhotoImgSm(String photoImgSm) {
        this.photoImgSm = photoImgSm;
    }

    public String getPhotoImgMd() {
        return photoImgMd;
    }

    public void setPhotoImgMd(String photoImgMd) {
        this.photoImgMd = photoImgMd;
    }

    public String getPhotoImgLg() {
        return photoImgLg;
    }

    public void setPhotoImgLg(String photoImgLg) {
        this.photoImgLg = photoImgLg;
    }

    public String getPhotoImgOg() {
        return photoImgOg;
    }

    public void setPhotoImgOg(String photoImgOg) {
        this.photoImgOg = photoImgOg;
    }

}
