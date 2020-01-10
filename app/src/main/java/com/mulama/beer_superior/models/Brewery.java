
package com.mulama.beer_superior.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel

public class Brewery {

    @SerializedName("brewery_id")
    @Expose
     Integer breweryId;
    @SerializedName("brewery_name")
    @Expose
     String breweryName;
    @SerializedName("brewery_slug")
    @Expose
     String brewerySlug;
    @SerializedName("brewery_page_url")
    @Expose
     String breweryPageUrl;
    @SerializedName("brewery_type")
    @Expose
     String breweryType;
    @SerializedName("brewery_label")
    @Expose
     String breweryLabel;
    @SerializedName("country_name")
    @Expose
     String countryName;
    @SerializedName("contact")
    @Expose
     Contact contact;
    @SerializedName("location")
    @Expose
     Location location;
    @SerializedName("brewery_active")
    @Expose
     Integer breweryActive;

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
     * @param breweryActive
     * @param brewerySlug
     * @param breweryPageUrl
     * @param breweryType
     */
    public Brewery(Integer breweryId, String breweryName, String brewerySlug, String breweryPageUrl, String breweryType, String breweryLabel, String countryName, Contact contact, Location location, Integer breweryActive) {
        super();
        this.breweryId = breweryId;
        this.breweryName = breweryName;
        this.brewerySlug = brewerySlug;
        this.breweryPageUrl = breweryPageUrl;
        this.breweryType = breweryType;
        this.breweryLabel = breweryLabel;
        this.countryName = countryName;
        this.contact = contact;
        this.location = location;
        this.breweryActive = breweryActive;
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

    public String getBreweryPageUrl() {
        return breweryPageUrl;
    }

    public void setBreweryPageUrl(String breweryPageUrl) {
        this.breweryPageUrl = breweryPageUrl;
    }

    public String getBreweryType() {
        return breweryType;
    }

    public void setBreweryType(String breweryType) {
        this.breweryType = breweryType;
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

    public Integer getBreweryActive() {
        return breweryActive;
    }

    public void setBreweryActive(Integer breweryActive) {
        this.breweryActive = breweryActive;
    }

}
