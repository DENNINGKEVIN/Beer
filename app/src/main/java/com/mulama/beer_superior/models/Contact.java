
package com.mulama.beer_superior.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel

public class Contact {

    @SerializedName("twitter")
    @Expose
     String twitter;
    @SerializedName("facebook")
    @Expose
     String facebook;
    @SerializedName("instagram")
    @Expose
     String instagram;
    @SerializedName("url")
    @Expose
     String url;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Contact() {
    }

    /**
     * 
     * @param twitter
     * @param facebook
     * @param instagram
     * @param url
     */
    public Contact(String twitter, String facebook, String instagram, String url) {
        super();
        this.twitter = twitter;
        this.facebook = facebook;
        this.instagram = instagram;
        this.url = url;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
