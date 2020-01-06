
package com.mulama.beer_superior.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Brewery {

    @SerializedName("brewery_id")
    @Expose
    private Integer breweryId;
    @SerializedName("brewery_name")
    @Expose
    private String breweryName;
    @SerializedName("brewery_slug")
    @Expose
    private String brewerySlug;
    @SerializedName("brewery_type")
    @Expose
    private String breweryType;
    @SerializedName("brewery_page_url")
    @Expose
    private String breweryPageUrl;
    @SerializedName("brewery_label")
    @Expose
    private String breweryLabel;
    @SerializedName("country_name")
    @Expose
    private String countryName;
    @SerializedName("contact")
    @Expose
    private Contact contact;
    @SerializedName("location")
    @Expose
    private Location location;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Brewery() {
    }

    /**
     * 
     * @param breweryId
     * @param contact
     * @param location
     * @param countryName
     * @param breweryLabel
     * @param breweryName
     * @param brewerySlug
     * @param breweryType
     * @param breweryPageUrl
     */
    public Brewery(Integer breweryId, String breweryName, String brewerySlug, String breweryType, String breweryPageUrl, String breweryLabel, String countryName, Contact contact, Location location) {
        super();
        this.breweryId = breweryId;
        this.breweryName = breweryName;
        this.brewerySlug = brewerySlug;
        this.breweryType = breweryType;
        this.breweryPageUrl = breweryPageUrl;
        this.breweryLabel = breweryLabel;
        this.countryName = countryName;
        this.contact = contact;
        this.location = location;
    }

    public Integer getBreweryId() {
        return breweryId;
    }

    public void setBreweryId(Integer breweryId) {
        this.breweryId = breweryId;
    }

    public String getBreweryName() {
        return breweryName;
    }

    public void setBreweryName(String breweryName) {
        this.breweryName = breweryName;
    }

    public String getBrewerySlug() {
        return brewerySlug;
    }

    public void setBrewerySlug(String brewerySlug) {
        this.brewerySlug = brewerySlug;
    }

    public String getBreweryType() {
        return breweryType;
    }

    public void setBreweryType(String breweryType) {
        this.breweryType = breweryType;
    }

    public String getBreweryPageUrl() {
        return breweryPageUrl;
    }

    public void setBreweryPageUrl(String breweryPageUrl) {
        this.breweryPageUrl = breweryPageUrl;
    }

    public String getBreweryLabel() {
        return breweryLabel;
    }

    public void setBreweryLabel(String breweryLabel) {
        this.breweryLabel = breweryLabel;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
