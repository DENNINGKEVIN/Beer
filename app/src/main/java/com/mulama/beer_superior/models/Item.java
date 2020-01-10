
package com.mulama.beer_superior.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel

public class Item {

    @SerializedName("checkin_count")
    @Expose
     Integer checkinCount;
    @SerializedName("have_had")
    @Expose
     Boolean haveHad;
    @SerializedName("your_count")
    @Expose
     Integer yourCount;
    @SerializedName("beer")
    @Expose
     Beer beer;
    @SerializedName("brewery")
    @Expose
     Brewery brewery;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Item() {
    }

    /**
     * 
     * @param checkinCount
     * @param brewery
     * @param yourCount
     * @param beer
     * @param haveHad
     */
    public Item(Integer checkinCount, Boolean haveHad, Integer yourCount, Beer beer, Brewery brewery) {
        super();
        this.checkinCount = checkinCount;
        this.haveHad = haveHad;
        this.yourCount = yourCount;
        this.beer = beer;
        this.brewery = brewery;
    }

    public Integer getCheckinCount() {
        return checkinCount;
    }

    public void setCheckinCount(Integer checkinCount) {
        this.checkinCount = checkinCount;
    }

    public Boolean getHaveHad() {
        return haveHad;
    }

    public void setHaveHad(Boolean haveHad) {
        this.haveHad = haveHad;
    }

    public Integer getYourCount() {
        return yourCount;
    }

    public void setYourCount(Integer yourCount) {
        this.yourCount = yourCount;
    }

    public Beer getBeer() {
        return beer;
    }

    public void setBeer(Beer beer) {
        this.beer = beer;
    }

    public Brewery getBrewery() {
        return brewery;
    }

    public void setBrewery(Brewery brewery) {
        this.brewery = brewery;
    }

}
