
package com.mulama.beer_superior.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stats {

    @SerializedName("total_count")
    @Expose
    private Integer totalCount;
    @SerializedName("monthly_count")
    @Expose
    private Integer monthlyCount;
    @SerializedName("total_user_count")
    @Expose
    private Integer totalUserCount;
    @SerializedName("user_count")
    @Expose
    private Integer userCount;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Stats() {
    }

    /**
     * 
     * @param totalUserCount
     * @param userCount
     * @param monthlyCount
     * @param totalCount
     */
    public Stats(Integer totalCount, Integer monthlyCount, Integer totalUserCount, Integer userCount) {
        super();
        this.totalCount = totalCount;
        this.monthlyCount = monthlyCount;
        this.totalUserCount = totalUserCount;
        this.userCount = userCount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getMonthlyCount() {
        return monthlyCount;
    }

    public void setMonthlyCount(Integer monthlyCount) {
        this.monthlyCount = monthlyCount;
    }

    public Integer getTotalUserCount() {
        return totalUserCount;
    }

    public void setTotalUserCount(Integer totalUserCount) {
        this.totalUserCount = totalUserCount;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

}
