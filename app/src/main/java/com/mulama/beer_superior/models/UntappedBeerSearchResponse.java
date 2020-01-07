
package com.mulama.beer_superior.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UntappedBeerSearchResponse {

    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("notifications")
    @Expose
    private List<Object> notifications = null;
    @SerializedName("response")
    @Expose
    private Response response;

    /**
     * No args constructor for use in serialization
     * 
     */
    public UntappedBeerSearchResponse() {
    }

    /**
     * 
     * @param meta
     * @param response
     * @param notifications
     */
    public UntappedBeerSearchResponse(Meta meta, List<Object> notifications, Response response) {
        super();
        this.meta = meta;
        this.notifications = notifications;
        this.response = response;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<Object> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Object> notifications) {
        this.notifications = notifications;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

}
