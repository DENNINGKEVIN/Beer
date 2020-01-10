
package com.mulama.beer_superior.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel

public class Meta {

    @SerializedName("code")
    @Expose
     Integer code;
    @SerializedName("response_time")
    @Expose
     ResponseTime responseTime;
    @SerializedName("init_time")
    @Expose
     InitTime initTime;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Meta() {
    }

    /**
     * 
     * @param code
     * @param responseTime
     * @param initTime
     */
    public Meta(Integer code, ResponseTime responseTime, InitTime initTime) {
        super();
        this.code = code;
        this.responseTime = responseTime;
        this.initTime = initTime;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public ResponseTime getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(ResponseTime responseTime) {
        this.responseTime = responseTime;
    }

    public InitTime getInitTime() {
        return initTime;
    }

    public void setInitTime(InitTime initTime) {
        this.initTime = initTime;
    }

}
