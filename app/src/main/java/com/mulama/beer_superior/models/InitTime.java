
package com.mulama.beer_superior.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InitTime {

    @SerializedName("time")
    @Expose
    private Integer time;
    @SerializedName("measure")
    @Expose
    private String measure;

    /**
     * No args constructor for use in serialization
     * 
     */
    public InitTime() {
    }

    /**
     * 
     * @param measure
     * @param time
     */
    public InitTime(Integer time, String measure) {
        super();
        this.time = time;
        this.measure = measure;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

}
