
package com.mulama.beer_superior.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Beer {

    @SerializedName("bid")
    @Expose
    private Integer bid;
    @SerializedName("beer_name")
    @Expose
    private String beerName;
    @SerializedName("beer_label")
    @Expose
    private String beerLabel;
    @SerializedName("beer_abv")
    @Expose
    private double beerAbv;
    @SerializedName("beer_slug")
    @Expose
    private String beerSlug;
    @SerializedName("beer_ibu")
    @Expose
    private Integer beerIbu;
    @SerializedName("beer_description")
    @Expose
    private String beerDescription;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("beer_style")
    @Expose
    private String beerStyle;
    @SerializedName("in_production")
    @Expose
    private Integer inProduction;
    @SerializedName("auth_rating")
    @Expose
    private Integer authRating;
    @SerializedName("wish_list")
    @Expose
    private Boolean wishList;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Beer() {
    }

    /**
     * 
     * @param authRating
     * @param wishList
     * @param createdAt
     * @param beerSlug
     * @param beerAbv
     * @param beerName
     * @param beerLabel
     * @param beerDescription
     * @param bid
     * @param beerIbu
     * @param beerStyle
     * @param inProduction
     */
    public Beer(Integer bid, String beerName, String beerLabel, double beerAbv, String beerSlug, Integer beerIbu, String beerDescription, String createdAt, String beerStyle, Integer inProduction, Integer authRating, Boolean wishList) {
        super();
        this.bid = bid;
        this.beerName = beerName;
        this.beerLabel = beerLabel;
        this.beerAbv = beerAbv;
        this.beerSlug = beerSlug;
        this.beerIbu = beerIbu;
        this.beerDescription = beerDescription;
        this.createdAt = createdAt;
        this.beerStyle = beerStyle;
        this.inProduction = inProduction;
        this.authRating = authRating;
        this.wishList = wishList;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBeerName() {
        return beerName;
    }

    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }

    public String getBeerLabel() {
        return beerLabel;
    }

    public void setBeerLabel(String beerLabel) {
        this.beerLabel = beerLabel;
    }

    public double getBeerAbv() {
        return beerAbv;
    }

    public void setBeerAbv(double beerAbv) {
        this.beerAbv = beerAbv;
    }

    public String getBeerSlug() {
        return beerSlug;
    }

    public void setBeerSlug(String beerSlug) {
        this.beerSlug = beerSlug;
    }

    public Integer getBeerIbu() {
        return beerIbu;
    }

    public void setBeerIbu(Integer beerIbu) {
        this.beerIbu = beerIbu;
    }

    public String getBeerDescription() {
        return beerDescription;
    }

    public void setBeerDescription(String beerDescription) {
        this.beerDescription = beerDescription;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getBeerStyle() {
        return beerStyle;
    }

    public void setBeerStyle(String beerStyle) {
        this.beerStyle = beerStyle;
    }

    public Integer getInProduction() {
        return inProduction;
    }

    public void setInProduction(Integer inProduction) {
        this.inProduction = inProduction;
    }

    public Integer getAuthRating() {
        return authRating;
    }

    public void setAuthRating(Integer authRating) {
        this.authRating = authRating;
    }

    public Boolean getWishList() {
        return wishList;
    }

    public void setWishList(Boolean wishList) {
        this.wishList = wishList;
    }

}
