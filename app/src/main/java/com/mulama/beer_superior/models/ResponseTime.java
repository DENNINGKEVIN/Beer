
package com.mulama.beer_superior.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseTime {

    @SerializedName("time")
    @Expose
    private Double time;
    @SerializedName("measure")
    @Expose
    private String measure;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ResponseTime() {
    }

    /**
     * 
     * @param measure
     * @param time
     */
    public ResponseTime(Double time, String measure) {
        super();
        this.time = time;
        this.measure = measure;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

}
