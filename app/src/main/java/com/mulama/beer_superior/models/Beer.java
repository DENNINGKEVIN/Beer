
package com.mulama.beer_superior.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel

public class Beer {

    @SerializedName("bid")
    @Expose
     Integer bid;
    @SerializedName("beer_name")
    @Expose
     String beerName;
    @SerializedName("beer_label")
    @Expose
     String beerLabel;
    @SerializedName("beer_label_hd")
    @Expose
     String beerLabelHd;
    @SerializedName("beer_abv")
    @Expose
     Double beerAbv;
    @SerializedName("beer_ibu")
    @Expose
     Integer beerIbu;
    @SerializedName("beer_description")
    @Expose
     String beerDescription;
    @SerializedName("beer_style")
    @Expose
     String beerStyle;
    @SerializedName("is_in_production")
    @Expose
     Integer isInProduction;
    @SerializedName("beer_slug")
    @Expose
     String beerSlug;
    @SerializedName("is_homebrew")
    @Expose
     Integer isHomebrew;
    @SerializedName("created_at")
    @Expose
     String createdAt;
    @SerializedName("rating_count")
    @Expose
     Integer ratingCount;
    @SerializedName("rating_score")
    @Expose
     Double ratingScore;
    @SerializedName("stats")
    @Expose
     Stats stats;
    @SerializedName("brewery")
    @Expose
     Brewery brewery;
    @SerializedName("auth_rating")
    @Expose
     Integer authRating;
    @SerializedName("wish_list")
    @Expose
     Boolean wishList;
    @SerializedName("media")
    @Expose
     Media media;

     String pushId;

     String index;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Beer() {
    }

    /**
     * 
     * @param beerLabelHd
     * @param authRating
     * @param beerAbv
     * @param beerLabel
     * @param beerDescription
     * @param isInProduction
     * @param isHomebrew
     * @param media
     * @param beerIbu
     * @param ratingCount
     * @param beerStyle
     * @param ratingScore
     * @param wishList
     * @param createdAt
     * @param beerSlug
     * @param stats
     * @param beerName
     * @param brewery
     * @param bid
     */
    public Beer(Integer bid, String beerName, String beerLabel, String beerLabelHd, Double beerAbv, Integer beerIbu, String beerDescription, String beerStyle, Integer isInProduction, String beerSlug, Integer isHomebrew, String createdAt, Integer ratingCount, Double ratingScore, Stats stats, Brewery brewery, Integer authRating, Boolean wishList, Media media) {
        super();
        this.bid = bid;
        this.beerName = beerName;
        this.beerLabel = beerLabel;
        this.beerLabelHd = beerLabelHd;
        this.beerAbv = beerAbv;
        this.beerIbu = beerIbu;
        this.beerDescription = beerDescription;
        this.beerStyle = beerStyle;
        this.isInProduction = isInProduction;
        this.beerSlug = beerSlug;
        this.isHomebrew = isHomebrew;
        this.createdAt = createdAt;
        this.ratingCount = ratingCount;
        this.ratingScore = ratingScore;
        this.stats = stats;
        this.brewery = brewery;
        this.authRating = authRating;
        this.wishList = wishList;
        this.media = media;
        this.index = "not_specified";
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
    public String getPushId() {
        return pushId; }

    public void setPushId(String pushId) {
        this.pushId = pushId; }

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

    public String getBeerLabelHd() {
        return beerLabelHd;
    }

    public void setBeerLabelHd(String beerLabelHd) {
        this.beerLabelHd = beerLabelHd;
    }

    public Double getBeerAbv() {
        return beerAbv;
    }

    public void setBeerAbv(Double beerAbv) {
        this.beerAbv = beerAbv;
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

    public String getBeerStyle() {
        return beerStyle;
    }

    public void setBeerStyle(String beerStyle) {
        this.beerStyle = beerStyle;
    }

    public Integer getIsInProduction() {
        return isInProduction;
    }

    public void setIsInProduction(Integer isInProduction) {
        this.isInProduction = isInProduction;
    }

    public String getBeerSlug() {
        return beerSlug;
    }

    public void setBeerSlug(String beerSlug) {
        this.beerSlug = beerSlug;
    }

    public Integer getIsHomebrew() {
        return isHomebrew;
    }

    public void setIsHomebrew(Integer isHomebrew) {
        this.isHomebrew = isHomebrew;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(Integer ratingCount) {
        this.ratingCount = ratingCount;
    }

    public Double getRatingScore() {
        return ratingScore;
    }

    public void setRatingScore(Double ratingScore) {
        this.ratingScore = ratingScore;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public Brewery getBrewery() {
        return brewery;
    }

    public void setBrewery(Brewery brewery) {
        this.brewery = brewery;
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

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

}
