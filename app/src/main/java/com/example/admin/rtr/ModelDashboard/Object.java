
package com.example.admin.rtr.ModelDashboard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Object {

    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("value_type")
    @Expose
    private String valueType;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("value")
    @Expose
    private Long value;
    @SerializedName("id")
    @Expose
    private String id;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
