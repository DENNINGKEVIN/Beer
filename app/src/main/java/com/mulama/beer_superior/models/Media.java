
package com.mulama.beer_superior.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Media {

    @SerializedName("count")
    @Expose
     Integer count;
    @SerializedName("items")
    @Expose
     List<Item> items = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Media() {
    }

    /**
     * 
     * @param count
     * @param items
     */
    public Media(Integer count, List<Item> items) {
        super();
        this.count = count;
        this.items = items;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
