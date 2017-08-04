
package com.example.admin.rtr.ModelHistoricCall;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhoneNumList {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("label")
    @Expose
    private String label;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
