
package com.mulama.beer_superior.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel

public class Response {

    @SerializedName("message")
    @Expose
     String message;
    @SerializedName("time_taken")
    @Expose
     Double timeTaken;
    @SerializedName("brewery_id")
    @Expose
     Integer breweryId;
    @SerializedName("search_type")
    @Expose
     String searchType;
    @SerializedName("type_id")
    @Expose
     Integer typeId;
    @SerializedName("search_version")
    @Expose
     Integer searchVersion;
    @SerializedName("found")
    @Expose
     Integer found;
    @SerializedName("offset")
    @Expose
     Integer offset;
    @SerializedName("limit")
    @Expose
     Integer limit;
    @SerializedName("term")
    @Expose
     String term;
    @SerializedName("parsed_term")
    @Expose
     String parsedTerm;
    @SerializedName("beers")
    @Expose
     Beers beers;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Response() {
    }

    /**
     * 
     * @param timeTaken
     * @param found
     * @param offset
     * @param searchType
     * @param breweryId
     * @param beers
     * @param limit
     * @param parsedTerm
     * @param typeId
     * @param term
     * @param message
     * @param searchVersion
     */
    public Response(String message, Double timeTaken, Integer breweryId, String searchType, Integer typeId, Integer searchVersion, Integer found, Integer offset, Integer limit, String term, String parsedTerm, Beers beers) {
        super();
        this.message = message;
        this.timeTaken = timeTaken;
        this.breweryId = breweryId;
        this.searchType = searchType;
        this.typeId = typeId;
        this.searchVersion = searchVersion;
        this.found = found;
        this.offset = offset;
        this.limit = limit;
        this.term = term;
        this.parsedTerm = parsedTerm;
        this.beers = beers;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Double getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(Double timeTaken) {
        this.timeTaken = timeTaken;
    }

    public Integer getBreweryId() {
        return breweryId;
    }

    public void setBreweryId(Integer breweryId) {
        this.breweryId = breweryId;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getSearchVersion() {
        return searchVersion;
    }

    public void setSearchVersion(Integer searchVersion) {
        this.searchVersion = searchVersion;
    }

    public Integer getFound() {
        return found;
    }

    public void setFound(Integer found) {
        this.found = found;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getParsedTerm() {
        return parsedTerm;
    }

    public void setParsedTerm(String parsedTerm) {
        this.parsedTerm = parsedTerm;
    }

    public Beers getBeers() {
        return beers;
    }

    public void setBeers(Beers beers) {
        this.beers = beers;
    }

}
