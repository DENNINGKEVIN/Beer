
package com.mulama.beer_superior.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel

public class Location {

    @SerializedName("brewery_city")
    @Expose
     String breweryCity;
    @SerializedName("brewery_state")
    @Expose
     String breweryState;
    @SerializedName("lat")
    @Expose
     Double lat;
    @SerializedName("lng")
    @Expose
    Double lng;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Location() {
    }

    /**
     * 
     * @param lng
     * @param breweryCity
     * @param breweryState
     * @param lat
     */
    public Location(String breweryCity, String breweryState, Double lat, Double lng) {
        super();
        this.breweryCity = breweryCity;
        this.breweryState = breweryState;
        this.lat = lat;
        this.lng = lng;
    }

    public String getBreweryCity() {
        return breweryCity;
    }

    public void setBreweryCity(String breweryCity) {
        this.breweryCity = breweryCity;
    }

    public String getBreweryState() {
        return breweryState;
    }

    public void setBreweryState(String breweryState) {
        this.breweryState = breweryState;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

}
