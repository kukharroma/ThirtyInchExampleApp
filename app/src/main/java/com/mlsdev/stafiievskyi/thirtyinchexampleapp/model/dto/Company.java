package com.mlsdev.stafiievskyi.thirtyinchexampleapp.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by oleksandr on 23.09.16.
 */

public class Company implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("catchPhrase")
    @Expose
    private String catchPhrase;
    @SerializedName("bs")
    @Expose
    private String bs;

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The catchPhrase
     */
    public String getCatchPhrase() {
        return catchPhrase;
    }

    /**
     *
     * @param catchPhrase
     * The catchPhrase
     */
    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    /**
     *
     * @return
     * The bs
     */
    public String getBs() {
        return bs;
    }

    /**
     *
     * @param bs
     * The bs
     */
    public void setBs(String bs) {
        this.bs = bs;
    }

}