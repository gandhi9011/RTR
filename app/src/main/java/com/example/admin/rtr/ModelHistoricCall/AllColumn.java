
package com.example.admin.rtr.ModelHistoricCall;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllColumn {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("title")
    @Expose
    private String title;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
